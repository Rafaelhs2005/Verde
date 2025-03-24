import java.util.Scanner;

public class senha {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in, "UTF-8");

        while (scanner.hasNextLine()) {
            String senha = scanner.nextLine().trim();

            if (senha.equalsIgnoreCase("FIM")) {
                break;
            }

            if (validarSenha(senha)) {
                System.out.println("SIM");
            } else {
                System.out.println("NAO"); 
            }
        }

        scanner.close();
    }

    public static boolean validarSenha(String senha) {
        if (senha.length() < 8) {
            return false;
        }

        boolean temMaiuscula = false;
        boolean temMinuscula = false;
        boolean temNumero = false;
        boolean temEspecial = false;

        for (char c : senha.toCharArray()) {
            if (Character.isUpperCase(c)) {
                temMaiuscula = true;
            } else if (Character.isLowerCase(c)) {
                temMinuscula = true;
            } else if (Character.isDigit(c)) {
                temNumero = true;
            } else if (isCaractereEspecial(c)) {
                temEspecial = true;
            }
        }

        return temMaiuscula && temMinuscula && temNumero && temEspecial;
    }

    private static boolean isCaractereEspecial(char c) {
        String especiais = "!@#$%^&*()-+";
        return especiais.indexOf(c) != -1;
    }
}
