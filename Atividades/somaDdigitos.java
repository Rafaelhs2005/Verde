import java.util.*;

public class somaDdigitos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String linha = scanner.nextLine();

            
            if (linha.equalsIgnoreCase("FIM")) {
                break; 
            }

            
            int numero = Integer.parseInt(linha); 
            int soma = somaR(numero); 
            System.out.println(soma);

        }

        scanner.close();
        
    }

    public static int somaR(int num){
        if(num < 10){
            return num;
        }

        return (num % 10) + somaR(num / 10);
    }
}