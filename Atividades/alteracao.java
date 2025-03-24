import java.util.*;

public class alteracao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random gerador = new Random();
        gerador.setSeed(4); 

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("FIM")) {
                break;
            }

            System.out.println(novaString(line, gerador));
        }
        scanner.close();
    }

    public static String novaString(String input, Random gerador) {
        char letra1 = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));
        char letra2 = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));
        return input.replace(letra1, letra2);
    }
}
