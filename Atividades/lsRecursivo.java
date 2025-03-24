import java.util.*;

public class lsRecursivo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String s1 = scanner.nextLine();

            if (s1.equals("FIM")) {
                break;
            }

            String x1 = Vogais(s1, 0) ? "SIM" : "NAO";
            String x2 = Consoantes(s1, 0) ? "SIM" : "NAO";
            String x3 = ehInteiro(s1, 0) ? "SIM" : "NAO";
            String x4 = ehReal(s1, 0, false) ? "SIM" : "NAO";

            System.out.println(x1 + " " + x2 + " " + x3 + " " + x4);
        }

        scanner.close();
    }

    public static boolean Vogais(String string, int index) {
        if (index == string.length()) {
            return true;
        }

        char c = string.charAt(index);

        if (!(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
              c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')) {
            return false;
        }

        return Vogais(string, index + 1);
    }

    public static boolean Consoantes(String string, int index) {
        if (index == string.length()) {
            return true;
        }

        char c = string.charAt(index);

        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                return false;
            }
        } else {
            return false;
        }

        return Consoantes(string, index + 1);
    }

    public static boolean ehInteiro(String string, int index) {
        if (index == string.length()) {
            return true;
        }

        char c = string.charAt(index);

        if (c < '0' || c > '9') {
            return false;
        }

        return ehInteiro(string, index + 1);
    }

    public static boolean ehReal(String string, int index, boolean pontoEncontrado) {
        if (index == string.length()) {
            return true;
        }

        char c = string.charAt(index);

        if (c == '.' || c == ',') {
            if (pontoEncontrado) {
                return false;
            }
            pontoEncontrado = true;
        } else if (c < '0' || c > '9') {
            return false;
        }

        return ehReal(string, index + 1, pontoEncontrado);
    }
}
