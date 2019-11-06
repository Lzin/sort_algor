package com.liz.insert_sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * 数据操作的时机和操作
 * 思想:
 * 把n个待排序的元素看成一个有序表和一个无序表，开始的时候有序表中只有一个元素，无序表中有n-1个元素
 * 排序过程中每次从无序表中取出第一个元素，把它的排序码依次与有序表元素的排序表进行比较，将它插入到有序表的适当位置，使其成为新的有序表
 */
public class InsertSortTest {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};
        System.out.println("原始数据:"+Arrays.toString(arr));
        System.out.println("第一轮排序:");
        insertFirstSort(arr);
        System.out.println("第二轮排序:");
        insertSecondSort(arr);
        System.out.println("第三轮排序:");
        insertThirdSort(arr);
        System.out.println("-------------------");
        insertFinalSort(arr);

//        int[]arr=new int[80000];
//        for(int i=0;i<80000;i++){
//            arr[i]=(int)(Math.random()*10000);
//        }
//
//
//
//        System.out.println("排序前的时间:");
//        System.out.println(showTime());
//        insertFinalSort(arr);
//        System.out.println("排序后的时间:");
//        System.out.println(showTime());
    }

    public static void insertFirstSort(int[] arr) {
        //第一轮
        /**
         * {101,34,119,1}->{34,101,119,1}
         * */

        //定义待插入的数
        int insertVal = arr[1];
        int insertIndex = 1 - 1;//需要比较的索引 arr[1]的前面这个数的下标
        //保证不越界
        //34<101?
        //将arr[insertIndex]后移
        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex]; //{101,101,119,1}
            //arr[insertIndex]=insertVal;// {34,101,119,1}
            insertIndex--;
        }
        arr[insertIndex + 1] = insertVal;
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSecondSort(int[] arr) {
        //第二轮
        /**
         * {101,34,119,1}->{34,101,119,1}
         * */

        //定义待插入的数
        int insertVal = arr[2];
        int insertIndex = 2 - 1;//需要比较的索引 arr[1]的前面这个数的下标
        //保证不越界
        //34<101?
        //将arr[insertIndex]后移
        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex]; //{101,101,119,1}
            //arr[insertIndex]=insertVal;// {34,101,119,1}
            insertIndex--;
        }
        arr[insertIndex + 1] = insertVal;
        System.out.println(Arrays.toString(arr));
    }

    public static void insertThirdSort(int[] arr) {
        //第二轮
        /**
         * {101,34,119,1}->{34,101,119,1}
         * */

        //定义待插入的数
        int insertVal = arr[3];
        int insertIndex = 3 - 1;//需要比较的索引 arr[1]的前面这个数的下标
        //保证不越界
        //34<101?
        //将arr[insertIndex]后移
        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex]; //{101,101,119,1}
            //arr[insertIndex]=insertVal;// {34,101,119,1}
            insertIndex--;
        }
        arr[insertIndex + 1] = insertVal;
        System.out.println(Arrays.toString(arr));
    }

    public static void insertFinalSort(int[] arr) {
        for (int i = 1; i <arr.length ; i++) {
            //定义待插入的数
            int insertVal = arr[i];
            int insertIndex = i - 1;//需要比较的索引 arr[1]的前面这个数的下标
            //保证不越界
            //34<101?
            //将arr[insertIndex]后移
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex]; //{101,101,119,1}
               // arr[insertIndex]=insertVal;// {34,101,119,1}
                insertIndex--;
            }
            //判断是否需要赋值
            if(insertIndex+1!=i){
                //没有必要执行
                arr[insertIndex + 1] = insertVal;
            }

        }
        System.out.println(Arrays.toString(arr));
    }

    public static String showTime(){
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr=simpleDateFormat.format(date);
        return dateStr;
    }
}

