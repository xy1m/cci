package com.zzp.cci.chapter5_bit_manipulation;

public class BitOperation {

    /**
     * 获取第i位是否位1，i从0开始
     *
     * @param num
     * @param i
     * @return
     */
    public boolean getBit(int num, int i) {
        return (num & (1 << i)) != 0;
    }

    /**
     * 设置第i位的值位1，i从0开始
     *
     * @param num
     * @param i
     * @return
     */
    public int setBit(int num, int i) {
        return num | (1 << i);
    }

    /**
     * 清除第i位的值，i从0开始
     *
     * @param num
     * @param i
     * @return
     */
    public int clearBit(int num, int i) {
        return num & (~(i << i));
    }

    /**
     * 清除最大位至i位，包括i
     *
     * @param num
     * @param i
     * @return
     */
    public int clearL2I(int num, int i) {
        int mask = (1 << i) - 1;
        return num & mask;
    }

    /**
     * 清楚第i位至第0位
     *
     * @param num
     * @param i
     * @return
     */
    public int clearI2R(int num, int i) {
        int mask = ~(-1 << (i + 1));
        //int mask = ~((1<<(i+1))-1);
        return num & mask;
    }

    /**
     * 设置第i位的值为bitIs1
     *
     * @param num
     * @param i
     * @param bitIs1
     * @return
     */
    public int updateBit(int num, int i, boolean bitIs1) {
        int value = bitIs1 ? 1 : 0;
        return (num & (~(1 << i))) | (value << i);
    }

    // logical shift
    // arithmetic shift
    // 逻辑shift和算术shift，逻辑shift左边补0，算术shift，如果被操作的数是负数，左边补1
    // 1s 意味着 -1
    // Character Integer Long 位数大小
    // 清楚最低位的1 c=c&(c-1);

    /**
     * @param n
     * @param m
     * @param i
     * @param j
     * @return
     * @5.1 N=65 //1000001
     * M=10 // 01010
     * insertion(65,10,1,5)=85
     */
    public int insertion(int n, int m, int i, int j) {
        int mask = -1 << (j + 1);
        mask |= (1 << i) - 1;
        return n & mask | m << i;
    }

    /**
     * @param num
     * @return
     * @5.2
     */
    public String binary2String(double num) {
        return null;
    }

    public int longest1s(int num) {
        return -1;
    }

    public int nextNumber(int num) {
        return -1;
    }

    /**
     * Explain what code dose (n&(n-1))==0
     * Means n is 2^k
     */

    /**
     * @param num1
     * @param num2
     * @return
     * @5.6
     */
    public int numberOfBitsConvertion(int num1, int num2) {
        int num = num1 ^ num2;
        int count = 0;
        for (; num != 0; num = num & (num - 1)) {
            count++;
        }
        return count;
    }

    /**
     * @param num
     * @return
     * @5.7
     */
    public int pairwiseSwap(int num) {
        // 0101 1010
        int odd = num & 0x55555555;
        int even = num & 0xaaaaaaaa;
        return (odd << 1) | (even >> 1);
    }


    public static void main(String[] args) {
        BitOperation bitOperation = new BitOperation();
        System.out.println(bitOperation.insertion(65, 10, 1, 5));
        System.out.println(bitOperation.numberOfBitsConvertion(15, 0));
        System.out.println(bitOperation.pairwiseSwap(15));
    }
}
