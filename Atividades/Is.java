import java.util.*;

public class Is {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            
            String line = scanner.nextLine();

            if (line.equals("FIM")) {
                break;
            }

            String x1 = Vogais(line) ? "SIM" : "NAO";

            String x2 = Consoantes(line) ? "SIM" : "NAO";

            String x3 = ehInteiro(line) ? "SIM" : "NAO";

            String x4 = ehReal(line) ? "SIM" : "NAO";

            System.out.println(x1 + " " + x2 + " " + x3 + " " + x4);
        }

        scanner.close();
    }

    public static boolean Vogais(String string) {
        if (string.length() == 0) {
            return false; 
        }

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);

            if (!(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                  c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')) {
                return false;
            }
        }
        return true;
    }

    public static boolean Consoantes(String string) {
        if (string.length() == 0) {
            return false;
        }

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);

            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {

                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                    c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                    return false;
                }
            } else {
                return false; 
            }
        }
        return true;
    }

    public static boolean ehInteiro(String string) {
        if (string.length() == 0) {
            return false; 
        }

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);

            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    public static boolean ehReal(String string) {
        if (string.length() == 0) {
            return false; 
        }

        boolean pontoEncontrado = false; 

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);

            if (c == '.' || c == ',') {
                if (pontoEncontrado) {
                    return false; 
                }
                pontoEncontrado = true;
            } else if (c < '0' || c > '9') {
                return false; 
            }
        }
        return true;
    }
}