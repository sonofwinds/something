package sort;

public class SortMain {

	public static void main(String[] args) {
       int[] a = {3,5,1,88,99,44,64,22,6,34};
       a = quickSort(a,0,a.length-1);
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
}
