// Anthony Lucchese
// CMPS 250 Prof. Jackowitz
// Due: February 28 2021
// Collaborated with:

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h> //isUpper(); and isLower();

#include "Strings.h"

#define OPERATOR 4
#define SEMICOLON ";"
#define COLON ":"
#define MAX_LENGTH 80
#define NC "\0"

// minimum 22 characters
// 4 character main / loop
// 6 character space
// 4 character operator
// x character operand
// x comment

/*void properFormatting(char *line, int length, char **label, char **operator, char **operand, char **comment) {
	int colonNum = SindexOf(line, ':');

	*label = SsubStr(line, 0, colonNum + 1);

	*operator = SsubStr(line, 0, 1);

	*operand = SsubStr(line, 0, 1);

	int commentNum = SindexOf(line, '/');
	*comment = SsubStr(line, 0, commentNum);
	
	if (*label == NULL) {
		emptyString(&label);
	}
	if (*operand == NULL) {
		emptyString(&operand);
	}
	if (*operator == NULL) {
		emptyString(&operator);
	}
	if (*comment == NULL) {
		emptyString(&comment);
	}
}
*/

int main(int argc, char **argv) {
   char *line;
   int length;
   if(argc > 1) {  //Check to make sure the run-time argument is present
     	FILE *fptr;
     	fptr = fopen(argv[1],"r");
     	if(fptr != NULL) {  ///Check to make sure the file has been opened
       		do {
				line = nextLine(fptr,MAX_LENGTH);
				length = Slength(line);
				if (length > 0){
         			Strim(line);
					char *label, *operator, *operand, *comment;
					//properFormatting(line, length, &label, &operator, &operand, &comment);
					int colonNum = SindexOf(line, ':');
					label = SsubStr(line, 0, colonNum + 1);

					operator = SsubStr(line, 0, 1);

					operand = SsubStr(line, 0, 1);

					int commentNum = SindexOf(line, '/');
					comment = SsubStr(line, 0, commentNum);
					
					if (SsubStr(line, 0, 1) == "/") {
							printf("%s", line);) {
						printf("%-11s,%-6s,%-10s,%-7s\n", label, operator, operand, comment);
					} else { printf("%s\n", line); }
					free(label);
					free(operator);
					free(operand);
					free(comment);
				}
         		free(line);
       		} while (length > 0);
       		fclose(fptr);
     	} else {
       		printf("--->ERROR: unable to open file named \"%s\"\n",argv[1]);
     	}
    } else {
     	printf("--->ERROR: Required filename argument missing\n");
   	}
}





/*
if (SsubStr(line, 0, 1) == "/") {
							printf("%s", line);
						} else {
							printf("%s\t%s\t%d\n", line, SsubStr(line, 0, 1), one);
							//printf("%11s%6s%10s%s",label, operator, operand, comment);
						}
*/