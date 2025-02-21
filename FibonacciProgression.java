public class FibonacciProgression {
    private long prev;
    private long curr;
    
    public FibonacciProgression(long first, long second) {
        this.prev = first;
        this.curr = second;
    }
    
    public long nextValue() {
        long temp = prev;
        prev = curr;
        curr = temp + prev;
        return curr;
    }
    
    public void printProgression(int n) {
        System.out.print(prev + " ");
        System.out.print(curr + " ");
        for(int i = 2; i < n; i++) {
            System.out.print(nextValue() + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        FibonacciProgression fibonacci = new FibonacciProgression(2, 2);
        fibonacci.printProgression(8);
    }
} 