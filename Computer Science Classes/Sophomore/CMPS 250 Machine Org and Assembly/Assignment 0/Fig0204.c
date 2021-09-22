// Stan Warford
// A nonsense program to illustrate global variables

#include <stdio.h>

char ch;
int j;

int main() {
	scanf("%c %d", &ch, &j);
	j += 5;
	ch++;
	printf("%c\n%d\n", ch, j);
	return 0;
}