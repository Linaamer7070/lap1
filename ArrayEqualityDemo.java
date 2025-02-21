import java.util.Arrays;

public class ArrayEqualityDemo {
    public static void main(String[] args) {
        // مصفوفات أحادية البعد
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2, 3};
        
        // Shallow equality (يقارن المراجع)
        System.out.println("Shallow equality 1D: " + (array1 == array2));  // false
        
        // Deep equality (يقارن المحتويات)
        System.out.println("Deep equality 1D: " + Arrays.equals(array1, array2));  // true
        
        // مصفوفات ثنائية البعد
        int[][] array2D1 = {{1, 2}, {3, 4}};
        int[][] array2D2 = {{1, 2}, {3, 4}};
        
        // Shallow equality
        System.out.println("Shallow equality 2D: " + (array2D1 == array2D2));  // false
        
        // Deep equality
        System.out.println("Deep equality 2D: " + Arrays.deepEquals(array2D1, array2D2));  // true
    }
} 