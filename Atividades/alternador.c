#include <stdio.h>
#include <string.h>

void combinador(char *str1, char *str2, char *resultado) {
    int len1 = strlen(str1);
    int len2 = strlen(str2);
    int i = 0, j = 0, k = 0;

    while (i < len1 && j < len2) {
        resultado[k++] = str1[i++];
        resultado[k++] = str2[j++];
    }

    while (i < len1) {
        resultado[k++] = str1[i++];
    }

    while (j < len2) {
        resultado[k++] = str2[j++];
    }

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