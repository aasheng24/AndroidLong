package com.sense.lib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class MyClass {
    static int i;
    public static void main(String[] args) {
        //System.out.println(i);
        //maopao();
        //kuai();
        //ziji();
        //testList();
        //search();
        //testPri();
        //testCompare();
        testZudui();
    }

    //团队组队
    private static void testZudui(){
        int[] ability = new int[]{1,1,9};
        int min = 8;
        Arrays.sort(ability);
        int ret =0;
        int left = 0,right = ability.length-1;
        while (left<right) {
            while(ability[right] >= min) {
                ret++;
                right--;
            }
            if (ability[left]+ability[right]>=min) {
                ret++;
                left++;
                right--;
            } else {
                left++;
            }

        }
        System.out.println(ret);
    }

    private static void testCompare() {
        int[] sor = new int[]{3,1,2,5,4};
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<sor.length;i++) {
            list.add(sor[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int num : list) {
            System.out.print(num + " ");
        }

    }

    private static void testPri(){
        int[] arr = {6, 1, 3, 3, 3, 2, 4, 4, 4, 5};
        int[] result = removeDuplicate(arr);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
    private static int[] removeDuplicate(int[] arr) {
        final Map<Integer, Integer> freqMap = new HashMap<>();
        final Map<Integer, Integer> firstOccurrenceMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            firstOccurrenceMap.putIfAbsent(num, i);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer num1, Integer num2) {
                int freq1 = freqMap.get(num1);
                int freq2 = freqMap.get(num2);
                if (freq1 != freq2) {
                    return freq2 - freq1;
                } else {
                    int firstOccurrence1 = firstOccurrenceMap.get(num1);
                    int firstOccurrence2 = firstOccurrenceMap.get(num2);
                    return firstOccurrence1 - firstOccurrence2;
                }
            }
        });

        for (int num : arr) {
            if (!pq.contains(num)) {
                pq.offer(num);
            }
        }

        int[] result = new int[pq.size()];
        int idx = 0;
        while (!pq.isEmpty()) {
            result[idx++] = pq.poll();
        }

        return result;
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
                //return o1.getValue() - o2.getValue();
                String name ="haha";
                String name2 = "hehe";
                return name.compareTo(name2);
            }
        });



    }


}