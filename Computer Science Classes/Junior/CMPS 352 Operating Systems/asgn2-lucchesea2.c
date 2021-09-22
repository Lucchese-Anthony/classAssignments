/* program name and stuff

*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct JOB {
	char programName[25];
	int submissionTime;
	int startTime;
	struct JOB *prev;
	struct JOB *next;
};

typedef struct JOB Job;

typedef struct LIST {
	int numOfJobs;
	Job *headJob;
	Job *tailJob;
} List;


Job *createJob();
void printJob(Job *JobPtr, int jobCount);
List *createList();
void appendJob(List *listPtr, Job *jobPtr);
void printList(List *listPtr);

int main() {
	List *listPtr;

	listPtr = createList();

	int jobAmount;
	printf("How many Jobs: ");
	scanf("%d", &jobAmount);

	//create (input) amount of Jobs and add them to the list
	for (int i = 0; i < jobAmount; i++) {
		Job *jobPtr = createJob();
		appendJob(listPtr, jobPtr);
	}

	printList(listPtr);
}
Job *createJob() {
	char programInput[25];
	int subInput;
	int startInput;

	printf("Enter a command: ");
	scanf("%s", programInput);
	Job *jobPtr = (Job*)malloc(sizeof(Job));
	memcpy(jobPtr->programName, programInput, 24); 
	//issues assigning a char array to a value inside a struct
	
	printf("Enter a submission time: ");
	scanf("%d", &subInput);
	jobPtr->submissionTime = subInput;
	printf("Enter a start time: ");
	scanf("%d", &startInput);
	jobPtr->startTime = startInput;

	return jobPtr;
}

List *createList() {
	List *listPtr = (List*)malloc(sizeof(List));
	listPtr->numOfJobs = 0;
	listPtr->headJob = NULL;
	listPtr->tailJob = NULL;

	return listPtr;
}
/*
void insertJob(List *listPtr, Job *newPtr) {
	if (listPtr->numOfJobs == 0) {
		// empty list
		newPtr->prev = NULL;
		newPtr->next = NULL;
		
		listPtr->headJob = newPtr;
		listPtr->tailJob = newPtr;

	} else {
		// >= 1 node
		newPtr->prev = NULL;
		newPtr->next = listPtr->first;

		listPtr->first = newPtr;
	}
	listPtr->count++
}
*/
void appendJob(List *listPtr, Job *jobPtr) {
	if (listPtr->numOfJobs == 0) {
		// no jobs on the list
		newPtr->prev = NULL;
		newPtr->next = NULL;

		listPtr->headJob = jobPtr;
		listPtr->tailJob = jobPtr;
		//printf("the first job has been created...\n");

	} else {
		//1 or more nodes
		//printf("the second job is being created..., current tail is: name: %s, subm: %d, start: %d \n", listPtr->tailJob->programName, listPtr->tailJob->submissionTime, listPtr->tailJob->startTime);
		
		jobPtr->next = NULL;
		jobPtr->prev = listPtr->tailJob;

		listPtr->tailJob->next = jobPtr;

		listPtr->tailJob = jobPtr;

		//printf("the second job has been created..., current tail is: name %s, subm: %d, start: %d\n", listPtr->tailJob->programName, listPtr->tailJob->submissionTime, listPtr->tailJob->startTime);
		//printf("the second job is: %s", listPtr->tailJob->next);

	}
	listPtr->numOfJobs++;
}



void printList(List *listPtr) {
	if (listPtr->numOfJobs==0){
		printf("Empty list!\n");
	} else {
		//printf("the head link is: %s and the tail is : %s", listPtr->headJob->programName, listPtr->tailJob->programName);

		printf("\n# of jobs: %d\n", listPtr->numOfJobs);
		Job *ptr = listPtr->headJob;
		for (int i = 0; i < listPtr->numOfJobs; i++) {
			printJob(ptr, i+1);
			ptr = ptr->next;
		}

		ptr = listPtr->tailJob;
		printf("\nReverse Order:\n");
		for (int i = listPtr->numOfJobs; i != 0; i--) {
			printJob(ptr, (listPtr->numOfJobs - (i-1)));
			ptr = ptr->prev;
		}
	}
}

void printJob(Job *jobPtr, int jobCount) {
	printf("Job %d:\n", jobCount);
	printf("program Name: %s\n", jobPtr->programName);
	printf("submission Time: %d\n", jobPtr->submissionTime);
	printf("start Time: %d\n", jobPtr->startTime);
}