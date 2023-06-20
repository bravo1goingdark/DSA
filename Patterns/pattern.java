public class pattern {
    public static void main(String[] args) {
        // patt1(10);
        // patt2(10);
        // patt3(4);
        // patt4(5);
        // patt5(5);
        // patt6(5);
        // patt7(5);
        // patt8(5);
    }
    static void patt1(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <=n ; col++) { //for every row , run the col 
                System.out.print("* ");
            }
            System.out.println(); // when one row is printed , we need to add newline           
        }
    }
    static void patt2(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <=row ; col++) { //for every row , run the col
                System.out.print("* ");
            }
            System.out.println(); // when one row is printed , we need to add newline           
        }
    }
    static void patt3(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <=n-row+1 ; col++) { //for every row , run the col
                System.out.print("* ");
            }
            System.out.println(); // when one row is printed , we need to add newline           
        }
    }
    static void patt4(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <=row ; col++) { //for every row , run the col
                System.out.print(col);
            }
            System.out.println(); // when one row is printed , we need to add newline           
        }
    }
    static void patt5(int n) {
        for (int row = 0; row < 2*n; row++) {
            int totalcolinRow = row > n ? 2*n - row:row;
            for (int col = 1; col < totalcolinRow ; col++) { //for every row , run the col
                System.out.print("* ");
            }
            System.out.println(); // when one row is printed , we need to add newline           
        }
    }
    static void patt6(int n) {
        for (int row = 0; row < 2*n; row++) {
            int totalcolinRow = row > n ? 2*n - row:row;
            int noOfSpaces = n - totalcolinRow;
            for (int s = 0; s < noOfSpaces; s++) {
                System.out.print(" ");
            }
            for (int col = 0; col < totalcolinRow ; col++) { //for every row , run the col
                System.out.print("* ");
            }
            System.out.println(); // when one row is printed , we need to add newline           
        }
    }
    static void patt7(int n) {
        for (int row = 0; row <= n; row++) {
            for (int space = 0; space < n - row; space++) {
                System.out.print("  ");              
            }
            for (int col = row; col>= 1; col--) {
                System.out.print(col + " ");
            }
            for (int col = 2; col <= row; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
            
        }
    }
    static void patt8(int n) {
        for (int row = 0; row <= 2*n; row++) {
            int c = row > n ? 2*n -row : row;
            for (int space = 0; space < n - c; space++) {
                System.out.print("  ");              
            }
            for (int col = c; col>= 1; col--) {
                System.out.print(col + " ");
            }
            for (int col = 2; col <= c; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
            
        }
    }
    
    
    
}