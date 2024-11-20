#include <stdio.h>

void imprimirPascal(int n) {
    int triPascal[n][n]; 

    for (int i = 0; i < n; i++) {
        for (int j = 0; j <= i; j++) {
            if (j == 0 || j == i) {
                triPascal[i][j] = 1;
            } else {
                triPascal[i][j] = triPascal[i - 1][j - 1] + triPascal[i - 1][j];
            }
            printf("%d ", triPascal[i][j]);
        }
        printf("\n");
    }
}

int main() {
    int n;
    scanf("%d", &n);

    imprimirPascal(n);

    return 0;
}
