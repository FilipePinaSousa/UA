#include <stdio.h>
#include <stdlib.h>

void eliminarMultiplos(int* sequencia, int* n) {
    int size = *n;
    int* manter = (int*)malloc(size * sizeof(int));

    for (int i = 0; i < size; ++i) {
        manter[i] = 1; // Inicializa todos os elementos como verdadeiros.
    }

    for (int i = 1; i < size; ++i) {
        for (int j = 0; j < i; ++j) {
            if (sequencia[i] % sequencia[j] == 0 || sequencia[j] % sequencia[i] == 0) {
                manter[i] = 0;
                break; // Não há necessidade de verificar outros predecessores.
            }
        }
    }

    // Contar quantos elementos devem ser mantidos.
    int count = 0;
    for (int i = 0; i < size; ++i) {
        if (manter[i]) {
            count++;
        }
    }

    // Criar uma nova sequência com base nos valores a serem mantidos.
    int* novaSequencia = (int*)malloc(count * sizeof(int));
    int index = 0;
    for (int i = 0; i < size; ++i) {
        if (manter[i]) {
            novaSequencia[index] = sequencia[i];
            index++;
        }
    }

    // Liberar a memória alocada para o vetor de manter.
    free(manter);

    // Atualizar o vetor sequencia e seu tamanho.
    *n = count;
    for (int i = 0; i < count; ++i) {
        sequencia[i] = novaSequencia[i];
    }

    // Liberar a memória alocada para o vetor novaSequencia.
    free(novaSequencia);
}

int main() {
    int sequencia[] = {2, 4, 6, 8, 10};
    int n = 5;

    eliminarMultiplos(sequencia, &n);

    printf("Sequência após eliminar múltiplos: ");
    for (int i = 0; i < n; ++i) {
        printf("%d ", sequencia[i]);
    }
    printf("\n");

    return 0;
}
//    Sequência Inicial com Melhor Caso:
//        {2, 3, 5, 7, 11, 13, 17, 19, 23, 29}
//        Resultado Final: A sequência permanecerá a mesma.
//        Número de Comparações: 0 (nenhuma eliminação é feita).
//        Número de Deslocamentos: 0 (nenhuma cópia é feita).
//
//    Sequência Inicial com Pior Caso:
//        {2, 4, 8, 16, 32, 64, 128, 256, 512, 1024}
//        Resultado Final: A sequência será transformada em {2}.
//        Número de Comparações: 45 (todas as combinações possíveis são verificadas).
//        Número de Deslocamentos: 9 (elementos não necessários são copiados).
//
//Agora, para determinar formalmente a ordem de complexidade, considere que o número de elementos da sequência é n e a pior complexidade
// ocorre quando a sequência é composta por potências de 2.
// Nesse caso, o número de comparações é dado por:
//
//Número de Comparações no Pior Caso = (n * (n - 1)) / 2
//
//E o número de deslocamentos é igual ao número de elementos que precisam ser copiados, o que é igual a n - 1.
//
//Para o melhor caso, a ordem de complexidade é muito menor, pois nenhuma eliminação é feita.
//
//Portanto, formalmente, a ordem de complexidade no pior caso é O(n^2) para o número de comparações e O(n) para o número de deslocamentos,
//enquanto no melhor caso, a ordem de complexidade é O(1) para o número de comparações e O(n) para o número de deslocamentos.