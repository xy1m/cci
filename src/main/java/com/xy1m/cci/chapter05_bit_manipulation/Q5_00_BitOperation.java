package com.xy1m.cci.chapter05_bit_manipulation;

public class Q5_00_BitOperation {

    /**
     * 获取第i位是否位1，i从0开始
     * @param num
     * @param i
     * @return
     */
    public static boolean getBit(int num, int i) {
        return (num & (1 << i)) != 0;
    }

    /**
     * 设置第i位的值位1，i从0开始
     * @param num
     * @param i
     * @return
     */
    public static int setBit(int num, int i) {
        return num | (1 << i);
    }

    /**
     * 清除第i位的值，i从0开始
     * @param num
     * @param i
     * @return
     */
    public static int clearBit(int num, int i) {
        return num & (~(i << i));
    }

    /**
     * 清除最大位至i位，包括i
     * @param num
     * @param i
     * @return
     */
    public static int clearL2I(int num, int i) {
        int mask = (1 << i) - 1;
        return num & mask;
    }

    /**
     * 清除第i位至第0位
     * @param num
     * @param i
     * @return
     */
    public static int clearI2R(int num, int i) {
        int mask = ~(-1 << (i + 1));
        //int mask = ~((1<<(i+1))-1);
        return num & mask;
    }

    /**
     * 设置第i位的值为bitIs1
     * @param num
     * @param i
     * @param bitIs1
     * @return
     */
    public static int updateBit(int num, int i, boolean bitIs1) {
        int value = bitIs1 ? 1 : 0;
        return (num & (~(1 << i))) | (value << i);
    }

    // logical shift
    // arithmetic shift
    // 逻辑shift和算术shift，逻辑shift左边补0，算术shift，如果被操作的数是负数，左边补1
    // 1s 意味着 -1
    // Character Integer Long 位数大小
    // 清除最低位的1 c=c&(c-1);

    public static void main(String[] args) {
    }
}
