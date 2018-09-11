package com.xy1m.cci.util;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in=new Scanner(System.in);
        int a=in.nextInt();
        int b=in.nextInt();
        Solution s=new Solution();
        System.out.println(s.fun(a,b));
    }
    public int fun(int a,int b){
        int count=0;
        for(int i=a;i<=b;i++){
            count+=minmax(i);
        }
        return count;
    }
    public int minmax(int num){
        int n= (int) Math.log10(num);
        int[] arr=new int[n];
        for(int i=n-1;i>=0;i--,num/=10){
            arr[i]=num%10;
        }
        return min(arr)+max(arr);
    }
    public int min(int[] num){
        int count=0;
        for(int i=1;i<num.length-1;i++){
            if(num[i]<num[i-1]&&num[i]<num[i+1]){
                count++;
            }
        }
        return count;
    }
    public int max(int[] num){
        int count=0;
        for(int i=1;i<num.length-1;i++){
            if(num[i]>num[i-1]&&num[i]>num[i+1]){
                count++;
            }
        }
        return count;
    }
}