import java.io.*;
import java.util.*;
import java.math.BigDecimal;

public class arquivo {
    public static void main(String[] args) {
        int n = MyIO.readInt();
        String filename = "numeros.txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (int i = 0; i < n; i++) {
                String input = MyIO.readString();
                double value = Double.parseDouble(input);

                if (value == (int) value) {
                    writer.printf(Locale.US, "%d\n", (int) value); 
                } else {
                    BigDecimal bd = new BigDecimal(input).stripTrailingZeros(); 
                    writer.println(bd.toPlainString()); 
                }
            }
        } catch (IOException e) {
            MyIO.println("Erro ao escrever no arquivo: " + e.getMessage());
        }

        try (RandomAccessFile file = new RandomAccessFile(filename, "r")) {
            long fileLength = file.length();
            long pointer = fileLength - 1;
            StringBuilder buffer = new StringBuilder();

            while (pointer >= 0) {
                file.seek(pointer);
                char c = (char) file.readByte();

                if (c == '\n') {
                    if (buffer.length() > 0) {
                        MyIO.println(buffer.reverse().toString());
                        buffer.setLength(0);
                    }
                } else {
                    buffer.append(c);
                }

                pointer--;
            }

            if (buffer.length() > 0) {
                MyIO.println(buffer.reverse().toString());
            }
        } catch (IOException e) {
            MyIO.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}