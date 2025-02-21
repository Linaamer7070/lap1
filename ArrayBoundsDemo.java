import java.util.Scanner;

public class ArrayBoundsDemo {
    public static void main(String[] args) {
        int[] x = {11, 12, 13, 14, 15};
        System.out.println("Input index to print (negative number to exit):");
        Scanner input = new Scanner(System.in);
        
        int y = input.nextInt();
        while (y >= 0) {
            try {
                System.out.println(x[y]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Don't try buffer overflow attacks in Java!");
            }
            System.out.println("Enter next index:");
            y = input.nextInt();
        }
        
        input.close();
    }
} 