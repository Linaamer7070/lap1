public class MultiLanguageCaesarCipher {
    private final String alphabet;
    private final int shift;
    
    public MultiLanguageCaesarCipher(String alphabet, int shift) {
        this.alphabet = alphabet;
        this.shift = shift;
    }
    
    public String encrypt(String message) {
        StringBuilder result = new StringBuilder();
        
        for (char c : message.toCharArray()) {
            int index = alphabet.indexOf(c);
            if (index != -1) {
                // تطبيق الإزاحة مع مراعاة الدوران حول طول الأبجدية
                int newIndex = (index + shift) % alphabet.length();
                result.append(alphabet.charAt(newIndex));
            } else {
                result.append(c);  // الحفاظ على الأحرف غير الموجودة في الأبجدية
            }
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        // مثال للغة العربية
        String arabicAlphabet = "ابتثجحخدذرزسشصضطظعغفقكلمنهوي";
        MultiLanguageCaesarCipher arabicCipher = new MultiLanguageCaesarCipher(arabicAlphabet, 3);
        
        String message = "مرحبا";
        String encrypted = arabicCipher.encrypt(message);
        System.out.println("Original: " + message);
        System.out.println("Encrypted: " + encrypted);
    }
} 