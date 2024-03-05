package com.sense.lib;

/**
 * 归并排序
 */
public class Guibing {
    public static void main(String[] args) {
        int[] sor = new int[]{8,1,2,4,3,5,6,7};
        int[] ret = mergeSort(sor,0, sor.length-1);
        for (int h=0;h<sor.length;h++) {
            System.out.print(sor[h]+" ");
        }
    }

    private static int[] mergeSort(int[] sor, int left, int right) {
        if (left >= right) {
            return sor;
        }
        int mid = (left + right)/2;
        //先分治
        mergeSort(sor, left, mid);
        mergeSort(sor,mid+1,right);
        //再合并
        int i = left, j = mid+1;
        //先copy到temp
        int[] temp = new int[sor.length];
        for (int k=left;k<=right;k++) {
            temp[k] = sor[k];
        }
        //重构sor
        for (int k=left;k<=right;k++){
            if (i==mid+1){
                sor[k] = temp[j];
                j++;
            } else if (j==right+1) {
                sor[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                sor[k] = temp[i];
                i++;
            } else if (temp[i] > temp[j]) {
                sor[k] = temp[j];
                j++;
            }
        }
        return sor;
    }
}
