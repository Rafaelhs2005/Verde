import java.util.Scanner;

public class ordenação {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        
        int[] notas = new int[N];
        for (int i = 0; i < N; i++) {
            notas[i] = scanner.nextInt();
        }
        
        int[] notasBubble = notas.clone();
        int[] notasSelection = notas.clone();
        int[] notasInsertion = notas.clone();
        
        bubbleSort(notasBubble);
        int C1 = notasBubble[K - 1];
        
        selectionSort(notasSelection);
        int C2 = notasSelection[K - 1];
        
        insertionSort(notasInsertion);
        int C3 = notasInsertion[K - 1];
        
        System.out.println("Nota de corte (Bubble Sort): " + C1);
        System.out.println("Nota de corte (Selection Sort): " + C2);
        System.out.println("Nota de corte (Insertion Sort): " + C3);
        
        scanner.close();
    }
    
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;
        }
    }
    
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] < key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}