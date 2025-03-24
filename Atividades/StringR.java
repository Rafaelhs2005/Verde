import java.util.*;

public class StringR {
    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("FIM")) {
                break;
            }
            
            System.out.println(inverteString(line));
        } 
        
        scanner.close();
    }

    public static String inverteString(String string){
        String invertida = ""; 

        
        for (int i = string.length() - 1; i >= 0; i--) {
            invertida += string.charAt(i); 
        }
    
        return invertida; 
    }
}
