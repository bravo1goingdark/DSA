import java.util.ArrayList;

public class mazeproblem{
    public static void main(String[] args) {
    //    mazedestpath("",3, 3);
        ArrayList<String> ans = mazedestpathDiagonalList("", 3, 3);
        System.out.println(mazedestcount(3, 2));

    }   
    static int mazedestcount(int row , int col){ 
        // number of possible ways to reach destination startingpoint{r,c} to destination{1,1}
        if (row == 1 || col == 1) {
            return 1;
        }
        int left = mazedestcount(row - 1, col);
        int right = mazedestcount(row, col - 1);
        return left + right;
    }
    static void mazedestpath(String path, int row , int col){ 
        // number of possible ways to reach destination startingpoint{r,c} to destination{1,1} return as string
        if (row == 1 && col == 1) {
            System.out.println(path);
            return;
        }
        if (row > 1) {
            mazedestpath(path + 'D', row - 1, col);
        }
        if (col > 1) {
            mazedestpath(path + 'R', row, col - 1);
        }
    }
    static ArrayList<String> mazedestpathList(String path, int row , int col){ 
        // number of possible ways to reach destination startingpoint{r,c} to destination{1,1} return in list
        if (row == 1 && col == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(path);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        if (row > 1) {
            list.addAll(mazedestpathList(path + 'D', row - 1, col));
        }
        if (col > 1) {
            list.addAll(mazedestpathList(path + 'R', row, col - 1));
        }
        return list;
    }
    static ArrayList<String> mazedestpathDiagonalList(String path, int row , int col){ 
        // number of possible ways to reach destination startingpoint{r,c} to destination{1,1} includes diagonal return in list
        if (row == 1 && col == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(path);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        if (row > 1 && col > 1) {
            list.addAll(mazedestpathDiagonalList(path + 'O' , row - 1 , col - 1));
        }
        if (row > 1) {
            list.addAll(mazedestpathDiagonalList(path + 'D', row - 1, col));
        }
        if (col > 1) {
            list.addAll(mazedestpathDiagonalList(path + 'R', row, col - 1));
        }
        return list;
    }


}