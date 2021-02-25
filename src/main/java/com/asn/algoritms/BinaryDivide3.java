package com.asn.algoritms;

/**
 * 新希望金融科技面试题：有一个文件，里面存放的是一个上亿位的二进制数，如何计算这个二进制数除以3的余数？
 * 思路：有限状态机
 * 根据题意可知，二进制数非常长，不能采用常规手段计算。可以一个一个的递进式计算。那么如何一个一个的按位计算呢？
 * 我们知道，一个数除以三得到的余数有三种可能：0,1,2，那么就对应三种状态。另外，因为二进制数左移一位后低位补0相当于是原数*2，低位补1相当于是原数*2+1。
 * 因此可以使用一个初始值为0的变量作为状态，从左到右的变量二进制数进行状态转移即可。
 * 0@0->0 :表示状态是0且左移一位低位补0时，转移后的状态为0
 * 0@1->1 :表示状态是0且左移一位低位补1时，转移后的状态为1
 * 1@0->2
 * 1@1->0
 * 2@0->1
 * 2@1->2
 */
public class BinaryDivide3 {
    public static void main(String[] args) {
        String bin = Integer.toBinaryString(51323423);
        System.out.println(execute(bin));
    }
    public static int execute(String bin){
        System.out.println("bin="+bin);
        int state=0;
        char[] chars = bin.toCharArray();
        for (char c : chars) {
            if (c=='0'){
                if (state==0){
                    state=0;
                }else if (state==1){
                    state=2;
                }else {
                    state=1;
                }
            }else if (c=='1'){
                if (state==0){
                    state=1;
                }else if (state==1){
                    state=0;
                }else {
                    state=2;
                }
            }
        }
        return state;
    }
}

