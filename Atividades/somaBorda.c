#include <stdio.h>
#include <stdlib.h>

void preencheMatriz(int N, int M, int matriz[N][M]) {
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            scanf("%d", &matriz[i][j]);
        }
    }
}

int somaBorda(int N, int M, int matriz[N][M]) {
    int soma = 0;


    for (int j = 0; j < M; j++) {
        soma += matriz[0][j];        
        soma += matriz[N - 1][j];   
    }

    for (int i = 1; i < N - 1; i++) {
        soma += matriz[i][0];        
        soma += matriz[i][M - 1];   
    }

    return soma;
}

int main() {
    int N, M;
    scanf("%d %d", &N, &M);

    int matriz[N][M];
    preencheMatriz(N, M, matriz);

    int resultado = somaBorda(N, M, matriz);
    printf("%d", resultado);

}
