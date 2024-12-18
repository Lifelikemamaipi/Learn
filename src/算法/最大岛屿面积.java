package 算法;

/**
 * https://leetcode.cn/problems/ZL6zAn/description/
 *  一个都是01的矩阵，求其中上下左右相连的1的最大数
 *
 * @author ：Good_M
 * @date ：Created in 2024 2024/12/18 22:45
 */
public class 最大岛屿面积 {


    public static void main(String[] args) {
        int[][] island = {
                {1,0,0,1,0,1,0},
                {1,0,0,0,0,1,0},
                {0,0,0,0,1,0,0},
                {0,1,0,1,0,1,0},
                {0,1,1,1,0,1,0},
                {1,0,0,1,0,1,0},
        };
        System.out.println(maxAreaOfIsland(island));
    }


    public static int maxAreaOfIsland(int[][] grid) {
        int one = grid.length;
        int two = grid[0].length;

        int res = 0;
        for (int i = 0; i < one; i++) {
            for (int j = 0; j < two; j++) {
                int area = getArea(grid, i, j);
                if (area > res){
                    res = area;
                }
            }

        }
        return res;
    }

    private static int getArea(int[][] grid,int i,int j){
        int one = grid.length;
        int two = grid[0].length;
        if (i < 0 || j < 0 || i == one ||j == two || grid[i][j] == 0 ) {
            return 0;
        }
        grid[i][j] = 0;

        int res = 1;
        res += getArea(grid,i-1,j);
        res += getArea(grid,i+1,j);
        res += getArea(grid,i,j -1);
        res += getArea(grid,i,j +1);

        return res;
     }




}
