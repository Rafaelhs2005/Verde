#include <stdio.h>
#include <string.h>
#include <ctype.h>

int somaR(int num) {
    if (num < 10) {
        return num; 
    }
    return (num % 10) + somaR(num / 10); 
}

int main() {
    char linha[100]; 

    while (1) {

        if (fgets(linha, sizeof(linha), stdin) == NULL) {
            break; 
        }

        linha[strcspn(linha, "\n")] = '\0';

        if (strcasecmp(linha, "FIM") == 0) {
            break;
        }

        int numero;
        if (sscanf(linha, "%d", &numero) != 1) {
            printf("Entrada inválida. Digite um número inteiro ou 'FIM' para encerrar.\n");
            continue;
        }

        int soma = somaR(numero);

        printf("%d\n", soma);
    }

    return 0;
}