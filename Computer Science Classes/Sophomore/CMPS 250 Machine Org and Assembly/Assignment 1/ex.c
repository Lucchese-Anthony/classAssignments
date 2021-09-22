	char *line, correctFormat[7];
	int length;
	FILE *fptr;
	fptr = fopen(argv[1], "r");
	if (fptr != NULL) { //to see if there isnt anything in the file or if it even opens
		if(ScompareTo(SsubStr(argv[1], Slength(line) - 2, Slength(line) - 1), "s")) { 
			//if file is a pep2 or an intel
			do {
				line = nextLine(fptr, MAX_LENGTH);
				Strim(line);
				length = Slength(line);
				while (length > 0) {
					printf("%s\n",line);
				}
				free(line);
			} while (length > 0);
		}	
	}
	fclose(fptr);