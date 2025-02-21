public class PseudoRandomGenerator {
    private static final int a = 12;
    private static final int b = 5;
    private static final int n = 100;
    private int cur = 92;  // seed
    
    public int nextNumber() {
        cur = (a * cur + b) % n;
        return cur;
    }
    
    public static void main(String[] args) {
        PseudoRandomGenerator gen = new PseudoRandomGenerator();
        System.out.println("Next 5 numbers:");
        for (int i = 0; i < 5; i++) {
            System.out.println(gen.nextNumber());
        }
    }
} 