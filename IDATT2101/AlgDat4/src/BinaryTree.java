import java.util.Stack;

class BinaryTree {

    TreeNode root;

    public void printExpWithParentheses(TreeNode root){
        if(root == null) return;

        if (root.left != null || root.right != null) {
            System.out.print("(");
        }

        printExpWithParentheses(root.left);
        System.out.print(root.value);
        printExpWithParentheses(root.right);

        if (root.left != null || root.right != null){
            System.out.print(")");
        }
    }

    public int calculateSum(TreeNode node){
        if(node.left != null && node.right != null){
            if(node.value.equals('/')){
                return calculateSum(node.left) / calculateSum(node.right);
            } else if(node.value.equals('*')){
                return calculateSum(node.left) * calculateSum(node.right);
            } else if(node.value.equals('+')){
                return calculateSum(node.left) + calculateSum(node.right);
            } else if(node.value.equals('-')){
                return calculateSum(node.left) - calculateSum(node.right);
            } else {
                System.out.println("Gets here");return 0;}
        } else{
            return (int) node.value;
        }
    }
}