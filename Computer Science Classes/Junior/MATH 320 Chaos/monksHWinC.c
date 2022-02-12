#include <time.h>
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <float.h>

void uptoANumber(float n);
void exactNumber(float n);

int main() {
    short choice;
    float n;
    printf("type: 1, exact number || 2, up to a number: ");
    scanf("%hd", &choice);

    printf("what number: ");
    scanf("%f", &n);
    clock_t t = clock();
    if (choice == 1) {
        exactNumber(n);
    } else {
        uptoANumber(n);
    }
    t = clock() - t;
    double time_taken = ((double)t)/CLOCKS_PER_SEC; 
    printf("\n%fs\n", time_taken);
}

void exactNumber (float n) {
    float x = n;
    printf("[ %f, ", x);
    while(x != 1.0 && x != 2.0) {
        if (fmod(x, 2.0) == 0) {
            x = x / 2;
        } else {
            x = ((3 * x) + 1) / 2;
        }
        printf("%f, ", x);
    }
    printf("]");
}

void uptoANumber(float n) {
    clock_t t = clock();

    FILE *fp;
    fp = fopen("Output.txt", "w+");

    float x = 1.0;
    while(x != n) {
        double temp = n;
        fprintf(fp, "[%f", temp);
        while(temp != 1.0 && temp != 2.0) {
            if (fmod(x, 2.0) == 0) {
                temp = temp / 2;
            } else {
                temp = ((3 * temp) + 1) / 2;
            }
            fprintf(fp, "%f, ", temp);
        }
        fprintf(fp, "]\n");
        x++;
    }
    fclose(fp);
}

