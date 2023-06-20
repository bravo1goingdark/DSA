
public class mazewithobstacle {
    public static void main(String[] args) {
        boolean[][] board = {
            {true , true , true},
            {true , true , true}, 
            {true , false , true},
            {true , true , true}
        };
        mazeobstacleallpath(board, "", 0, 0);
    }
    static void mazeobstacle(boolean[][] mazeboard,String path, int row , int col){ 
        // number of possible ways to reach destination startingpoint{r,c} to destination{1,1} return as string
        if (row == mazeboard.length - 1 && col == mazeboard[0].length - 1) {
            System.out.println(path);
            return;
        }
        if (mazeboard[row][col] == false) {
            return;
        }
        if (row < mazeboard.length - 1) {
            mazeobstacle(mazeboard, path + 'D', row + 1, col);
        }
        if (col < mazeboard[0].length - 1) {
            mazeobstacle(mazeboard, path + 'R', row, col + 1);
        }
    }

    static void mazeobstacleallpath(boolean[][] mazeboard,String path, int row , int col){ 
        // number of possible ways to reach destination startingpoint {r,c} to destination {lastRow,lastCol} including all path 
        if (row == mazeboard.length - 1 && col == mazeboard[0].length - 1) {
            System.out.println(path);
            return;
        }
        if (mazeboard[row][col] == false) {
            return;
        }
        mazeboard[row][col] = false;

        if (row < mazeboard.length - 1) {
            mazeobstacleallpath(mazeboard, path + 'D', row + 1, col); // D --> Down
        }
        if (col < mazeboard[0].length - 1) {
            mazeobstacleallpath(mazeboard, path + 'R', row, col + 1); // R --> Right
        }
        if (row > 0){
            mazeobstacleallpath(mazeboard, path + 'U', row - 1, col); // U --> Up
        }
        if (col > 0){
            mazeobstacleallpath(mazeboard, path + 'L', row , col - 1); // L --> Left
        }
        mazeboard[row][col] = true;
    }
}
