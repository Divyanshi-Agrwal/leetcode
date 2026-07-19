class Solution {
    public String smallestSubsequence(String s) {
        int[] lastIndex = new int[26];

        // Store the last occurrence of each character
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        boolean[] visited = new boolean[26];
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (visited[c - 'a']) {
                continue;
            }

            while (!stack.isEmpty()
                    && stack.peekLast() > c
                    && lastIndex[stack.peekLast() - 'a'] > i) {
                visited[stack.pollLast() - 'a'] = false;
            }

            stack.offerLast(c);
            visited[c - 'a'] = true;
        }

        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.append(stack.pollFirst());
        }

        return ans.toString();
    }
}