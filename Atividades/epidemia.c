#include <stdio.h>

int main() {
    int N, R, P;

    // Leitura dos valores de entrada
    scanf("%d", &N);  // Número de pessoas infectadas no dia 0
    scanf("%d", &R);  // Fator reprodutivo da infecção
    scanf("%d", &P);  // Número alvo de pessoas infectadas

    int total_infectados = N;  // Total de pessoas infectadas
    int dias = 0;              // Número de dias

    // Loop até que o total de infectados seja maior ou igual ao alvo P
    while (total_infectados < P) {
        N *= R;                // Número de novas infecções no próximo dia
        total_infectados += N; // Atualiza o total de infectados
        dias++;                // Incrementa o número de dias
    }

    // Saída do número de dias necessários
    printf("%d\n", dias);
}
