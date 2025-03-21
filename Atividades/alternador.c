#include <stdio.h>
#include <string.h>

void combinador(char *str1, char *str2, char *resultado) {
    int len1 = strlen(str1);
    int len2 = strlen(str2);
    int i = 0, j = 0, k = 0;

    // Alterna as letras das duas strings
    while (i < len1 && j < len2) {
        resultado[k++] = str1[i++];
        resultado[k++] = str2[j++];
    }

    // Adiciona as letras restantes da primeira string, se houver
    while (i < len1) {
        resultado[k++] = str1[i++];
    }

    // Adiciona as letras restantes da segunda string, se houver
    while (j < len2) {
        resultado[k++] = str2[j++];
    }

    // Finaliza a string resultante
    resultado[k] = '\0';
}

int main() {
    char str1[100], str2[100], resultado[200];

    while (scanf("%s %s", str1, str2) != EOF) {
        combinador(str1, str2, resultado);
        printf("%s\n", resultado);
    }

    return 0;
}