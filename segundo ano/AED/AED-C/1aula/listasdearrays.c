#include <stdio.h>

int main() {
    int a[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    double b[10];

    printf("Initial array:\n");
    for (int i = 0; i < 12; i++) {
        printf("%d ", a[i]);
    }
    printf("\n");

    fadd(b, a);

    printf("Final array:\n");
    for (int i = 0; i < 10; i++) {
        printf("%.1lf ", b[i]);
    }
    printf("\n");

    return 0;
}


void fadd(double a[static 10], const double b[static 10]) {
    for (int i = 0; i < 10; i++) {
        if (b[i] < 0.0) {
            printf("Error: negative value detected\n");
            return;
        }
        a[i] += b[i];
    }
}


