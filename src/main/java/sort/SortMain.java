package sort;

public class SortMain {

	public static void main(String[] args) {
       int[] a = {4,6,8,5,9};
       a = heapSort(a);
       for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
	}
	/**
	 * 插入排序
	 * 在要排序的一组数中，假设前面(n-1) [n>=2] 个数已经是排好顺序的，
	 * 现在要把第n个数插到前面的有序数中，使得这n个数也是排好顺序的。
	 * 如此反复循环，直到全部排好顺序。
	 * @param a
	 * @return
	 */
	public static int[] insertSort(int[] a) {
		for(int i=1;i<a.length;i++) {
			int insertNum = a[i];
			for(int j=i-1;j>=0;j--) {
				if(a[j]>insertNum) {
					a[j+1]=a[j];
					a[j]=insertNum;
				}else {
					break;
				}
			}
		}
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
		return a;
	}
	
	/**
	 * 插入排序递归算法
	 * @param a
	 */
	public static void insertSortV2(int[] a) {
		insertSortDigui(a, 9);
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
	}
	public static void insertSortDigui(int[] a ,int insertIndex) {
		if(insertIndex == 0) {
			return;
		}
		insertSortDigui(a, insertIndex-1);
		int insertNum = a[insertIndex];
		for(int i=insertIndex-1;i>=0;i--) {
			if(a[i]>insertNum) {
				a[i+1] = a[i];
				a[i] = insertNum;
			}else {
				break;
			}
		}
	}
	
	/**
	 * 选择排序
	 * 遍历整个序列，将最小的数放在最前面。
	 * 遍历剩下的序列，将最小的数放在最前面
	 * @param a
	 * @return
	 */
	public static int[] xuanzeSort(int[] a) {
		for(int i=0;i<a.length;i++) {
			int minNum = a[i];//记录最小值
			int index=i;//记录被交换的下标
			for(int j=i+1;j<a.length;j++) {
				if(minNum>a[j]) {
					index = j;
					minNum = a[j];
				}
			}
			if(index!=i) {
				a[index] = a[i];
				a[i] = minNum;
			}
		}
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
		return a;
	}
	
	/**
	 * 选择排序 递归算法
	 * @param a
	 * @return
	 */
	public static int[] xuanzeSortDigui(int[] a ,int index) {
		if(index <0) {
			return a;
		}
		xuanzeSortDigui(a, index-1);
		int minIndex = index;
		int minNum = a[index];
		for(int i =index+1;i<a.length;i++) {
			if(minNum>a[i]) {
				minIndex = i;
				minNum = a[i];
			}
		}
		if(index!=minIndex) {
			a[minIndex]=a[index];
			a[index] = minNum;
		}
		return a;
	}
	
	/**
	 * 交换排序
	 * 遍历比较时每次都要交换
	 */
	public static int[] jiaohuanSort(int[] a) {
		for(int i=0;i<a.length;i++) {
			for(int j=i+1;j<a.length;j++) {
				if(a[i]>a[j]) {
					int temp = a[j];
					a[j] = a[i];
					a[i] = temp;
				}
			}
		}
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
		return a;
	}
	
	/**
	 * 快速排序
	 * 选择第一个数为p，小于p的数放在左边，大于p的数放在右边
	 * 递归的将p左边和右边的数都按照第一步进行，直到不能递归
	 */
	public static int[] quickSort(int[] a,int startIndex,int endIndex) {
		if(endIndex<=startIndex) {
			return a;
		}
		int midIndex=startIndex;
		for(int i=startIndex+1;i<=endIndex;i++) {
			if(a[i]<a[midIndex]) {
				int temp = a[i];
				for(int j=i;j>midIndex;j--) {
					a[j]=a[j-1];
				}
				a[midIndex] = temp;
				midIndex++;
			}
		}
		quickSort(a, startIndex, midIndex-1);//左边
		quickSort(a, midIndex+1, endIndex);//右边
		return a;
	}
	
	/**
	 * 冒泡排序
	 * 将序列中所有元素两两比较，将最大的放在最后面。
	 * 将剩余序列中所有元素两两比较，将最大的放在最后面。
	 * @param a
	 * @param index
	 * @return
	 */
	public static int[] maopaoSort(int[] a ,int index) {
		if(index==1) {
			return a;
		}
		for(int i=0;i<index;i++) {
			for(int j=i+1;j<index;j++) {
				if(a[i]>a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		maopaoSort(a, index-1);
		return a;
	}
	
	/**
	 * 堆排序（https://www.cnblogs.com/chengxiao/p/6129630.html）
	 * a.将无需序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆;
　　      * b.将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
　　      * c.重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序。
	 */
	public static int[] heapSort(int[] arr) {
		for(int i = 0 ;i<arr.length;i++) {
			//从最左边的非叶子节点开始遍历,构造最大堆
			ajustHeap(arr,  (arr.length-i)/ 2 - 1);
			//首尾交换，将最大数沉入到尾部
			int tailData = arr[arr.length-1-i];
			arr[arr.length-1-i] = arr[0];
			arr[0] = tailData;
		}
		return arr;
	}
	
	/**
	 * 初始化堆
	 * @param a
	 */
	public static void ajustHeap(int[] arr,int index) {
		if(index < 0) {
			return;
		}
		int leftindex = 2 * index + 1;
		int rightindex = 2 * index + 2;
		if(leftindex < arr.length) {
			if(arr[index] < arr[leftindex]) {
				swap(arr, index, leftindex);
			}
		}
		if(rightindex < arr.length) {
			if(arr[index] < arr[rightindex]) {
				swap(arr, index, rightindex);
			}
		}
		ajustHeap(arr, index - 1);
	}
	
	public static void swap(int[] arr ,int index1,int index2) {
		int index1Temp = arr[index1];
		int index2Temp = arr[index2];
		arr[index1] = index2Temp;
		arr[index2] = index1Temp;
		//递归重新调整子节点
		tiaozheng(arr, index2);
	}
	public static void swap2(int[] arr ,int index1,int index2) {
		int index1Temp = arr[index1];
		int index2Temp = arr[index2];
		arr[index1] = index2Temp;
		arr[index2] = index1Temp;
		tiaozheng(arr, index2);
	}
	public static void tiaozheng(int[] arr,int topindex) {
		if(topindex>=arr.length) {
			return;
		}
		int leftindex = 2 * topindex + 1;
		int rightindex = 2 * topindex + 2;
		if(leftindex < arr.length) {
			if(arr[topindex] < arr[leftindex]) {
				swap2(arr, topindex, leftindex);
			}
		}
		if(rightindex < arr.length) {
			if(arr[topindex] < arr[rightindex]) {
				swap2(arr, topindex, rightindex);
			}
		}
	}
}
