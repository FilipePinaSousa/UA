#include <stdio.h>
#include <math.h>

// Função para exibir um polinômio
void DisplayPol(double* coef, size_t degree) {
    printf("Pol(x) = ");
    for (int i = degree; i >= 0; i--) {
        if (coef[i] != 0.0) {
            printf("%.6lf", coef[i]);
            if (i > 0) {
                printf(" * x^%d", i);
                if (i != 1) {
                    printf(" + ");
                }
            }
        }
    }
    printf("\n");
}

// Função para calcular o valor de um polinômio usando o método de Horner
double ComputePol(double* coef, size_t degree, double x) {
    double result = coef[0];
    for (int i = 1; i <= degree; i++) {
        result = result * x + coef[i];
    }
    return result;
}

// Função para calcular as raízes reais de um polinômio de segundo grau
unsigned int GetRealRoots(double* coef, size_t degree, double* root_1, double* root_2) {
    if (degree != 2 || coef[0] == 0) {
        return 0; // Não é um polinômio de segundo grau ou coeficiente principal é zero
    }

    double discriminant = coef[1] * coef[1] - 4 * coef[0] * coef[2];

    if (discriminant < 0) {
        return 0; // Não há raízes reais
    } else if (discriminant == 0) {
        *root_1 = -coef[1] / (2 * coef[0]);
        *root_2 = *root_1;
        return 1; // Uma raiz real com multiplicidade 2
    } else {
        *root_1 = (-coef[1] + sqrt(discriminant)) / (2 * coef[0]);
        *root_2 = (-coef[1] - sqrt(discriminant)) / (2 * coef[0]);
        return 2; // Duas raízes reais distintas
    }
}

int main() {
    double coef[] = {1.0, 4.0, 1.0}; // Coef
    size_t degree = 2; // Grau do polinômio

DisplayPol(coef, degree);
    double x = 2.0; // Valor de x
    double result = ComputePol(coef, degree, x); // Resultado de Pol(x)
    printf("Pol(%.6lf) = %.6lf\n", x, result);

    double root_1 = 0.0, root_2 = 0.0; // Raízes reais
    unsigned int n_roots = GetRealRoots(coef, degree, &root_1, &root_2);
    printf("Roots: %u\n", n_roots);
    if (n_roots > 0) {
        printf("Root_1 = %.6lf\n", root_1);
    }
    if (n_roots > 1) {
        printf("Root_2 = %.6lf\n", root_2);
    }
    return 0;
}