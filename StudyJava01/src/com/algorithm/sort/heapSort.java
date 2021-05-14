package com.algorithm.sort;

/**
 * @author Liutao0705@live.com
 * @date 2021/5/11 5:26 下午
 */
public class heapSort {
        public int findKthLargest(int[] nums, int k) {
            buildMaxHeap(nums);
            // 调整 k-1 次
            for (int i = nums.length - 1; i > nums.length - k; i--) {
                swap(nums, 0, i);
                maxHeapify(nums, 0, i);
            }
            // 此时，堆顶的元素就是第 k 大的数
            return nums[0];
        }

        // 构建初始大顶堆
        public static void buildMaxHeap(int[] arr) {
            // 从最后一个非叶子结点开始调整大顶堆，最后一个非叶子结点的下标就是 arr.length / 2-1
            for (int i = arr.length / 2 - 1; i >= 0; i--) {
                maxHeapify(arr, i, arr.length);
            }
        }

        // 调整大顶堆，第三个参数表示剩余未排序的数字的数量，也就是剩余堆的大小
        private static void maxHeapify(int[] arr, int i, int heapSize) {
            // 左子结点下标
            int l = 2 * i + 1;
            // 右子结点下标
            int r = l + 1;
            // 记录根结点、左子树结点、右子树结点三者中的最大值下标
            int largest = i;
            // 与左子树结点比较
            if (l < heapSize && arr[l] > arr[largest]) {
                largest = l;
            }
            // 与右子树结点比较
            if (r < heapSize && arr[r] > arr[largest]) {
                largest = r;
            }
            if (largest != i) {
                // 将最大值交换为根结点
                swap(arr, i, largest);
                // 再次调整交换数字后的大顶堆
                maxHeapify(arr, largest, heapSize);
            }
        }

        private static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

    }

