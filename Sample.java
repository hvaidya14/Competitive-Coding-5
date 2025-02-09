// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    Queue<TreeNode> q = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();
    boolean zigzag=false;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if (root == null){
            return result;
        }

        q.add(root);
        processzigzag(root);
        return result;
    }

    private void processzigzag(TreeNode root) {
        if (root == null) {
            return;
        }
        int index =0;
        while (!q.isEmpty()) {
            int size = q.size();
            Integer a[] = new Integer[size];
            if (zigzag == false) {
                index = 0;
            } else if (zigzag == true) {
                index = size-1;
            }
            for (int i=0;i<size;i++) {
                TreeNode curr = q.poll();
                if (curr.left != null) {
                        q.add(curr.left);
                }
                if (curr.right != null) {
                        q.add(curr.right);
                }
                if (zigzag == false) {
                    a[index] = curr.val;
                    index++;
                } else if (zigzag == true) {
                    a[index] = curr.val;
                    index--;
                }
            }
            zigzag = !zigzag;
            List<Integer> temp = Arrays.asList(a);
            result.add(temp);
        }
        return;
    }
}
