package com.liz.select_sort;
import java.util.Arrays;


/**
 * 选择排序: 从欲排序的数据中，按照指定的规则选出某一元素，再按照规定交换位置后达到排序的目的
 * 基本思想:
 * 第一次从arr[0]-arr[n-1]中选取最小值，和arr[0]交换
 * 第二次从arr[1]-arr[n-1]中选取最小值，和arr[1]交换
 * 第三次从arr[2]-arr[n-1]中选取最小值，和arr[2]交换
 * ...
 * 第n-1从arr[n-2]-arr[n-1]中选取最小值，和arr[n-2]交换
 * <p>
 * 最后通过n-1次，得到从小到大的序列
 * (把最小的放在最开始...)
 * <p>
 * 5 3 2 1 7
 * （1） 1 5 3 2 7
 * （2） 1 2 3 5 7
 * （3） ok
 * <p>
 * 1. 选择排序一共有数组大小-1轮
 *
 * 2. 每一轮排序有时一个小循环，用来比较（先假定当前这个数是最小值）
 * 2.1 先假定当前这个数是最小值
 * 2.2 然后和后面数进行比较，如果有比当前值更小的，就重新确定最小值，并得到下标
 * 2.3 遍历到数组的最后时，就得到本轮的最小值和它的下标
 * 2.4 交换
 * <p>
 * 3. 将复杂的代码拆分成简单的问题 然后再进行解决
 */
//101 34 119 1
public class SelectSortTest {
    public static void main(String[] args) {
        int[] arr = {101, 119, 34, 1};
        System.out.print("排序前:");
        System.out.println(Arrays.toString(arr));
        int[] firstArray = selectedFirstSort(arr);
        System.out.println("第一轮过后:"+Arrays.toString(firstArray));
        //第一轮过后 1 119 34 101
        int[] secondArray = selectedSecondSort(firstArray);
        System.out.println("第二轮过后:"+Arrays.toString(secondArray));
        //第二轮过后 1 34 119 101
        //需要经过array.length-1轮

        int[]finalArray=selectAllSort(arr);
        System.out.println(Arrays.toString(finalArray));

    }
    //选择排序
    public static int[] selectAllSort(int []arr){
        for(int i=0;i<arr.length-1;i++){
            int minIndex = i;
                int min = arr[minIndex];
                for (int j = i + 1; j < arr.length; j++) {
                    //让数和后面的数进行比较
                    if (min > arr[j]) {
                        //假定的最小值不是最小的,所以要进行重置最小值
                        min = arr[j];
                        minIndex = j;
                    }
            }
            //开始进行交换 将最小值放在arr[0]
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }

            //System.out.println("第"+(i+1)+"轮过后:" + Arrays.toString(arr));
        }
        return arr;
    }
    //第一轮
    public static int[] selectedFirstSort(int[] arr) {

        /**
         * 内层循环确定逻辑
         *
         * 外层循环确定逻辑执行的次数(层次)
         * */
        //第一轮 1 34 119 101

        // 假设数组下标为0的值为最小值
        int minIndex = 0;
        int min = arr[minIndex];
        for (int j = 0 + 1; j < arr.length; j++) {
            //让数和后面的数进行比较
            if (min > arr[j]) {
                //假定的最小值不是最小的,所以要进行重置最小值
                min = arr[j];
                minIndex = j;
            }
        }
        //开始进行交换 将最小值放在arr[0]
        if (minIndex != 0) {
            arr[minIndex] = arr[0];
            arr[0] = min;
        }

        //System.out.println("第一轮过后:" + Arrays.toString(arr));
        return arr;

    }

    //第二轮
    public static int[] selectedSecondSort(int[] arr) {

        //第一轮 1 34 119 101

        // 假设数组下标为0的值为最小值
        int minIndex = 1;
        int min = arr[minIndex];
        for (int j = 1 + 1; j < arr.length; j++) {
            //让数和后面的数进行比较
            if (min > arr[j]) {
                //假定的最小值不是最小的,所以要进行重置最小值
                min = arr[j];
                minIndex = j;
            }
        }
        //开始进行交换 将最小值在arr[1]
        if (minIndex != 1) {
            arr[minIndex] = arr[1];
            arr[1] = min;
        }

        //System.out.println("第二轮过后:" + Arrays.toString(arr));
        return arr;
    }

}
