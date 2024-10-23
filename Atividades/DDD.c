#include <stdio.h>

int main() {
  int ddd;

  scanf("%d", &ddd);

  if (ddd == 11) {
    printf("Brasilia\n");
  } else if (ddd == 21) {
    printf("Rio de Janeiro\n");
  } else if (ddd == 31) {
    printf("Belo Horizonte\n");
  } else if (ddd == 27) {
    printf("Vitoria\n");
  } else if (ddd == 35) {
    printf("Lavras\n");
  } else if (ddd == 71) {
    printf("Salvador\n");
  } else if (ddd == 19) {
    printf("Campinas\n");
  } else {
    printf("DDD nao cadastrado\n");
  }
}
