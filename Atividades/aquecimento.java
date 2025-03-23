import java.util.Scanner;


public class aquecimento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String linha = scanner.nextLine();
            if (linha.equals("FIM")) {
                break;
                
            }
            System.out.println(contarMaiuscula(linha));   
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