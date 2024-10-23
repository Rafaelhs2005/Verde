#include <stdio.h>

int main() {

  int a, b, c;

  scanf("%d %d %d", &a, &b, &c);

  if ((a + b > c) && (a + c > b) && (b + c > a)) {

    if (a == b && b == c) {
      printf("Triangulo Equilatero");
    } else if (a == b || b == c || c == a) {
      printf("Triangulo Isosceles");
    } else {
      printf("Triangulo Escaleno");
    }
  } else {
    printf("Triangulo invalido");
  }
}
