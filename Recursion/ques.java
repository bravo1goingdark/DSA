public class ques {
    public int kthGrammar(int n, int k) {
        if (k == 1) {
            return 0;
        }

        int prevK = (k+1)/2;
        int prevsymb = kthGrammar(n-1, prevK);

        if (prevsymb == 0) {
            return (k % 2 == 0) ? 1:0;
        }

        return (k % 2 == 0) ? 0:1;
    }
}