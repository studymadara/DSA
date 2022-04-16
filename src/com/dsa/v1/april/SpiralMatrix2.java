package com.dsa.v1.april;

import java.util.Arrays;

public class SpiralMatrix2
{
    public int[][] generateMatrix(int n) {
        //declare size using n
        int[][] matrix=new int[n][n];

        int top=0;
        int left=0;
        int right=n-1;
        int bottom=n-1;
        int counter=1;
        while(true)
        {
            if(top>=n || left>=n || matrix[top][left]!=0)
                break;

            for(int i=left;i<=right;i++)
            {
                matrix[top][i]=counter++;
            }
            top++;
            for(int i=top;i<=bottom;i++)
            {
                matrix[i][right]=counter++;
            }
            right--;
            for(int i=right;i>=left;i--)
            {
                System.out.println("bottom :: "+bottom+" right :: "+i);
                matrix[bottom][i]=counter++;
            }
            bottom--;
            for(int i=bottom;i>=top;i--)
            {
                System.out.println("i :: "+i+" left :: "+left);
                matrix[i][left]=counter++;
            }
            left++;
        }
        return matrix;
    }

    public static void main(String args[])
    {
        SpiralMatrix2 spiralMatrix2=new SpiralMatrix2();
        System.out.println(Arrays.deepToString(spiralMatrix2.generateMatrix(3)));
    }
}
