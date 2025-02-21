public class RecursiveStackRemoval<E> {
    public static <E> void removeAll(Stack<E> stack) {
        if (!stack.isEmpty()) {
            stack.pop();  // إزالة العنصر العلوي
            removeAll(stack);  // استدعاء تكراري للعناصر المتبقية
        }
    }
} 