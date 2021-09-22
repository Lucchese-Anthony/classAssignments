/* 	Author:			Anthony Lucchese
	Program Name:	asgn3-lucchesea2.c
	Compile and run:gcc -o asgn3 asgn3.lucchesea2.c

	Description:	This program is built upon the previous assignment, 
					doubly linked list but adds a delete function, and 
					a situational insert function.
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <unistd.h>
#include <sys/wait.h>

struct JOB {
	//init Job struct
	char command[5][25];
	long submissionTime;
	int startTime;
	struct JOB *prev;
	struct JOB *next;
};

typedef struct JOB Job;

typedef struct LIST {
	//init list struct
	int numOfJobs;
	Job *firstJob;
	Job *last;
} List;

Job *createJob();
Job *deleteFirstJob(List *listPtr);
void printJob(Job *JobPtr);
List *createList();
void printList(List *listPtr);
void insertOrdered(List *listPtr, Job *jobPtr);
void createProcess();
//init methods/functions that appear later in the code

int main() {
	List *listPtr;
	long initStartTime = time(NULL);
	listPtr = createList();
	char input;
	while (input != '!') {
		//pretty much a input listener, ends if !, del if -, and add if +
		scanf("%c", &input);
		if (input == '+') {
			Job *jobPtr = createJob();
			insertOrdered(listPtr, jobPtr);	
		} else if (input == '-') {
			deleteFirstJob(listPtr);
		}
	}
	Job *nextJob = NULL;
	while (listPtr->first != NULL) {
   		currentSysTime = time(NULL);
   		nextJob = listPtr->firstJob;
   		if (currentSysTime >= nextJob->submissionTime + nextJob->startTime) {
      		printf("Sys Time: %ld\n", currentSysTime);
      		deleteFirstJob(listPtr);
      		printJob(nextJob);

      		createProcess();

      		// start the job as a new process
      		// wait for the job to complete
   		} else {
      		sleep(1);
   		}
	}
	printf("program started at: %ld", initStartTime);
	printList(listPtr);
}

void createProcess() {
	int parent_pid, child_pid;
	int status = 999;
	int i;

	parent_pid = getpid();
	printf("the running process ID: %d\n", parent_pid);

	if ((child_pid = fork()) != 0){
		waitpid(child_pid, &status, WEXITED);
		printf("child status: %d\n", status);
		printf("Parent PID: %d created a child %d\n", getpid(), child_pid);
		for (int i=0; i<5; i++) {
			printf("Parent Prints: %d\n", i + 100);
		}
		printf("Parent exits!\n");
	} else {
		printf("Child PID: %d\n", getpid());
		for(i = 0; i < 5; i++) {
			printf("CHild prints: %d\n", i + 200);
		}
		printf("Child exits!\n");
		exit(EXIT_SUCCESS);
	}
}
Job *createJob() {
	//simplified createJob function
	Job *jobPtr = (Job*)malloc(sizeof(Job));
	int input;
	scanf("%d", &input);
	for (int i = 0; i < input; i++) {
		scanf("%s", jobPtr->command[i]);
	}
	if (input <= 5) {
		memcpy(jobPtr->command[input], "/NULL", 25);
	} 
	scanf("%d", &jobPtr->startTime);
	jobPtr->submissionTime = time(NULL);
	return jobPtr;
}

List *createList() {
	//init the list
	List *listPtr = (List*)malloc(sizeof(List));
	listPtr->numOfJobs = 0;
	listPtr->firstJob = NULL;
	listPtr->last = NULL;
	return listPtr;
}

void appendJob(List *listPtr, Job *jobPtr) {
		jobPtr->next = NULL;
		jobPtr->prev = listPtr->last;
		listPtr->last->next = jobPtr;
		listPtr->last = jobPtr;
}

void initializefirstJobLastJob(List *listPtr, Job *jobPtr) {
	listPtr->firstJob = jobPtr;
	listPtr->last = jobPtr;
	jobPtr->next = NULL;
	jobPtr->prev = NULL;
}

void replacefirstJobNode(List *listPtr, Job *jobPtr) {
	jobPtr->next = listPtr->firstJob;
	jobPtr->prev = NULL;
	listPtr->firstJob->prev = jobPtr;		
	listPtr->firstJob = jobPtr;
}

void insertInMiddle(List *listPtr, Job *jobPtr, int count) {
	//there are more 2 or more nodes, and have to find where it goes in 
	//between the head and tail
	Job *iterPtr = (Job*)malloc(sizeof(Job));
	iterPtr = listPtr->firstJob;
	while (count >= (iterPtr->submissionTime + iterPtr->startTime) ) {
		iterPtr = iterPtr->next;
	}
	jobPtr->next = iterPtr;
	jobPtr->prev = iterPtr->prev;

	iterPtr->prev->next = jobPtr;
	iterPtr->prev = jobPtr;
}

void insertOrdered(List *listPtr, Job *jobPtr) {
	int count = jobPtr->startTime + jobPtr->submissionTime;
	if (listPtr->numOfJobs == 0) {
		initializefirstJobLastJob(listPtr, jobPtr);
	} else if (count<=listPtr->firstJob->submissionTime+listPtr->firstJob->startTime){
		replacefirstJobNode(listPtr, jobPtr);
	} else if (count>=listPtr->last->submissionTime+listPtr->last->startTime){
		appendJob(listPtr, jobPtr);
	} else {
		insertInMiddle(listPtr, jobPtr, count);
	}
	listPtr->numOfJobs++;
}

Job *deleteFirstJob(List *listPtr) {
	Job *newPtr = listPtr->firstJob;
	if (listPtr->numOfJobs == 1) {
		//if the deleted node is the only one,
		//then remove it and reset all head/tail pointers
		printJob(listPtr->firstJob);
		listPtr->last = NULL;
		listPtr->firstJob = NULL;
		listPtr->numOfJobs = 0;
		listPtr->firstJob->prev = NULL;
	} else if (listPtr->numOfJobs > 1){
		//if there are more than 1,
		//then delete the firstJob one and reset the tail
		printJob(listPtr->firstJob);
		listPtr->firstJob = listPtr->firstJob->next;
		listPtr->firstJob->prev = NULL;

		listPtr->numOfJobs--;
	} else {
		//self explanatory below
		return NULL;
	}
	return newPtr;
}

void printList(List *listPtr) {
	if (listPtr->numOfJobs==0){
		printf("Empty list!\n");
	} else {

		printf("\n# of jobs: %d\n", listPtr->numOfJobs);
		Job *ptr = listPtr->firstJob;
		for (int i = 0; i < listPtr->numOfJobs; i++) {
			printf("Job %d:\n", i+1);
			printJob(ptr);
			ptr = ptr->next;
		}
	}
}

void printJob(Job *jobPtr) {
	printf("program Name:");
	int iter = 0;
	while(strcmp(jobPtr->command[iter], "/NULL") != 0) {
		printf(" %s", jobPtr->command[iter]);
		iter++;
	}
	printf("\nsubmission Time: %ld\n", jobPtr->submissionTime);
	printf("start Time: %d\n", jobPtr->startTime);
}