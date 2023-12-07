#include <stdio.h>

int binary_search(int *a, int n, int d) {
    int lo = 0;
    int hi = n - 1;

    while (lo <= hi) {
        int middle = lo + (hi - lo) / 2; // Evita estouro de inteiro
        if (a[middle] == d)
            return middle; // encontrado
        if (a[middle] < d)
            lo = middle + 1; // ajuste o limite inferior
        else
            hi = middle - 1; // ajuste o limite superior
    }

    return -1; // não encontrado
}

int main(void) {
    int a[8] = { 1, 3, 8, 11, 18, 19, 23, 27 };
    int d;

    for (d = 0; d <= 30; d++) {
        int i = binary_search(a, 8, d);
        if (i < 0)
            printf("%d not found\n", d);
        else
            printf("the index of %d is %d\n", d, i);
    }
    return 0;
}
