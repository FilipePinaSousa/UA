#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stddef.h>
#include <assert.h>

// Função para exibir o conteúdo de um array de números em ponto flutuante
// Precondições: a != NULL e n > 0
// Exemplo de saída produzida: Array = [ 1.00, 2.00, 3.00 ]

void DisplayArray(double* a, size_t n) {
    assert(a != NULL);
    assert(n > 0);

    printf("Array = [ ");
    for (size_t i = 0; i < n-1; i++){
        printf("%.2f, ", a[i]);
    }
    printf(" %.2f ]\n", a[n-1]);
}

// Função para ler o número de elementos, alocar o array e ler seus elementos
// Condição: número de elementos > 0
// Pré-condição: size_p != NULL
// Retorna NULL se a alocação de memória falhar
// Define *size_p como ZERO se a alocação de memória falhar
double* ReadArray(size_t* size_p) {
    assert(size_p != NULL);

    size_t temp_size_p = 0;
    printf("Insert the number of elements: ");
    scanf("%zu", &temp_size_p);

    double *array = (double*) calloc(temp_size_p, sizeof(double));
    if (array == NULL) {
        *size_p = 0;
        return NULL;
    } else {
        *size_p = temp_size_p;

        for (size_t i = 0; i < temp_size_p; i++) {
            double v = 0;
            printf("Insert the {%zu} element: ", i);
            scanf("%lf", &v);
            array[i] = v;
        }

        return array;
    }
}

// Alocar e retornar um novo array com (size_1 + size_2) elementos
// que armazena os elementos de array_1 seguidos pelos elementos de array_2
// Pré-condições: array_1 != NULL e array_2 != NULL
// Pré-condições: size_1 > 0 e size_2 > 0
// Retorna NULL se a alocação de memória falhar



double* Append(const double* array_1, size_t size_1, const double* array_2, size_t size_2) {
    double* rv_array = (double*) calloc(size_1+size_2, sizeof(double));

    size_t i = 0, j = 0;

    for (; i < size_1; i++) {
        rv_array[i] = array_1[i];
    }

    for (; j < size_2; i++, j++) {
        rv_array[i] = array_2[j];
    }

    return rv_array;
}

double* Append2(double* array_1, size_t size_1, double* array_2, size_t size_2) {
    double* rv_array = (double*) calloc(size_1+size_2, sizeof(double));

    memcpy (rv_array, array_1, size_1*sizeof(double));
    memcpy (&rv_array[size_1], array_2, size_2*sizeof(double));
    return rv_array;
}
int main(void) {
    size_t size_1 = 0, size_2 = 0;

    // Chama a função ReadArray para ler o primeiro array e obter seu tamanho.
    double* array_1 = ReadArray(&size_1);

    // Exibe o primeiro array.
    DisplayArray(array_1, size_1);

    // Chama a função ReadArray novamente para ler o segundo array e obter seu tamanho.
    double* array_2 = ReadArray(&size_2);

    // Exibe o segundo array.
    DisplayArray(array_2, size_2);

    // Chama a função Append para combinar os dois arrays em um novo array.
    double* array_3 = Append(array_1, size_1, array_2, size_2);

    // Exibe o array combinado.
    DisplayArray(array_3, size_1 + size_2);

    // Chama a função Append2 para combinar os dois arrays em um novo array (outra abordagem).
    double* array_4 = Append2(array_1, size_1, array_2, size_2);

    // Exibe o array combinado usando a segunda abordagem.
    DisplayArray(array_4, size_1 + size_2);

    // Libera a memória alocada para os arrays.
    free(array_1);
    free(array_2);
    free(array_3);
    free(array_4);
}
