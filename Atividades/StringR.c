#include <stdio.h>
#include <string.h>

void inverteString(const char *string, char *invertida) {
    int length = strlen(string);
    int i, j = 0;

    for (i = length - 1; i >= 0; i--) {
        invertida[j++] = string[i];
    }
    invertida[j] = '\0';
}

int main() {
    char linha[1000];
    char invertida[1000];

    while (1) {
        if (fgets(linha, sizeof(linha), stdin) == NULL) {
            break;
        }

        linha[strcspn(linha, "\n")] = '\0';

        if (strcmp(linha, "FIM") == 0) {
            break;
        }

        inverteString(linha, invertida);

        printf("%s\n", invertida);
    }

    return 0;
}