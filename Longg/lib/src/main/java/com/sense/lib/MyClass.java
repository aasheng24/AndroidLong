package com.sense.lib;

public class MyClass {
    public static void main(String[] args) {
        //System.out.println("ez main");
        //maopao();
        kuai();
    }


    private static void kuai() {
        int[] ori = new int[]{5,4,1,6,3,7};
        kuaiP(ori,0,ori.length-1);
        for (int i=0;i<ori.length;i++) {
            System.out.print(ori[i] + " ");
        }
    }
    private static void kuaiP(int[] ori,int start,int end) {
        if (start>=end) {
            return;
        }
        int left = start;
        int right = end;
        int judge = ori[left];
        while (left < right){
            while(left<right && ori[right]>=judge) {
                right--;
            }
            if (ori[right] < judge) {
                ori[left] = ori[right];
                left++;
            }
            while(left<right && ori[left]<=judge) {
                left++;
            }
            if (ori[left] > judge){
                ori[right] = ori[left];
                right--;
            }
        }
        ori[left] = judge;
        kuaiP(ori,start,left-1);
        kuaiP(ori,left+1,end);
    }

    private static void maopao() {
        int[] ori = new int[]{5,4,1,6,3,7};
        for (int i=0;i<ori.length;i++) {
            for (int j=0;j<ori.length-i-1;j++) {
                if (ori[j+1]<ori[j]) {
                    int temp = ori[j+1];
                    ori[j+1] = ori[j];
                    ori[j] = temp;
                }
            }
        }
        for (int i=0;i<ori.length;i++) {
            System.out.print(ori[i] + " ");
        }
    }
}