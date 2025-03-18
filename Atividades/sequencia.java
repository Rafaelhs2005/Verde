import java.util.Scanner;

class sequencia {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int inicio = scanner.nextInt();
            int fim = scanner.nextInt();
            String resp = "";

            for (int i = inicio; i <= fim; i++) {
                resp += i;
            }

            for (int i = fim; i >= inicio; i--) {
                if (i > 9) {
                    resp += new StringBuilder(String.valueOf(i)).reverse();
                }
                else{
                    resp += i;
                }
            }

            System.out.println(resp);
        }

        scanner.close();
    }
}