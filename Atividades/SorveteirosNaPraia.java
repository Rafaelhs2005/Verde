import java.util.*;

public class SorveteirosNaPraia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int teste = 1;

        while (true) {
            int P = sc.nextInt();
            int S = sc.nextInt();
            if (P == 0 && S == 0) break;

            int[][] intervalos = new int[S][2];

            for (int i = 0; i < S; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                intervalos[i][0] = Math.min(u, v);
                intervalos[i][1] = Math.max(u, v);
            }

            // Ordenar intervalos por início, e fim em caso de empate
            Arrays.sort(intervalos, new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
                    return Integer.compare(a[1], b[1]);
                }
            });

            // Fundir os intervalos
            List<int[]> fundidos = new ArrayList<>();
            int ini = intervalos[0][0];
            int fim = intervalos[0][1];

            for (int i = 1; i < S; i++) {
                if (intervalos[i][0] <= fim) {
                    fim = Math.max(fim, intervalos[i][1]);
                } else {
                    fundidos.add(new int[]{ini, fim});
                    ini = intervalos[i][0];
                    fim = intervalos[i][1];
                }
            }
            fundidos.add(new int[]{ini, fim}); // adicionar último intervalo

            // Imprimir
            System.out.println("Teste " + teste);
            for (int[] intervalo : fundidos) {
                System.out.println(intervalo[0] + " " + intervalo[1]);
            }
            System.out.println();
            teste++;
        }

        sc.close();
    }
}
