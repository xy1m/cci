package com.zzp.cci.chapter1_array_string;

/**
 * Created by zhenpeng on 8/9/17.
 */
public class Q1_7_Rotate_Matrix {
    // first layer
    // last n-1-layer
    // offset i-first
    // top matrix[first][i]
    // left matrix[last-offset][first]
    // bottom matrix[last][last-offset]
    // right matrix[i][last]
    public void rotate(int[][] matrix,int n){
        for(int layer=0;layer<n/2;layer++){
            int first=layer;
            int last=n-1-layer;
            for(int i=first;i<last;i++){
                int offset=i-first;
                int top=matrix[first][i];

                matrix[first][i]=matrix[last-offset][first];
                matrix[last-offset][first]=matrix[last][last-offset];
                matrix[last][last-offset]=matrix[i][last];
                matrix[i][last]=top;
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

        Q1_7_Rotate_Matrix solution=new Q1_7_Rotate_Matrix();
        solution.rotate(matrix,4);

        StringBuffer sb=new StringBuffer();
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                sb.append(matrix[i][j]).append(' ');
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
