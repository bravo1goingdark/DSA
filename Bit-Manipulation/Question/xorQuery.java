package Question;

public class xorQuery {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] prefixXor = new int[n + 1];
        
        for (int i = 0; i < n; i++) {
            prefixXor[i + 1] = prefixXor[i] ^ arr[i];
        }
        
        int[] res = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            res[i] = prefixXor[right + 1] ^ prefixXor[left];
        }
        
        return res;
    }
}
