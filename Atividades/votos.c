#include <stdio.h>

int main() {
  int voto;
  int candidato1 = 0, candidato2 = 0, candidato3 = 0, candidato4 = 0;
  int nulos = 0, brancos = 0;
  int totalVotos = 0;

  do {
    scanf("%d", &voto);

    switch (voto) {
    case 1:
      candidato1++;
      totalVotos++;
      break;
    case 2:
      candidato2++;
      totalVotos++;
      break;
    case 3:
      candidato3++;
      totalVotos++;
      break;
    case 4:
      candidato4++;
      totalVotos++;
      break;
    case 5:
      nulos++;
      totalVotos++;
      break;
    case 6:
      brancos++;
      totalVotos++;
      break;
    case 0:
      break;
    }
  } while (voto != 0);

  printf("Candidato 1: %d voto(s)\n", candidato1);
  printf("Candidato 2: %d voto(s)\n", candidato2);
  printf("Candidato 3: %d voto(s)\n", candidato3);
  printf("Candidato 4: %d voto(s)\n", candidato4);
  printf("Votos nulos: %d\n", nulos);

  double porcentagemBrancos = 0.0;
  if (totalVotos > 0) {
    porcentagemBrancos = (double)brancos / totalVotos * 100;
  }
  printf("Porcentagem de votos em branco: %.2f%%\n", porcentagemBrancos);

  return 0;
}