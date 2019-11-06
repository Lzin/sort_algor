package com.liz.quick_sort;

import java.util.Arrays;

/**
 * 快速排序:(核心在递归)
 * 对冒泡排序的一种改进，通过一趟排序将要排序的数据分割成独立的两部分(先找到基准值 左边比它小 右边比它大)，其中一部分的所有数据比另外一部分要小
 * 然后再按照此方法对这两部分数据分别进行快速排序
 * 整个过程可以使用递归的方法进行
 */
public class QuickSortTest {


    public static void main(String[] args) {
        int[] arr = {3,5,4,2,4};
        System.out.println("排序前:"+Arrays.toString(arr));
        quickSort(arr,0,arr.length-1);
        System.out.println("排序后"+ Arrays.toString(arr));
    }
    public static void quickSort(int[] arr, int left, int right) {
        int l = left;//左下标
        int r = right;//右下标
        int temp = 0;
        //pivot 中轴值
        int pivot = arr[(left + right) / 2];
        //while循环的目的就是让比pivot小的值 放到左边 比pivot大的放在右边
        while (l < r) {
            //设置退出条件

            //在pivot的左边一直找，找到一个大于或者等于pivot的值才退出
            while (arr[l] < pivot) {
                l++;
            }
            //在pivot的右边一直找，找到一个小于或者等于pivot的值才退出
            while (arr[r] > pivot) {
                r--;
            }
            if (l >= r) {
                break;
            }
            //现在已经找到了arr[l]>=arr[pivot] arr[r]<=arr[pivot] 开始喜闻乐见的交换环节
            temp = arr[l];
            arr[l]=arr[r];
            arr[r]=temp;

            //如果交换完之后发现arr[l] == pivot（细节）将r--
            if(arr[l]==pivot){
                r--;
            }
            //如果交换完之后发现arr[r] == pivot（细节）将l++
            if(arr[r]==pivot){
                l++;
            }

        }
        //开始进行递归操作

        //如果l==r为了防止栈溢出
        if(l==r){
            l++;
            r--;
        }
        //向左递归
        if(left<r){
            quickSort(arr,left,r);
        }
        //向右递归
        if(right>l){
            quickSort(arr,l,right);
        }
    }


}
