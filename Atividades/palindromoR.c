#include <stdio.h>
#include <string.h>
#include <stdbool.h>

bool Verificador(const char *str, int left, int right) {

    if (left >= right) {
        return true;
    }

    if (str[left] != str[right]) {
        return false;
    }

    return Verificador(str, left + 1, right - 1);
}

int main() {
    char line[1000];

    while (1) {

        if (fgets(line, sizeof(line), stdin) == NULL) {
            break; 
        }

        line[strcspn(line, "\n")] = '\0';

        if (strcmp(line, "FIM") == 0) {
            break;
        }

        if (Verificador(line, 0, strlen(line) - 1)) {
            printf("SIM\n");
        } else {
            printf("NAO\n");
        }
    }

    return 0;
}