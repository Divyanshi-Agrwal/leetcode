// class Solution {
//     public int findJudge(int n, int[][] trust) {
//         // int[] count = new int[n+1];
//         // for(int[] t : trust){
//         //     int a = t[0];
//         //     int b = t[1];

//         //     count[a]--;
//         //     count[b]++;
//         // }
//         // for(int i = 1; i<=n; i++){
//         //     if(count[i] == n-1){
//         //         return i;
//         //     }
//         // }
        
//         }
//         return -1;
        
//     }
// }

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] inDegree = new int[n + 1];
        int[] outDegree = new int[n + 1];

        for (int[] t : trust) {
            outDegree[t[0]]++;
            inDegree[t[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == n - 1 && outDegree[i] == 0) {
                return i;
            }
        }

        return -1;
    }
}