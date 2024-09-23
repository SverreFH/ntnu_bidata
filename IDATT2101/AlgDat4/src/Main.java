public class Main {
    public static void main(String[] args) {
        System.out.println("Oppgave 1");
        JosephusProblem josephusProblem = new JosephusProblem();
        for(int i = 1; i <= 50; i++){
            josephusProblem.insertNode(i);
        }
        System.out.println(josephusProblem.findJosephusPos(3));

        System.out.println("\nOppgave 3");

        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode('/');
        tree.root.left = new TreeNode('+');
        tree.root.right = new TreeNode('-');
        tree.root.left.left = new TreeNode('-');
        tree.root.left.right = new TreeNode('+');
        tree.root.right.left = new TreeNode(3);
        tree.root.right.right = new TreeNode(2);
        tree.root.left.left.left = new TreeNode(5);
        tree.root.left.left.right = new TreeNode(4);
        tree.root.left.right.left = new TreeNode('+');
        tree.root.left.right.right = new TreeNode('*');
        tree.root.left.right.left.left = new TreeNode(10);
        tree.root.left.right.left.right = new TreeNode(5);
        tree.root.left.right.right.left = new TreeNode(2);
        tree.root.left.right.right.right = new TreeNode(4);

        tree.printExpWithParentheses(tree.root);

        System.out.println("\n" + tree.calculateSum(tree.root));
    }
}