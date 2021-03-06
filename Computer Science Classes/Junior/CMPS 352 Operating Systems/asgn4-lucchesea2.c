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
	Job *first;
	Job *last;
} List;

Job *createJob();
Job *deleteFirstJob(List *listPtr);
void printJob(Job *JobPtr);
List *createList();
void printList(List *listPtr);
void insertOrdered(List *listPtr, Job *jobPtr);
//init methods/functions that appear later in the code

int main() {
	long programStart = time(NULL);
	List *listPtr;
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
	printf("program started at: %ld", programStart);
	printList(listPtr);
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
	listPtr->first = NULL;
	listPtr->last = NULL;
	return listPtr;
}

void appendJob(List *listPtr, Job *jobPtr) {
		jobPtr->next = NULL;
		jobPtr->prev = listPtr->last;
		listPtr->last->next = jobPtr;
		listPtr->last = jobPtr;
}

void initializeFirstLastJob(List *listPtr, Job *jobPtr) {
	listPtr->first = jobPtr;
	listPtr->last = jobPtr;
	jobPtr->next = NULL;
	jobPtr->prev = NULL;
}

void replaceFirstNode(List *listPtr, Job *jobPtr) {
	jobPtr->next = listPtr->first;
	jobPtr->prev = NULL;
	listPtr->first->prev = jobPtr;		
	listPtr->first = jobPtr;
}

void insertInMiddle(List *listPtr, Job *jobPtr, int count) {
	//there are more 2 or more nodes, and have to find where it goes in 
	//between the head and tail
	Job *iterPtr = (Job*)malloc(sizeof(Job));
	iterPtr = listPtr->first;
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
		initializeFirstLastJob(listPtr, jobPtr);
	} else if (count<=listPtr->first->submissionTime+listPtr->first->startTime){
		replaceFirstNode(listPtr, jobPtr);
	} else if (count>=listPtr->last->submissionTime+listPtr->last->startTime){
		appendJob(listPtr, jobPtr);
	} else {
		insertInMiddle(listPtr, jobPtr, count);
	}
	listPtr->numOfJobs++;
}

Job *deleteFirstJob(List *listPtr) {
	Job *newPtr = listPtr->first;
	if (listPtr->numOfJobs == 1) {
		//if the deleted node is the only one,
		//then remove it and reset all head/tail pointers
		printJob(listPtr->first);
		listPtr->last = NULL;
		listPtr->first = NULL;
		listPtr->numOfJobs = 0;
		listPtr->first->prev = NULL;
	} else if (listPtr->numOfJobs > 1){
		//if there are more than 1,
		//then delete the first one and reset the tail
		printJob(listPtr->first);
		listPtr->first = listPtr->first->next;
		listPtr->first->prev = NULL;

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
		Job *ptr = listPtr->first;
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