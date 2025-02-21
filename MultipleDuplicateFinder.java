import java.util.*;

public class MultipleDuplicateFinder {
    public static Set<Integer> findFiveDuplicates(int[] B) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();
        
        for (int num : B) {
            if (!seen.add(num)) {  // إذا كان العنصر موجود مسبقاً
                duplicates.add(num);
            }
        }
        
        if (duplicates.size() != 5) {
            throw new IllegalArgumentException("Array should contain exactly 5 duplicates");
        }
        
        return duplicates;
    }
    
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 1, 2, 3, 4, 4, 5, 5}; // مثال لمصفوفة مع 5 تكرارات
        Set<Integer> result = findFiveDuplicates(array);
        System.out.println("The repeated numbers are: " + result);
    }
} 