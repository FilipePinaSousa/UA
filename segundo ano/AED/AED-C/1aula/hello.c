#include <stdio.h>

int main(){
    char nome[10] ;
    char apelido[10] ;
    printf("Qual o seu nome? ");
    scanf("%s", nome);
    printf("Qual o seu apelido? ");
    scanf("%s", apelido);
    printf("O seu nome é %s %s\n", nome, apelido);
    return 0;
}
