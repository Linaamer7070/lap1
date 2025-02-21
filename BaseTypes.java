import java.util.Scanner;

public class BaseTypes {
    public static void inputAllBaseTypes() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a byte value: ");
        byte byteValue = scanner.nextByte();
        
        System.out.print("Enter a short value: ");
        short shortValue = scanner.nextShort();
        
        System.out.print("Enter an int value: ");
        int intValue = scanner.nextInt();
        
        System.out.print("Enter a long value: ");
        long longValue = scanner.nextLong();
        
        System.out.print("Enter a float value: ");
        float floatValue = scanner.nextFloat();
        
        System.out.print("Enter a double value: ");
        double doubleValue = scanner.nextDouble();
        
        System.out.print("Enter a boolean value (true/false): ");
        boolean booleanValue = scanner.nextBoolean();
        
        System.out.print("Enter a char value: ");
        char charValue = scanner.next().charAt(0);
        
        // Print all values
        System.out.println("\nValues entered:");
        System.out.println("byte: " + byteValue);
        System.out.println("short: " + shortValue);
        System.out.println("int: " + intValue);
        System.out.println("long: " + longValue);
        System.out.println("float: " + floatValue);
        System.out.println("double: " + doubleValue);
        System.out.println("boolean: " + booleanValue);
        System.out.println("char: " + charValue);
        
        scanner.close();
    }
    
    public static void main(String[] args) {
        inputAllBaseTypes();
    }
} 