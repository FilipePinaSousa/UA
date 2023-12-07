#include <stdio.h>
#include <math.h>

int main(void) {
    int linhas;
    FILE *fp;

    printf("Quantas linhas pretendes? ");
    scanf("%d", &linhas);

    fp = fopen("angulos.txt", "w");
    if (fp == NULL) {
        printf("Erro ao abrir o arquivo.\n");
        return 1;
    }

    fprintf(fp, "%3s,%3s,%3s\n", "ang", "sen(ang)", "cos(ang)");
    fprintf(fp, "--- -------- -------\n");

    for (int i = 1; i <= linhas; i++) {
        double ang = i * 5.0;
        fprintf(fp, "%3d %8.4f %8.4f\n", i, sin(ang * M_PI / 180.0), cos(ang * M_PI / 180.0));
    }

    fclose(fp);
    printf("Os ângulos foram escritos no arquivo angulos.txt.\n");
    return 0;
}
