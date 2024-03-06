package com.sense.lib;

public class KuaiPai {
    public static void main(String[] args) {
        int[] data = new int[]{1,2,4,7,4,2,5,6,9,10};
        kuaiPai(data, 0, data.length-1);
        for (int i=0;i<data.length;i++) {
            System.out.print(data[i]+" ");
        }
    }

    private static void kuaiPai(int[] sor, int start,int end) {
        if (start>=end) {
            return;
        }
        int left = start;
        int right = end;
        int judge = sor[start];
        while (left<right) {
            while (left<right && sor[right] >= judge) {
                right--;
            }
            if (sor[right] < judge) {
                sor[left] = sor[right];
                left++;
            }
            while (left<right && sor[left] <= judge) {
                left++;
            }
            if (sor[left] > judge) {
                sor[right] = sor[left];
                right--;
            }
        }
        sor[left] = judge;
        kuaiPai(sor,start,left-1);
        kuaiPai(sor,left+1,end);
    }
}
