public class PostfixEvaluator {
    public static double evaluatePostfix(String expression) {
        Stack<Double> stack = new ArrayStack<>();
        String[] tokens = expression.split("\\s+");
        
        for (String token : tokens) {
            if (isOperator(token)) {
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                double result = performOperation(token, operand1, operand2);
                stack.push(result);
            } else {
                stack.push(Double.parseDouble(token));
            }
        }
        
        return stack.pop();
    }
    
    private static boolean isOperator(String token) {
        return token.matches("[+\\-*/]");
    }
    
    private static double performOperation(String operator, double op1, double op2) {
        switch (operator) {
            case "+": return op1 + op2;
            case "-": return op1 - op2;
            case "*": return op1 * op2;
            case "/": return op1 / op2;
            default: throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter postfix expression (e.g., '5 2 + 8 3 - * 4 /'): ");
        String expression = scanner.nextLine();
        
        try {
            double result = evaluatePostfix(expression);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Error evaluating expression: " + e.getMessage());
        }
    }
} 