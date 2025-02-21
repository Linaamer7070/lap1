public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        
        // إضافة عناصر
        list.add(0, "A");
        list.add(1, "B");
        list.add(2, "C");
        
        // استخدام Iterator للمرور على العناصر
        System.out.println("Using Iterator:");
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            String element = iter.next();
            System.out.println(element);
        }
        
        // استخدام for-each loop (يستخدم Iterator داخلياً)
        System.out.println("\nUsing for-each loop:");
        for (String element : list) {
            System.out.println(element);
        }
        
        // إزالة عنصر باستخدام Iterator
        iter = list.iterator();
        while (iter.hasNext()) {
            if (iter.next().equals("B")) {
                iter.remove();
            }
        }
        
        System.out.println("\nAfter removing 'B':");
        for (String element : list) {
            System.out.println(element);
        }
    }
} 