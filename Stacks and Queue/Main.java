import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        // Pstack stack = new Dstack(4);
        // Cqueue que = new Cqueue(5);
        Cirqueue que = new Dqueue(5);
        // stack.push(10);
        // stack.push(15);
        // stack.push(1);
        // stack.push(90);
        // stack.push(9);


        // System.out.println(stack.pop());
        // System.out.println(stack.pop());
        // System.out.println(stack.peek());

        // que.insert(100);
        // que.insert(10);
        // que.insert(1);
        // que.insert(9);
        // que.insert(11);
        // que.insert(111);

        // que.display();
        // System.out.println(que.front());
        
        // System.out.println(que.remove());
        // que.display();

        int h = kthFactor(7, 2);
        System.out.println(h);
       


    }

    // https://leetcode.com/problems/the-kth-factor-of-n/?envType=study-plan-v2&envId=amazon-spring-23-high-frequency

    static int kthFactor(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (list.size() < k) {
            return -1;
        } else {
            
        }
       
       for (int i = 1; i <= n; i++) {
        if (n % i == 0) {
            list.add(i);
        } 
       }

       for (int j = 0; j < list.size(); j++) {
        int res = list.get(j);
        if ( res == k) {
            return res;
        }
       }
       return 0;
    }
}
