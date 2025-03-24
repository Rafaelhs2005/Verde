#include <stdio.h>
#include <string.h>
#include <stdbool.h>

bool Verificador(const char *str) {
    int left = 0;
    int right = strlen(str) - 1;

    while (left < right) {
        if (str[left] != str[right]) {
            return false;
        }
        left++;
        right--;
    }
    return true;
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

        if (Verificador(line)) {
            printf("SIM\n");
        } else {
            printf("NAO\n");
        }
    }

    return 0;
}