import java.util.Scanner;

public class NotaDeCorte {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        
        Integer[] notas = new Integer[N];
        for (int i = 0; i < N; i++) {
            notas[i] = scanner.nextInt();
        }
        
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - i - 1; j++) {
                if (notas[j] < notas[j + 1]) {
                    int temp = notas[j];
                    notas[j] = notas[j + 1];
                    notas[j + 1] = temp;
                }
            }
        }
        
        int C = notas[K - 1];
        
        System.out.println(C);
        
        scanner.close();
    }
}
