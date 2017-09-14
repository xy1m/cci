package com.zzp.funny;

import java.util.ArrayList;
import java.util.List;

public class FindAllTopLeftAndBottomRight1s {
    public static List<List<Integer>> findAllTopLeftAndBottomRightZeros(int[][] matrix){
        List<List<Integer>> res=new ArrayList<>();
        if(matrix==null||matrix.length==0){
            return res;
        }
        int n=matrix.length;
        int m=matrix[0].length;

        boolean[][] visited=new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j]&&matrix[i][j]==0){
                    visited[i][j]=true;

                    List<Integer> inner=new ArrayList<>();

                    int rightMost=j;
                    while(rightMost<m&&matrix[i][rightMost]==0){
                        visited[i][rightMost]=true;
                        rightMost++;
                    }
                    if(rightMost!=j){
                        rightMost--;
                    }
                    int downMost=i;
                    while(downMost<n&&matrix[downMost][j]==0){
                        visited[downMost][j]=true;
                        downMost++;
                    }
                    if(downMost!=i){
                        downMost--;
                    }
                    for(int a=i+1;a<=downMost;a++){
                        for(int b=j+1;b<=rightMost;b++){
                            visited[a][b]=true;
                        }
                    }
                    int leftMost=j;
                    int topMost=i;
                    if(i!=0&&j!=0){
                        leftMost--;
                        topMost--;
                    }
                    if(downMost!=n-1&&rightMost!=m-1){
                        downMost++;
                        rightMost++;
                    }

                    inner.add(topMost);
                    inner.add(leftMost);

                    inner.add(downMost);
                    inner.add(rightMost);

                    res.add(inner);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 1},
                {1, 0, 1, 0, 0, 1, 1},
                {1, 1, 1, 0, 0, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
        };
        /**
         int[][] res = findTopLeftAndBottomRightZeros(image);
         StringBuilder sb=new StringBuilder();
         for(int i=0;i<2;i++){
         for(int j=0;j<2;j++){
         sb.append(res[i][j]).append(" ");
         }
         sb.append("\n");
         }
         System.out.println(sb.toString());
         */

        List<List<Integer>> res1=findAllTopLeftAndBottomRightZeros(image);

        for(int i=0;i<res1.size();i++){
            List<Integer> cur=res1.get(i);
            System.out.printf("%-20s Row %-5d Column %-5d\n","Top Left",cur.get(0),cur.get(1));
            System.out.printf("%-20s Row %-5d Column %-5d\n","Bottom right",cur.get(2),cur.get(3));
        }

    }
}
