#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

char *strrev(char *str) {
    int length = strlen(str);
    for (int i = 0; i < length / 2; i++) {
        char temp = str[i];
        str[i] = str[length - i - 1];
        str[length - i - 1] = temp;
    }
    return str;
}

void escreverNoArquivo(const char *filename, int n) {
    FILE *file = fopen(filename, "w");
    if (file == NULL) {
        perror("Erro ao abrir o arquivo para escrita");
        exit(EXIT_FAILURE);
    }

    for (int i = 0; i < n; i++) {
        char input[100];
        scanf("%s", input);

        double value;
        sscanf(input, "%lf", &value);

        if (value == (int)value) {
            fprintf(file, "%d\n", (int)value);
        } else {
            fprintf(file, "%s\n", input);
        }
    }

    fclose(file);
}

void lerArquivoInvertido(const char *filename) {
    FILE *file = fopen(filename, "r");
    if (file == NULL) {
        perror("Erro ao abrir o arquivo para leitura");
        exit(EXIT_FAILURE);
    }

    fseek(file, 0, SEEK_END);
    long fileLength = ftell(file);
    long pointer = fileLength - 1;
    char buffer[1000];
    int bufferIndex = 0;

    while (pointer >= 0) {
        fseek(file, pointer, SEEK_SET);
        char c = fgetc(file);

        if (c == '\n') {
            if (bufferIndex > 0) {
                buffer[bufferIndex] = '\0';
                printf("%s\n", strrev(buffer));
                bufferIndex = 0;
            }
        } else {
            buffer[bufferIndex++] = c;
        }

        pointer--;
    }

    if (bufferIndex > 0) {
        buffer[bufferIndex] = '\0';
        printf("%s\n", strrev(buffer));
    }

    fclose(file);
}

int main() {
    int n;
    scanf("%d", &n);

    const char *filename = "numeros.txt";
    escreverNoArquivo(filename, n);
    lerArquivoInvertido(filename);

    return 0;
}