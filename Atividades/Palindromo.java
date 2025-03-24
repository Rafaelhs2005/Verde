import java.util.*;

public class Palindromo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("FIM")) {
                break;
            }
            System.out.println(Verificador(line) ? "SIM" : "NÃO");
        }
        scanner.close();
    }

    public static boolean Verificador(String str) {
        int left = 0;
        int right = str.length() - 1;
        
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
