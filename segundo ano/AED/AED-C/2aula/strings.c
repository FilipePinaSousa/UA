#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<ctype.h>

// Função para contar o número de letras (maiúsculas e minúsculas) em uma string.
int count_alpha(const char* str) {
    size_t c = 0, i = 0;

    while(str[i] != '\0') {
        if((str[i]>='a' && str[i]<='z') || (str[i]>='A' && str[i]<='Z')) {
            c++;
        }

        i++;
    }

    return c;
}

// Função para contar o número de letras maiúsculas em uma string.
int count_alpha_upper(const char* str) {
    size_t c = 0, i = 0;

    while(str[i] != '\0') {
        if (str[i]>='A' && str[i]<='Z') {
            c++;
        }

        i++;
    }

    return c;
}

// Função para converter letras maiúsculas em minúsculas em uma string.
void to_lower(char* str) {
    size_t i = 0;

    while(str[i] != '\0') {
        if (str[i] >='A' && str[i]<='Z') {
            str[i] += ('a' - 'A');
        }

        i++;
    }
}

// Função para converter letras minúsculas em maiúsculas em uma string.
void to_upper(char* str) {
    size_t i = 0;

    while(str[i] != '\0') {
        if (str[i] >='a' && str[i]<='z') {
            str[i] -= ('a' - 'A');
        }

        i++;
    }
}

// Função para contar o número de letras (maiúsculas e minúsculas) em uma string (uma abordagem alternativa).
int count_alpha_2(const char* str) {
    size_t c = 0;
    for (size_t i = 0; str[i]!= '\0'; i++) {
        if (isalpha(str[i])) {
            c += 1;
        }
    }
    return c;
}

// Função para contar o número de letras maiúsculas em uma string (uma abordagem alternativa).
int count_alpha_upper_2(const char* str) {
    size_t i = 0, c = 0;
    for(; str[i]!='\0'; i++) {
        if (isupper(str[i])) {
            c++;
        }
    }
    return c;
}

int main(void) {
    char *str1, *str2;
    str1 = (char*) calloc(51, sizeof(char)); // Aloca memória para a primeira string.
    str2 = (char*) calloc(51, sizeof(char)); // Aloca memória para a segunda string.

    printf("Insira a primeira string: ");
    scanf("%[^\n]%*c", str1); // Lê a primeira string incluindo espaços em branco.

    printf("Insira a segunda string: ");
    scanf("%[^\n]%*c", str2); // Lê a segunda string incluindo espaços em branco.

    printf("%s\n%s\n", str1, str2); // Exibe as duas strings lidas.

    // Chama as funções para contar o número de letras nas strings e exibe os resultados.
    printf("Número de letras em '%s': %d\n", str1, count_alpha(str1));
    printf("Número de letras em '%s': %d\n", str1, count_alpha_2(str1));
    printf("Número de letras maiúsculas em '%s': %d\n", str2, count_alpha_upper(str2));
    printf("Número de letras maiúsculas em '%s': %d\n", str2, count_alpha_upper_2(str2));

    to_lower(str1); // Converte letras maiúsculas em minúsculas na primeira string.
    //to_upper(str2); // Converte letras minúsculas em maiúsculas na segunda string (comentado).

    printf("%s\n%s\n", str1, str2); // Exibe as strings após a conversão.

    int cmp = strcmp(str1, str2); // Compara as duas strings.

    if (cmp == 0) {
        printf("As strings são iguais.\n");
    } else if(cmp < 0) {
        printf("%s vem antes de %s.\n", str1, str2);
    } else {
        printf("%s vem antes de %s.\n", str2, str1);
    }

    free(str1); // Libera a memória alocada para a primeira string.
    free(str2); // Libera a memória alocada para a segunda string.
}
