#include <stdio.h>

int main() {
  int x, y;

  scanf("%d %d", &x, &y);

  if (x > 0) {
    if (y > 0) {
      printf("primeiro\n");
    } else if (y < 0) {
      printf("quarto\n");
    }
  } else if (x < 0) {
    if (y > 0) {
      printf("segundo\n");
    } else if (y < 0) {
      printf("terceiro\n");
    }
  }
}
