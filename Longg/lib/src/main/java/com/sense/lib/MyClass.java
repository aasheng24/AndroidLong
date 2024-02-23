package com.sense.lib;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyClass {
    static int i;
    public static void main(String[] args) {
        System.out.println(i);
        //maopao();
        //kuai();
        ziji();
    }


    static ArrayList<ArrayList<Integer>> zijiR = new ArrayList<>();
    private static void ziji() {
        int[] ori = new int[]{1,2,3};
        ArrayList<Integer> list = new ArrayList<>();
        zijiB(ori,list);
        for (ArrayList list1:zijiR) {
            for (int i=0;i< list1.size();i++) {
                System.out.print(list1.get(i)+" ");
            }
            System.out.println();
        }
    }
    private static void zijiB(int[] ori, ArrayList<Integer> list) {
        if (list.size() >= ori.length) {
            zijiR.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i=0;i<ori.length;i++) {
            if (list.contains(ori[i])) {
                continue;
            }
            list.add(ori[i]);
            zijiB(ori,list);
            list.remove(list.size()-1);
        }
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

    private static void compare() {
        HashMap<String ,Integer> map = new HashMap<>();
        List<Map.Entry<String,Integer>> list = new ArrayList<>();
        map.put("haha",3);
        map.put("hehe",3);
        for (Map.Entry entry:map.entrySet()) {
            list.add(entry);
        }

        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });

    }
}