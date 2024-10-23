#include <stdio.h>

int main() {
  int A, B, C, idadeM, maisVelho;

  scanf("%d %d %d", &idadeM, &A, &B);

  if (idadeM <= 40 || idadeM >= 110 || A <= 1 || A > idadeM || B <= 1 ||
      B > idadeM || A == B) {
    return 0;
  }
  C = idadeM - (A + B);

  maisVelho = A;
  if (B > maisVelho) {
    maisVelho = B;
  }
  if (C > maisVelho) {
    maisVelho = C;
  }

  printf("%d\n", maisVelho);
}

