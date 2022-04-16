package com.dsa.v1.april;

import java.util.Arrays;

public class GameOfLife {

    //important learning need to check with traversing
    static final int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};

    public static void gameOfLife(int[][] board) {
        //1st iteration will mark cells with different flags
        for (int i=0;i< board.length;i++) {
            for (int j = 0; j < board[i].length; j++) {
                checkDirectionsValues(board,i,j);
            }
        }
        System.out.println(Arrays.deepToString(board));
        //2nd iteration we will replace flags with actual data
        for (int i=0;i< board.length;i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j]==3)
                    board[i][j]=1;
                else if (board[i][j]==-2)
                    board[i][j]=0;
            }
        }
    }

    public static void checkDirectionsValues(int[][] board, int x, int y) {
        int tempCount = 0;

        System.out.println("START :: "+x+" "+y+" :: "+board[x][y]);

        for (int i = 0; i < directions.length; i++) {

            int newX = directions[i][0] + x;
            int newY = directions[i][1] + y;

            if ((newX >= 0 && newX < board.length ) && (newY >= 0 && newY < board[0].length))
            {
                System.out.println("Original X :: "+x+" Original Y :: "+y+" || New X :: "+newX+" New Y ::"+newY);
                System.out.println(board[x][y]+" :: "+board[newX][newY]);

                if (board[newX][newY] == 1 || board[newX][newY] == -2 )
                    tempCount++;
            }
        }

        //actual rules
        //1. if dead which is 0 then there should be 3 1's for to become live [0-->3]
        //2. if alive which is 1 then there should be not less than 2 and more than 3 to become dead [1-->-2]

        if (tempCount == 3 && board[x][y]==0)
            board[x][y] = 3;
        else if((tempCount<2 || tempCount>3) && board[x][y]==1)
            board[x][y] = -2;

        System.out.println("END :: "+x+" "+y+" :: "+board[x][y]);

    }

    public static void main(String args[]) {
        int[][] data = new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        System.out.println(Arrays.deepToString(data));
        gameOfLife(data);
        System.out.println(Arrays.deepToString(data));
    }
}
