#include <stdio.h>

double calcularSerie(int N) {
  if (N == 0) {
    return 1.0;
  } else {
    double fatorial = 1.0;
    for (int i = 1; i <= N; i++) {
      fatorial *= i;
    }
    return (1.0 / fatorial) + calcularSerie(N - 1);
  }
}

int main() {
  int N;

  scanf("%d", &N);

  double resultado = calcularSerie(N);
  printf("Resultado: %.2f\n", resultado);
}