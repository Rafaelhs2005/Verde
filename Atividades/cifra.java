import java.util.*;

public class cifra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("FIM")) {

                break;
            }
            System.out.println(ciframento(line));
        }
        scanner.close();
    }

    public static String ciframento(String input) {
        StringBuilder sR = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c >= ' ' && c <= '~') {
                c = (char) (' ' + (c - ' ' + 3) % 94);
            }
            sR.append(c);
        }
        return sR.toString();
    }
}