import java.util.*;

public class Qpalavras {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (line.equals("FIM")) {
                break;
            }

            System.out.println(Contagem(line));

        }

        scanner.close();
    }

    public static int Contagem(String string){
        int contador = 1;

        for(int i = 0; i < string.length(); i++){
            char c = string.charAt(i);
            if (c == ' ') {
                contador++;
            } 
        }

        return contador;
    }
}
