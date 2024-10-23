#include<stdio.h>

int main() {

  int cod1, quant1, cod2, quant2;
  float preco1, preco2, total;

  scanf("%d %d %f", &cod1, &quant1, &preco1);
  scanf("%d %d %f", &cod2, &quant2, &preco2);

  total = quant1 * preco1 + quant2 * preco2;

  printf("VALOR A PAGAR: R$ %.2f\n", total);

  return 0;
}
