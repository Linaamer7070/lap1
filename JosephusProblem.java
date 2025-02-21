public class JosephusProblem {
    public static int solve(int n, int k) {
        Queue<Integer> circle = new ArrayQueue<>();
        
        // إضافة الأشخاص من 1 إلى n
        for (int i = 1; i <= n; i++) {
            circle.enqueue(i);
        }
        
        while (circle.size() > 1) {
            // تدوير k-1 مرات
            for (int i = 0; i < k-1; i++) {
                circle.enqueue(circle.dequeue());
            }
            // إزالة الشخص الـ k
            circle.dequeue();
        }
        
        return circle.dequeue();  // آخر شخص متبقي
    }
    
    public static void main(String[] args) {
        int n = 7;  // عدد الأشخاص
        int k = 3;  // عدد العد
        System.out.println("Last person standing: " + solve(n, k));
    }
} 