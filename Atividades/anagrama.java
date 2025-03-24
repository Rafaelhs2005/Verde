public class anagrama {

    public static void main(String[] args) {
        while (true) {
            String linha = MyIO.readLine();

            if (linha.equals("FIM")) {
                break;
            }

            String[] palavras = linha.split(" - ");
            String str1 = palavras[0];
            String str2 = palavras[1];

            if (saoAnagramas(str1, str2)) {
                MyIO.println("SIM");
            } else {
                MyIO.println("NÃO");
            }
        }
    }

    public static boolean saoAnagramas(String str1, String str2) {
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();

        if (str1.length() != str2.length()) {
            return false;
        }

        int[] contagem = new int[26];

        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            if (c >= 'a' && c <= 'z') {
                contagem[c - 'a']++;
            }
        }

        for (int i = 0; i < str2.length(); i++) {
            char c = str2.charAt(i);
            if (c >= 'a' && c <= 'z') {
                contagem[c - 'a']--;
            }
        }

        for (int i = 0; i < contagem.length; i++) {
            if (contagem[i] != 0) {
                return false;
            }
        }

        return true;
    }
}