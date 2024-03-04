package com.sense.lib;

public class Huawei {
    public static void main(String[] args) {
        shuzuHe();
    }

    //连续数组区间和判断
    private static void shuzuHe(){
        int[] sor = new int[]{3,4,7};

        int target = 7;
        int ret = 0;
        int sum = 0;
        int left = 0;
        for (int i=0;i<sor.length;i++) {
            sum += sor[i];
            while (sum>=target) {
                ret += sor.length-i;
                sum -= sor[left];
                left++;
            }
        }
        System.out.println(ret);
    }
}
