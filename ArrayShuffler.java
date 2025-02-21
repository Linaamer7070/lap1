import java.util.Random;
import java.util.Arrays;

public class ArrayShuffler {
    public static void shuffle(int[] A) {
        Random rnd = new Random();
        
        for (int i = A.length - 1; i > 0; i--) {
            // تبديل العنصر الحالي مع عنصر عشوائي من المصفوفة المتبقية
            int j = rnd.nextInt(i + 1);
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }
    
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Original array: " + Arrays.toString(array));
        shuffle(array);
        System.out.println("Shuffled array: " + Arrays.toString(array));
    }
} 