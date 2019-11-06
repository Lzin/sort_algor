package com.liz.merge_sort;

import java.util.Arrays;

/**
 * 归并排序:
 * 利用归并的思想实现排序方法，采用经典的分治策略（把一个大的问题分解成小的问题，然后进行递归求解）
 * 归并排序中，借助两个合并的数组之间的相互比较和一个中转数组实现排序
 */
public class MergeSortTest {
    public static void main(String[] args) {
        int arr[] = {8, 4, 5, 7, 1, 3, 6, 2};
        int temp[] = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println("归并排序后" + Arrays.toString(arr));
    }

    //归并排序（递归）
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
            if (left < right) {
            int mid = (left + right) / 2;
            //向左递归
            mergeSort(arr, left, mid, temp);

            //向右递归
            mergeSort(arr, mid + 1, right, temp);

            //合并
            merge(arr, left, mid, right, temp);
        }
    }
    //合并的方法

    /**
     * arr表示待排序的数组
     * left表示左边有序序列的初始索引
     * mid表示中间索引
     * right表示右边索引
     * temp表示临时数组,起到中转的作用
     *
     *
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;//初始化i，表示左边有序序列的初始索引
        int j = mid + 1;//初始化j，表示右边有序序列的初始索引
        int t = 0;//指向temp数组的当前索引

        //1.
        //先把左右两边(已经是有序的)的数据按照规则填充到temp中，
        //直到左右两边有序序列，有一边处理完毕为止
        while (i <= mid && j <= right) {

            //如果左边有序序列的当前元素小于或者等于右边的当前元素，然后将该数据填充入temp中
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else {
                //反之将右边的数据填充入temp数组中
                temp[t] = arr[j];
                t++;
                j++;
            }
        }

        //此时一边已经走完 另一边还在继续行进
        //2.
        //把有剩余数据的一边的数据依次全部填充到temp去
        while (i <= mid) {//说明坐标的有序序列还是有剩余的,将左边数据进行填充
            temp[t] = arr[i];
            t++;
            i++;
        }

        while (j <= right) {//说明坐标的有序序列还是有剩余的,将右边数据进行填充
            temp[t] = arr[j];
            j++;
            i++;
        }

        //3.
        //将temp的数组的元素拷贝到arr
        t=0;
        int tempLeft=left;
        int tempRight=right;
        while(tempLeft<=tempRight){
            arr[tempLeft]=temp[t];
            t++;
            tempLeft++;
        }


    }
}
