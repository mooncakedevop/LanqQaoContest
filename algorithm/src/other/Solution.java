package other;


import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
//     堆排序O（nlogn）
    public int smallestK(int[] arr, int k) {
//            java内置小顶堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(k);
        for (int num : arr)
            heap.offer(num);
        return heap.poll();
    }
//    排序法:O(nlogn) S(1)
//
//    对数据进行排序然后直接取data[k]


    int find_k(int[] data,int k){

        Arrays.sort(data);//java内置O(nlogn)

        return data[k];

    }

}

