package com.liz.shell_sort;

import java.util.Arrays;

public class ShellSortTest {
    /**
     * 1.在简单排序的技术上经过改进得到希尔排序(通过步长实现分割)
     * <p>
     * 2.算法思想:
     * 把记录按照下标进行分组，对每一组进行直接插入排序(设置步长而分组，并不是单纯临近分组)
     * 随着增量的减少，每组包含的关键词越来越多，当增量减到1的时候，文件被分为1组，再对最后一组进行直接插入排序，算法终止
     * <p>
     * 3.使用交换法的时候，算法的效率缓慢
     * if (arr[j] > arr[j + 5]) {
     * //标准的交换方法
     * temp = arr[j];
     * arr[j] = arr[j + 5];
     * arr[j + 5] = temp;
     * }
     *
     * 但是使用移位法的时候，算法的效率较高
     *
     */

    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        //shellThirdSort(shellSecondSort(shellFirstSort(arr)));
        // shellFinalSwapSort(arr);
        shellFinalMoveSort(arr); //效率较高
    }
    //逐步推导

    //第一轮希尔排序
    public static int[] shellFirstSort(int[] arr) {
        int temp = 0;
        //第一轮排序是将十个数据分成了5组[遍历五次]
        for (int i = 5; i < arr.length; i++) {
            //(共五组，每组2个元素) 步长5
            for (int j = i - 5; j >= 0; j -= 5) {
                //如果当前的元素大于步长之后的那个元素，可以直接进行交换(效率过低 采用移位)
                if (arr[j] > arr[j + 5]) {
                    //标准的交换方法
                    temp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j + 5] = temp;
                }
            }
        }
        System.out.println("第一轮希尔排序后:" + Arrays.toString(arr));
        return arr;
    }

    //第二轮希尔排序
    public static int[] shellSecondSort(int[] arr) {
        int temp = 0;
        for (int i = 2; i < arr.length; i++) {
            for (int j = i - 2; j >= 0; j -= 2) {
                //如果当前元素大于步长之后的那个元素，可以直接进行交换
                if (arr[j] > arr[j + 2]) {
                    temp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j + 2] = temp;
                }
            }
        }
        System.out.println("第二轮希尔排序后:" + Arrays.toString(arr));
        return arr;
    }

    //第三轮希尔排序
    public static int[] shellThirdSort(int[] arr) {
        int temp = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j -= 1) {
                //如果当前元素大于步长之后的那个元素，可以直接进行交换
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("第三轮希尔排序后:" + Arrays.toString(arr));
        return arr;
    }

    //交换法
    public static void shellFinalSwapSort(int[] arr) {
        int temp = 0;
        int count = 0;
        //定义一个变量确定步长
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //遍历数组
            for (int i = gap; i < arr.length; i++) {
                //找到相应步长对应的值 进行比较
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            System.out.println("希尔排序第" + (++count) + "轮" + " " + Arrays.toString(arr));
        }
    }

    //移位法
    public static void shellFinalMoveSort(int[] arr) {
        int count = 0;
        //增量gap。并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素，逐个对其所在的组进行排序
            //比较arr[gap]和arr[j-gap]
            for (int i = gap; i < arr.length; i++) {
                //保存变量
                int j = i;
                int temp = arr[j];

                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //当前arr后移
                        arr[j] = arr[j - gap];

                        j -= gap;//为了跳出循环 同时让指针找到插入
                    }
                    //当退出while循环后 找到了插入的位置
                    arr[j] = temp;
                }
            }
            System.out.println("希尔排序第" + (++count) + "轮" + " " + Arrays.toString(arr));
        }
    }
}


