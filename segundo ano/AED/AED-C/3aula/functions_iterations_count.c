//Função f1
#include "stdio.h"




unsigned int f1(unsigned int n) {
    unsigned int r = 0;
    for (unsigned int i = 1; i <= n; i++) {
        r += 1;
    }
    return r;
}

//Esta função possui um único loop que executa n vezes.
//Portanto, sua complexidade é O(n).
// A expressão para o número de iterações é f1(n) = n.
//Função f2



unsigned int f2(unsigned int n) {
    unsigned int r = 0;
    for (unsigned int i = 1; i <= n; i++) {
        for (unsigned j = 1; j <= i; j++) {
            r += 1;
        }
    }
    return r;
}

//Nesta função, temos um loop externo que executa n vezes e um loop interno que executa i vezes,
// onde i varia de 1 a n. Isso resulta em uma complexidade de O(n^2).
// A expressão para o número de iterações é f2(n) = n*(n+1)/2.
//Função f3



unsigned int f3(unsigned int n) {
    unsigned int r = 0;
    for (unsigned int i = 1; i <= n; i++) {
        for (unsigned int j = 1; j <= n; j++) {
            r += 1;
        }
    }
    return r;
}

//Esta função possui dois loops aninhados,
// ambos executando n vezes. Portanto, sua complexidade é O(n^2).
// A expressão para o número de iterações é f3(n) = n^2.
//Função f4



unsigned int f4(unsigned int n) {
    unsigned int r = 0;
    for (unsigned int i = 1; i <= n; i++) {
        for (unsigned int j = 1; j <= i; j++) {
            for (unsigned int k = 1; k <= j; k++) {
                r += 1;
            }
        }
    }
    return r;
}

//Nesta função, temos três loops aninhados,
// cada um executando no máximo n vezes.
// Isso resulta em uma complexidade de O(n^3).
// A expressão para o número de iterações é f4(n) = n*(n+1)*(n+2)/6.
//Função f5



unsigned int f5(unsigned int n) {
    unsigned int r = 0;
    for (unsigned int i = 1; i <= n; i++) {
        for (unsigned int j = 1; j <= n; j++) {
            for (unsigned int k = 1; k <= n; k++) {
                r += 1;
            }
        }
    }
    return r;
}

//Esta função possui três loops aninhados,
// cada um executando no máximo n vezes. Portanto,
// sua complexidade é O(n^3).
// A expressão para o número de iterações é f5(n) = n^3.
//Função f6



unsigned int f6(unsigned int n) {
    unsigned int r = 0;
    for (unsigned int i = n; i > 0; i /= 2) {
        r += 1;
    }
    return r;
}

//Nesta função, o loop executa enquanto i for maior que 0,
// e a cada iteração, i é dividido por 2. Isso é uma iteração logarítmica,
// portanto, a complexidade é O(log n).
// A expressão para o número de iterações depende do valor de n,mas é logarítmica.
//Função f7



unsigned int f7(unsigned int n) {
    unsigned int r = 0;
    unsigned int last = 1;
    for (unsigned int i = 1; i <= n; i++) {
        for (unsigned int j = 1; j <= last; j++) {
            r += 1;
        }
        last *= 2;
    }
    return r;
}

//Esta função possui dois loops aninhados,
// um deles com um número de iterações que dobra a cada iteração do loop externo.
// Isso resulta em uma complexidade de O(n log n).
// A expressão para o número de iterações não é trivial,
// mas está relacionada com log2(n).




int main(void) {
    unsigned int n;
    unsigned int result;
    unsigned int previous;
    double ratio;

    unsigned int start_n = 25;
    unsigned int end_n = 1000;

    printf("\n f1 \n");
    printf("      n       f1(n)   f1(n)/f1(n/2)\n");
    printf("-------  ----------  --------------\n");

    for (n = start_n; n < end_n; n *= 2) {
        result = f1(n);
        printf("%7u  %10u", n, result);

        if (n > start_n) {
            ratio = (double)result / (double)previous;
            printf("  %14.5f", ratio);
        }

        printf("\n");

        previous = result;
    }

    printf("-------  ----------  --------------\n");

    printf("\n f2 \n");
    printf("      n       f2(n)   f2(n)/f2(n/2)\n");
    printf("-------  ----------  --------------\n");

    for (n = start_n; n < end_n; n *= 2) {
        result = f2(n);
        printf("%7u  %10u", n, result);

        if (n > start_n) {
            ratio = (double)result / (double)previous;
            printf("  %14.5f", ratio);
        }

        printf("\n");

        previous = result;
    }

    printf("-------  ----------  --------------\n");

    printf("\n f3 \n");
    printf("      n       f3(n)   f3(n)/f3(n/2)\n");
    printf("-------  ----------  --------------\n");

    for (n = start_n; n < end_n; n *= 2) {
        result = f3(n);
        printf("%7u  %10u", n, result);

        if (n > start_n) {
            ratio = (double)result / (double)previous;
            printf("  %14.5f", ratio);
        }

        printf("\n");

        previous = result;
    }

    printf("-------  ----------  --------------\n");

    printf("\n f4 \n");
    printf("      n       f4(n)   f4(n)/f4(n/2)\n");
    printf("-------  ----------  --------------\n");

    for (n = start_n; n < end_n; n *= 2) {
        result = f4(n);
        printf("%7u  %10u", n, result);

        if (n > start_n) {
            ratio = (double)result / (double)previous;
            printf("  %14.5f", ratio);
        }

        printf("\n");

        previous = result;
    }

    printf("-------  ----------  --------------\n");

    printf("\n f5 \n");
    printf("      n       f5(n)   f5(n)/f5(n/2)\n");
    printf("-------  ----------  --------------\n");

    for (n = start_n; n < end_n; n *= 2) {
        result = f5(n);
        printf("%7u  %10u", n, result);

        if (n > start_n) {
            ratio = (double)result / (double)previous;
            printf("  %14.5f", ratio);
        }

        printf("\n");

        previous = result;
    }

    printf("-------  ----------  --------------\n");

    printf("\n f6 \n");
    printf("      n       f6(n)    f6(n)/f6(n/2)\n");
    printf("-------  ----------  --------------\n");

    for (n = start_n; n < end_n; n *= 2) {
        result = f6(n);
        printf("%7u  %10u", n, result);

        if (n > start_n) {
            ratio = (double)result / (double)previous;
            printf("  %14.5f", ratio);
        }

        printf("\n");

        previous = result;
    }

    printf("-------  ----------  --------------\n");

    printf("\n f7 \n");
    printf("      n       f7(n)   f7(n)/f7(n/2)\n");
    printf("-------  ----------  --------------\n");

    for (n = 1; n < 33; n *= 2) {
        result = f7(n);
        printf("%7u  %10u", n, result);

        if (n > 1) {
            ratio = (double)result / (double)previous;
            printf("  %14.5f", ratio);
        }

        printf("\n");

        previous = result;
    }

    printf("-------  ----------  --------------\n");

    return 0;
}