package com.sense.lib;

/**
 * 冒泡排序
 */
public class MaoPao {
    public static void main(String[] args) {
        int[] data = new int[]{1,2,4,7,4,2,5,6,9,10};
        maoPao(data);
        for (int i=0;i<data.length;i++) {
            System.out.print(data[i]+" ");
        }
    }

    private static void maoPao(int[] sor) {
        int n = sor.length;
        for (int i=0;i<n;i++) {
            for (int j=0;j<n-1-i;j++) {
                if (sor[j] > sor[j+1]){
                    int temp = sor[j+1];
                    sor[j+1] = sor[j];
                    sor[j] = temp;
                }
            }
        }
    }
}
