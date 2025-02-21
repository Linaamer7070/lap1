public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        ArrayBinaryTree<String> tree = new ArrayBinaryTree<>();
        
        // إنشاء شجرة بسيطة
        Position<String> root = tree.addRoot("Root");
        Position<String> left = tree.addLeft(root, "Left");
        Position<String> right = tree.addRight(root, "Right");
        tree.addLeft(left, "Left-Left");
        tree.addRight(left, "Left-Right");
        
        System.out.println("Tree contents:");
        tree.printTree();
        
        // عرض العلاقات
        System.out.println("\nRelationships:");
        System.out.println("Root element: " + root.getElement());
        System.out.println("Left child of root: " + tree.left(root).getElement());
        System.out.println("Right child of root: " + tree.right(root).getElement());
        System.out.println("Parent of left child: " + tree.parent(left).getElement());
    }
} 