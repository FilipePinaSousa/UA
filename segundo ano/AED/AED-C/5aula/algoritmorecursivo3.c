#include <stdio.h>
#include <assert.h>
size_t N_CALLS;
int algoritmorecursivo3(int n) {
    assert(n > 0);
    N_CALLS++;

    if (n == 1) {
        return 1;
    } else if (n %2 == 1) {
        return algoritmorecursivo3(n / 2 ) + algoritmorecursivo3((n + 1) / 2) + n;
    } else {
        return algoritmorecursivo3(n / 2) * 2;
    }
}

int main(void) {
    size_t n = 0, r = 0;

    printf("Valor de n (inteiro nao-negativo): ");

    scanf("%ld", &n);

    printf("\nCalculo do valor da recorrencia 1:\n\n");

    for (size_t i = 1; i <= n; i++) {

        N_CALLS = 0;

        r = algoritmorecursivo3(n);

        printf("T\(%3ld) = %6ld", i, r);

        printf(" --- Numero de chamadas recursivas = %3ld\n", N_CALLS);
    }

    printf("\n\n");

    return 0;
}

