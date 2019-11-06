package com.liz.bubbing_sort;

import java.sql.Array;
import java.util.Arrays;

/**
 * 每一轮从杂乱无章的数组头部开始，每两个元素比较大小并进行交换，直到这一轮当中最大或者最小的元素被放置在数组的尾部；
 * 然后不断去重复这个过程
 *
 * ps:核心在于双循环
 * 首层循环用来遍历整个数组
 * 后面一层循环用来进行相应数据的对比(前一层循环可以对后一层有限制的作用 如果前一层循环已经遍历过的，说明已经排序好了，就不需要再次触及)
 *
 * 时间复杂度:O(n^2)
 * */
public class BubbingSortTest {
    public static void main(String[] args) {
        //1.准备一个数组用来进行排序
        //int sortArr[] = {3, 9, -1, 10, 20};
        int sortArr[]={5,3,2,4,1};
        //show the array
        System.out.println("原数组");
        for (int i : sortArr) {
            System.out.print(i + " ");
        }
        System.out.println();
        //冒泡排序算法
        //bubbingFirstSort(sortArr);
        bubbingFinalSort(sortArr);
        for (int i : sortArr) {
            System.out.print(i + " ");
        }
    }
    public static void bubbingFinalSort(int[] array) {
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    flag=true;
                    //进行两个数的交换
                    swap(array, j, j + 1);
                }
            }
            System.out.println("第"+(i+1)+"次循环");
            System.out.println(Arrays.toString(array));
            if(!flag){
                //说明在一趟排序中一次交换都没有发生过
                break;
            }else{
                //重置 flag进行下一次判断
                flag=false;
            }
        }

    }
    public static void bubbingFirstSort(int []arr){
        for (int j = 0; j < arr.length - 1 ; j++) {
            if (arr[j] > arr[j + 1]) {
                //进行两个数的交换
                swap(arr, j, j + 1);
            }
        }
        System.out.println("第1次循环");
        System.out.println(Arrays.toString(arr));

    }
    public static void swap(int[] arr, int i, int j) {
        int temp = 0;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
