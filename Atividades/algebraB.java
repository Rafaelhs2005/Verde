import java.util.*;

public class algebraB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();

            if (linha.equals("FIM")) {
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
            boolean resultado = avaliarExpressaoIterativa(expressao, entradas);

            System.out.println(resultado ? "1" : "0");
        }

        scanner.close();
    }

    public static boolean avaliarExpressaoIterativa(String expressao, Map<Character, Boolean> entradas) {
        expressao = expressao.replaceAll(" ", "");

        for (Map.Entry<Character, Boolean> entrada : entradas.entrySet()) {
            char variavel = entrada.getKey();
            boolean valor = entrada.getValue();
            expressao = expressao.replaceAll(String.valueOf(variavel), valor ? "1" : "0");
        }

        Stack<Boolean> pilha = new Stack<>();
        Stack<String> operadores = new Stack<>();

        for (int i = 0; i < expressao.length(); i++) {
            char c = expressao.charAt(i);

            if (c == '1' || c == '0') {
                pilha.push(c == '1');
            } else if (c == 'n' && expressao.startsWith("not(", i)) {
                operadores.push("not");
                i += 3; 
            } else if (c == 'a' && expressao.startsWith("and(", i)) {
                operadores.push("and");
                i += 3; 
            } else if (c == 'o' && expressao.startsWith("or(", i)) {
                operadores.push("or");
                i += 2;
            } else if (c == ')') {
                if (!operadores.isEmpty()) {
                    String operador = operadores.pop();
                    if (operador.equals("not")) {
                        if (!pilha.isEmpty()) {
                            boolean val = pilha.pop();
                            pilha.push(!val);
                        }
                    } else if (operador.equals("and")) {
                        if (pilha.size() >= 2) {
                            boolean val2 = pilha.pop();
                            boolean val1 = pilha.pop();
                            pilha.push(val1 && val2);
                        }
                    } else if (operador.equals("or")) {
                        if (pilha.size() >= 2) {
                            boolean val2 = pilha.pop();
                            boolean val1 = pilha.pop();
                            pilha.push(val1 || val2);
                        }
                    }
                }
            }
        }

        return pilha.isEmpty() ? false : pilha.pop();
    }
}