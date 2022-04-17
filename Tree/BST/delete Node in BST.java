class Solution {
        public TreeNode getMax(TreeNode root) {
            while (root.right == null)
                return root;
            return getMax(root.right);
        }

        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null)
                return null;

            if (root.val > key)
                root.left = deleteNode(root.left, key);

            else if (root.val < key)
                root.right = deleteNode(root.right, key);

            else if (root.val == key) 
            {
                if (root.left == null || root.right == null) 
                {
                    return (root.left != null) ? root.left : root.right;
                } 
                else 
                {
                    TreeNode maxValue = getMax(root.left);
                    root.val = maxValue.val;
                    root.left = deleteNode(root.left, maxValue.val);
                    return root;
                }
            }
            return root;
        }
    }
