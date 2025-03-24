import java.util.*;

public class maiorString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            if (linha.equals("FIM")) {
                break;
            }
            System.out.println(longestUniqueSubstring(linha));
        }
        
        scanner.close();
    }

    public static int longestUniqueSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        HashSet<Character> seen = new HashSet<>();
        
        for (int right = 0; right < s.length(); right++) {
            while (seen.contains(s.charAt(right))) {
                seen.remove(s.charAt(left));
                left++;
            }
            seen.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}
