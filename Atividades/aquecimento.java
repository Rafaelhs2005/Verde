import java.util.Scanner;


public class aquecimento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String linha = scanner.nextLine();
        while (!linha.equals("FIM")) {
            System.out.println(contarMaiuscula(linha));
            linha = scanner.nextLine();
        }
        scanner.close();
            
    }

    public static int contarMaiuscula(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                count++;
            }
        }
        return count;
    }
}