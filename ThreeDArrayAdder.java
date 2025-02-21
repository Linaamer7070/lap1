public class ThreeDArrayAdder {
    public static int[][][] addThreeDimensionalArrays(int[][][] array1, int[][][] array2) {
        // التحقق من تطابق أبعاد المصفوفتين
        if (array1.length != array2.length || 
            array1[0].length != array2[0].length || 
            array1[0][0].length != array2[0][0].length) {
            throw new IllegalArgumentException("Arrays must have the same dimensions");
        }
        
        // إنشاء مصفوفة جديدة لتخزين النتيجة
        int[][][] result = new int[array1.length][array1[0].length][array1[0][0].length];
        
        // جمع العناصر المتناظرة من المصفوفتين
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                for (int k = 0; k < result[0][0].length; k++) {
                    result[i][j][k] = array1[i][j][k] + array2[i][j][k];
                }
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        // مثال للاختبار
        int[][][] array1 = {{{1,2}, {3,4}}, {{5,6}, {7,8}}};
        int[][][] array2 = {{{1,1}, {1,1}}, {{1,1}, {1,1}}};
        
        int[][][] result = addThreeDimensionalArrays(array1, array2);
        
        // طباعة النتيجة
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                for (int k = 0; k < result[0][0].length; k++) {
                    System.out.print(result[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
} 