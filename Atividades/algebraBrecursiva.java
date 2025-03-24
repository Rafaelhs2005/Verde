import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class algebraBrecursiva {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();

            if (linha.equals("0")) {
                break;
            }

            String[] partes = linha.split(" ");
            int n = Integer.parseInt(partes[0]);

            if (partes.length < n + 2) {
                System.out.println("Erro: Entrada inválida");
                continue;
            }

            Map<Character, Boolean> entradas = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                char variavel = (char) ('A' + (i - 1));
                boolean valor = partes[i].equals("1");
                entradas.put(variavel, valor);
            }

            String expressao = linha.substring(linha.indexOf(partes[n + 1]));
            boolean resultado = avaliarExpressaoRecursivo(expressao, entradas);

            System.out.println(resultado ? "1" : "0");
        }

        scanner.close();
    }

    public static boolean avaliarExpressaoRecursivo(String expressao, Map<Character, Boolean> entradas) {
        expressao = expressao.replaceAll(" ", "");

        for (Map.Entry<Character, Boolean> entrada : entradas.entrySet()) {
            char variavel = entrada.getKey();
            boolean valor = entrada.getValue();
            expressao = expressao.replaceAll("\\b" + variavel + "\\b", valor ? "1" : "0");
        }

        if (expressao.startsWith("not(")) {
            String subExpressao = expressao.substring(4, expressao.length() - 1);
            return !avaliarExpressaoRecursivo(subExpressao, entradas);
        }

        if (expressao.startsWith("and(")) {
            String[] partes = extrairArgumentos(expressao.substring(4, expressao.length() - 1));
            if (partes.length < 2) return false;
            boolean arg1 = avaliarExpressaoRecursivo(partes[0], entradas);
            boolean arg2 = avaliarExpressaoRecursivo(partes[1], entradas);
            return arg1 && arg2;
        }

        if (expressao.startsWith("or(")) {
            String[] partes = extrairArgumentos(expressao.substring(3, expressao.length() - 1));
            if (partes.length < 2) return false;
            boolean arg1 = avaliarExpressaoRecursivo(partes[0], entradas);
            boolean arg2 = avaliarExpressaoRecursivo(partes[1], entradas);
            return arg1 || arg2;
        }

        return expressao.equals("1");
    }

    private static String[] extrairArgumentos(String expressao) {
        int nivelParenteses = 0;
        int virgulaIndex = -1;

        for (int i = 0; i < expressao.length(); i++) {
            char c = expressao.charAt(i);
            if (c == '(') nivelParenteses++;
            if (c == ')') nivelParenteses--;
            if (c == ',' && nivelParenteses == 0) {
                virgulaIndex = i;
                break;
            }
        }

        if (virgulaIndex == -1) {
            return new String[]{expressao};
        }

        String arg1 = expressao.substring(0, virgulaIndex).trim();
        String arg2 = expressao.substring(virgulaIndex + 1).trim();
        return new String[]{arg1, arg2};
    }
}
