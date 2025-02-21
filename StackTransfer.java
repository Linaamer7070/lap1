public class StackTransfer<E> {
    public static <E> void transfer(Stack<E> S, Stack<E> T) {
        Stack<E> temp = new ArrayStack<>();  // مكدس مؤقت
        
        // نقل من S إلى temp (يعكس الترتيب)
        while (!S.isEmpty()) {
            temp.push(S.pop());
        }
        
        // نقل من temp إلى T (يعيد الترتيب الأصلي)
        while (!temp.isEmpty()) {
            T.push(temp.pop());
        }
    }
} 