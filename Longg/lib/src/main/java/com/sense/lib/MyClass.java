package com.sense.lib;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyClass {
    static int i;
    public static void main(String[] args) {
        //System.out.println(i);
        //maopao();
        //kuai();
        //ziji();
        //testList();
        search();

    }

    static void testFan(){
        Bar bar = new Bar();
        ArrayList<Bar> list = new ArrayList<Bar>();
        list.add(bar);
        fun(list);
    }
    public static class Fox{

    }
    public static class Bar extends Fox{

    }
    static void fun(ArrayList<? extends Fox> list){}



    private static void search() {
        int[] sor = new int[]{0,1,2,3,4,5,6,7,8,9,9,9,9};
        int target = 10;
        System.out.println(erfen(sor,target));
    }
    private static int erfen(int[] sor, int target) {
        int left = 0;
        int right = sor.length-1;
        while(left<=right) {
            int mid = (left+right)/2;
            if (sor[mid] > target) {
                right = mid-1;
            }else if (sor[mid] < target) {
                left = mid+1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static void testList() {
        ArrayList<Integer> sor = new ArrayList<>();
        sor.add(99);
        sor.add(101);
        sor.add(200);
        sor.add(300);
        sor.add(102);
        ArrayList<Integer> ret = delete(sor);
        for (Integer i:ret) {
            System.out.println(i);
        }
    }
    private static ArrayList<Integer> delete(ArrayList<Integer> list) {
        ArrayList<Integer> ret = new ArrayList<>();
        for (int i=0;i<list.size();i++) {
            if (list.get(i) < 100) {
                ret.add(list.get(i));
            }
        }

        return list;
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