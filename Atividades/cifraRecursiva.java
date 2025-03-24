import java.util.*;

public class cifraRecursiva {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (line.equals("FIM")) {
                break;
            }

            System.out.println(ciframento(line, 0, new StringBuilder()));
        }

        scanner.close();
    }

    public static String ciframento(String input, int index, StringBuilder sR) {
        if (index == input.length()) {
            return sR.toString();
        }

        char c = input.charAt(index);

        if (c >= ' ' && c <= '~') {
            c = (char) (' ' + (c - ' ' + 3) % 94);
        }

        sR.append(c);

        return ciframento(input, index + 1, sR);
    }
}
