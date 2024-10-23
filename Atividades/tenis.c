#include <stdio.h>

int main() {
  char p1, p2, p3, p4, p5, p6;
  int contador;

  contador = 0;
  scanf(" %c", &p1);
  scanf(" %c", &p2);
  scanf(" %c", &p3);
  scanf(" %c", &p4);
  scanf(" %c", &p5);
  scanf(" %c", &p6);

  if (p1 == 'V') {
    contador = contador + 1;
  }
  if (p2 == 'V') {
    contador = contador + 1;
  }
  if (p3 == 'V') {
    contador = contador + 1;
  }
  if (p4 == 'V') {
    contador = contador + 1;
  }
  if (p5 == 'V') {
    contador = contador + 1;
  }
  if (p6 == 'V') {
    contador = contador + 1;
  }

  if (contador == 0) {
    printf("-1");
  }
  if (contador >= 1 && contador <= 2) {
    printf("1");
  }
  if (contador >= 3 && contador <= 4) {
    printf("2");
  }
  if (contador >= 5 && contador <= 6) {
    printf("3");
  }
}