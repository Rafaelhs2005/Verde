#include <stdio.h>

int main() {
  char nome[50];
  double salario, vendas, salariototal;

  scanf(" %s", nome);
  scanf("%lf %lf", &salario, &vendas);

  salariototal = salario + (vendas * 0.15);

  printf("TOTAL = R$ %.2f\n", salariototal);
}
