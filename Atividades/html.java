import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class html {

    public static void main(String[] args) {
        System.setOut(new java.io.PrintStream(System.out, true, StandardCharsets.UTF_8));
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

        while (true) {
            String nomePagina = scanner.nextLine();
            if (nomePagina.equals("FIM")) {
                break;
            }

            String endereco = scanner.nextLine();
            String codigoPagina = obterCodigoPagina(endereco);
            int[] contagens = contarElementos(codigoPagina);

            System.out.printf(
                "a(%d) e(%d) i(%d) o(%d) u(%d) á(%d) é(%d) í(%d) ó(%d) ú(%d) " +
                "à(%d) è(%d) ì(%d) ò(%d) ù(%d) ã(%d) õ(%d) â(%d) ê(%d) î(%d) ô(%d) û(%d) " +
                "consoante(%d) <br>(%d) <table>(%d) %s\n",
                contagens[0], contagens[1], contagens[2], contagens[3], contagens[4],
                contagens[5], contagens[6], contagens[7], contagens[8], contagens[9],
                contagens[10], contagens[11], contagens[12], contagens[13], contagens[14],
                contagens[15], contagens[16], contagens[17], contagens[18], contagens[19],
                contagens[20], contagens[21], contagens[22], contagens[23], contagens[24], nomePagina
            );
        }

        scanner.close();
    }

    private static String obterCodigoPagina(String endereco) {
        StringBuilder conteudo = new StringBuilder();
        try {
            URL url = new URL(endereco);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("GET");

            BufferedReader leitor = new BufferedReader(new InputStreamReader(conexao.getInputStream(), StandardCharsets.UTF_8));
            String linha;
            while ((linha = leitor.readLine()) != null) {
                conteudo.append(linha).append("\n");
            }
            leitor.close();
        } catch (Exception e) {
            System.out.println("Erro ao obter código da página: " + e.getMessage());
        }
        return conteudo.toString();
    }

    private static int[] contarElementos(String codigo) {
        String vogais = "aeiouáéíóúàèìòùãõâêîôû";
        int[] contagens = new int[24]; // Corrigido o tamanho do array

        String codigoLimpo = codigo.replaceAll("<br>", "").replaceAll("<table>", "");

        for (char c : codigoLimpo.toCharArray()) {
            if (Character.isUpperCase(c)) continue; // Ignorar maiúsculas
            c = Character.toLowerCase(c);
            int index = vogais.indexOf(c);
            if (index != -1) {
                contagens[index]++;
            } else if (c >= 'b' && c <= 'z' && c != 'e' && c != 'i' && c != 'o' && c != 'u' && c != 'a') {
                contagens[21]++; // Corrigido índice das consoantes
            }
        }

        contagens[22] = contarOcorrencias(codigo, "<br>");
        contagens[23] = contarOcorrencias(codigo, "<table>");

        return contagens;
    }

    private static int contarOcorrencias(String texto, String padrao) {
        Matcher matcher = Pattern.compile(Pattern.quote(padrao)).matcher(texto);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}
