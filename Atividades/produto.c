#include <stdio.h>

int main() {
  int idade, gostou;
  int totalMasculinoGostaram = 0, totalFemininoGostaram = 0;
  int idadeMaisVelhaMascGostou = -1, idadeMaisNovaFemNaoGostou = -1;
  int totalNaoGostaram = 0, totalEntrevistados = 0;
  char genero;

  while (1) {

    scanf("%d", &idade);

    if (idade < 0) {
      break;
    }

    scanf(" %c %d", &genero, &gostou);

    totalEntrevistados++;

    if (genero == 'M' || genero == 'm') {
      if (gostou == 1) {
        totalMasculinoGostaram++;

        if (idade > idadeMaisVelhaMascGostou) {
          idadeMaisVelhaMascGostou = idade;
        }
      } else {
        totalNaoGostaram++;
      }
    } else if (genero == 'F' || genero == 'f') {
      if (gostou == 1) {
        totalFemininoGostaram++;
      } else {
        totalNaoGostaram++;

        if (idadeMaisNovaFemNaoGostou == -1 ||
            idade < idadeMaisNovaFemNaoGostou) {
          idadeMaisNovaFemNaoGostou = idade;
        }
      }
    }
  }

  double percentualNaoGostaram = 0.0;
  if (totalEntrevistados > 0) {
    percentualNaoGostaram =
        (double)totalNaoGostaram / totalEntrevistados * 100.0;
  }

  printf("Masculino: %d\n", totalMasculinoGostaram);
  printf("Feminino: %d\n", totalFemininoGostaram);

  printf("%d anos\n", idadeMaisVelhaMascGostou);

  printf("%d anos\n", idadeMaisNovaFemNaoGostou);

  printf("%.2f%%\n", percentualNaoGostaram);

  return 0;
}
