#include <stdio.h>
#include <stdlib.h>

int main(void) {
    const size_t limit = 1000000;
    int *sieve = (int *)malloc((limit + 1) * sizeof(int));
    if (sieve == NULL)
        return 1;

    for (size_t i = 0; i <= limit; i++)
        sieve[i] = 0;

    sieve[0] = sieve[1] = 1; // 0 e 1 nao são primos

    for (int p = 2; p * p <= limit; p++)
        if (sieve[p] == 0)
            for (int i = p * p; i <= limit; i += p)
                sieve[i] = 1; // i não é primo

    int c = 0;
    for (size_t i = 0; i <= limit; i++)
        if (sieve[i] == 0)
            c++;

    printf("There are %d prime numbers up to %zu\n", c, limit);

    free(sieve);
    return 0;
}
