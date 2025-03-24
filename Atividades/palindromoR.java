import java.util.Scanner;

public class palindromoR {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (line.equals("FIM")) {
                break;
            }

            System.out.println(Verificador(line, 0, line.length() - 1) ? "SIM" : "NAO");
        }

        scanner.close();
    }

    public static boolean Verificador(String str, int left, int right) {
        if (left >= right) {
            return true;
        }

        if (str.charAt(left) != str.charAt(right)) {
            return false;
        }

        return Verificador(str, left + 1, right - 1);
    }
}