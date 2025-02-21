import java.util.Random;
import java.util.Arrays;

public class RandomArrayRemover {
    public static void removeRandomEntries(int[] array) {
        Random random = new Random();
        
        while (array.length > 0) {
            // اختيار مؤشر عشوائي ضمن حدود المصفوفة الحالية
            int index = random.nextInt(array.length);
            
            // إزالة العنصر من المؤشر المختار
            int removedEntry = array[index];
            System.out.println("Removing: " + removedEntry);
            
            // تحريك العناصر المتبقية لملء الفراغ
            for (int i = index; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }
            
            // تقليص حجم المصفوفة
            array = Arrays.copyOf(array, array.length - 1);
            
            // طباعة المصفوفة الحالية
            System.out.println("Current array: " + Arrays.toString(array));
        }
    }
    
    public static void main(String[] args) {
        int[] testArray = {1, 2, 3, 4, 5};
        System.out.println("Initial array: " + Arrays.toString(testArray));
        removeRandomEntries(testArray);
    }
} 