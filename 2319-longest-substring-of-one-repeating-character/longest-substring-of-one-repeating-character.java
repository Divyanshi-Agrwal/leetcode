class Solution {

    class Node {
        int leftChar, rightChar;
        int prefix, suffix, best;
        int len;

        Node() {}

        Node(int ch) {
            leftChar = rightChar = ch;
            prefix = suffix = best = 1;
            len = 1;
        }
    }

    Node[] tree;
    char[] arr;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {

        int n = s.length();
        int k = queryIndices.length;

        arr = s.toCharArray();
        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {

            int index = queryIndices[i];
            char ch = queryCharacters.charAt(i);

            arr[index] = ch;

            update(1, 0, n - 1, index);

            ans[i] = tree[1].best;
        }

        return ans;
    }

  
    private void build(int node, int start, int end) {

        if (start == end) {
            tree[node] = new Node(arr[start] - 'a');
            return;
        }

        int mid = start + (end - start) / 2;

        build(node * 2, start, mid);
        build(node * 2 + 1, mid + 1, end);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

   
    private void update(int node, int start, int end, int index) {

        if (start == end) {
            tree[node] = new Node(arr[index] - 'a');
            return;
        }

        int mid = start + (end - start) / 2;

        if (index <= mid) {
            update(node * 2, start, mid, index);
        } else {
            update(node * 2 + 1, mid + 1, end, index);
        }

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

 
    private Node merge(Node left, Node right) {

        Node res = new Node();

        res.len = left.len + right.len;

        res.leftChar = left.leftChar;
        res.rightChar = right.rightChar;

      
        res.prefix = left.prefix;

        if (left.prefix == left.len &&
            left.rightChar == right.leftChar) {

            res.prefix = left.len + right.prefix;
        }

      
        res.suffix = right.suffix;

        if (right.suffix == right.len &&
            left.rightChar == right.leftChar) {

            res.suffix = right.len + left.suffix;
        }

        res.best = Math.max(left.best, right.best);

     
        if (left.rightChar == right.leftChar) {
            res.best = Math.max(
                res.best,
                left.suffix + right.prefix
            );
        }

        return res;
    }
}