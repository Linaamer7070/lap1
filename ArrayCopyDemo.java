import java.util.Arrays;

public class ArrayCopyDemo {
    public static void main(String[] args) {
        int[] original = {1, 2, 3, 4, 5};
        
        // الطريقة الأولى: clone()
        int[] backup1 = original.clone();
        
        // الطريقة الثانية: Arrays.copyOf()
        int[] backup2 = Arrays.copyOf(original, original.length);
        
        // الطريقة الثالثة: System.arraycopy()
        int[] backup3 = new int[original.length];
        System.arraycopy(original, 0, backup3, 0, original.length);
        
        // عرض النتائج
        System.out.println("Original: " + Arrays.toString(original));
        System.out.println("Backup1 (clone): " + Arrays.toString(backup1));
        System.out.println("Backup2 (copyOf): " + Arrays.toString(backup2));
        System.out.println("Backup3 (arraycopy): " + Arrays.toString(backup3));
    }
} 