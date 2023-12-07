#include <stdio.h>
#include <stdlib.h>

// Função que troca os valores das variáveis apontadas por três ponteiros
void Permute(int *a, int *b, int *c){
    int temp = *a;
    *a = *b;
    *b = *c;
    *c = temp;
}

// Função de exemplo que não altera os valores das variáveis originais
void dummy_Permute(int a, int b, int c) {
    printf("DP %d %d %d\n", a, b, c);
    int t = a;
    a = c;
    c = t;
    printf("DP %d %d %d\n", a, b, c);
}

int main(void) {
    int a = 1, b = 2, c = 3;

    // Imprime os valores originais de a, b e c
    printf("%d %d %d\n", a, b, c);

    // Chama a função dummy_Permute, que não altera os valores originais
    dummy_Permute(a, b, c);

    // Imprime os valores de a, b e c novamente (ainda não foram alterados)
    printf("%d %d %d\n", a, b, c);

    // Chama a função dummy_Permute novamente (não afeta os valores originais)
    dummy_Permute(a, b, c);

    // Imprime os valores de a, b e c mais uma vez (ainda não foram alterados)
    printf("%d %d %d\n", a, b, c);
}
