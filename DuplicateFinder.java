public class DuplicateFinder {
    public static int findDuplicate(int[] A) {
        // مجموع الأرقام من 1 إلى n-1
        int n = A.length;
        int expectedSum = ((n-1) * n) / 2;
        
        // مجموع العناصر الفعلية في المصفوفة
        int actualSum = 0;
        for (int num : A) {
            actualSum += num;
        }
        
        // الفرق هو العنصر المكرر
        return actualSum - expectedSum;
    }
    
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 2}; // مصفوفة مع تكرار الرقم 2
        System.out.println("The repeated number is: " + findDuplicate(array));
    }
} 