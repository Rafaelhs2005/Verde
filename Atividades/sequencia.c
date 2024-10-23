#include <stdio.h>

int main() {
  int n1, n2, soma = 0, i;

  scanf("%d %d", &n1, &n2);

  if (n1 > n2) {
    for (i = n2; i <= n1; i++) {
      printf("%d ", i);
      soma = soma + i;
    }
  } else if (n1 < n2) {
    for (i = n1; i <= n2; i++) {
      printf("%d ", i);
      soma = soma + i;
    }
  }
  printf("Soma = %d", soma);
}
