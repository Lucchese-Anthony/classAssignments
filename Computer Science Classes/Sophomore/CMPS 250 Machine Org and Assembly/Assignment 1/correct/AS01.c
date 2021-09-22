// Anthony Lucchese
// CMPS 250 Prof. Jackowitz
// Due: February 28 2021
// Collaborated with:

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h> //isupper(); and islower(); and isspace();

#include "Strings.h"

#define OPERATOR 4
#define SEMICOLON ";"
#define COLON ":"
#define MAX_LENGTH 80
#define NC "\0"

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
                Strim(line);
				if ((length > 0 || SindexOf(line, '/') != 0) && SindexOf(line, ';') == -1){

                    const char s[2] = " ";

                    char* token;
                    char *pointer;
                    token = strtok(line, s);
                    int inc = 0;
                    while (token != NULL) {
                        
                        if(SindexOf(token, '.') == 0 && inc == 0){
                            printf("\t%s\t", token);
                        } else if (SindexOf(line, '/') > 0 && inc >= 1) {
                            printf("%s ", token);
                        } else if (SindexOf(line, ':') == -1&& inc == 0) {
                            printf("\t%s\t", token);
                            
                        } else {
                            printf("%s\t", token);
                        }

                        token = strtok(NULL, s);

                        inc++;

                        
                    }
				} else {
                    printf("%s", line);
                }
                puts("");
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