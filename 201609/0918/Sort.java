package test;

public class Sort {
	/**
	 * 直接插入排序  稳定
	 * 
	 * 每步将一个待排序的记录，按其顺序码大小插入到前面已经排序的字序列的合适位置（从后向前找到合适位置后），直到全部插入排序完为止。
	 * @param a
	 * @return
	 */
	public static int[] DirectInsertSort(int[] a){
		if(a.length<=1){
			return a;
		}
		int[] b = new int[a.length];
		b[0]=a[0];
		for(int i=1;i<a.length;i++){
			for(int j=i-1;j>=0;j--){
				if(a[i]<b[j]){//从后向前遍历
					b[j+1]=b[j];
					if(j==0){
						b[j]=a[i];
					}
				}else{
					b[j+1]=a[i];
					break;
				}
			}
		}
		return b;
	}
	/**
	 * 二分插入排序   稳定
	 * 
	 * 二分法插入排序的思想和直接插入一样，只是找合适的插入位置的方式不同，这里是按二分法找到合适的位置，可以减少比较的次数。
	 * @param a
	 * @return
	 */
	public static int[] SecondInsertSort(int [] a){
		if(a.length<=1){
			return a;
		}
		int[] b = new int[a.length];
		b[0]=a[0];
		for(int i=1;i<a.length;i++){
			int temp =a[i];
			int left =0;
			int right=i-1;
			int mid=0;
			while(right>=left){
				mid=(left+right)/2;
				if(temp<b[mid]){
					right=mid-1;
				}else{
					left=mid+1;
				}
			}
			for (int j = i-1; j >= left; j--) {//平滑后移
				b[j+1] = b[j];
			}
			b[left] = temp;
		}
		return b;
	}
	/**
	 * 希尔排序   不稳定
	 * 
	 * 先取一个小于n的整数d1作为第一个增量，把文件的全部记录分成d1个组。
	 * 所有距离为d1的倍数的记录放在同一个组中。先在各组内进行直接插入排序；
	 * 然后，取第二个增量d2<d1重复上述的分组和排序，直至所取的增量dt=1(dt<dt-l<…<d2<d1)，
	 * 即所有记录放在同一组中进行直接插入排序为止。
	 * @param a
	 * @return
	 */
	public static int[] HillSort(int[] a){
		if(a.length<=1){
			return a;
		}
		int d=a.length;
		while(true){
			d=d/2;
			for(int m=0;m<d;m++){
				for(int i=m+d;i<a.length;i=i+d){
					int temp=a[i];
					int j;
					for(j=i-d;j>=0&&a[j]>temp;j=j-d){
						a[j+d]=a[j];
					}
					a[j+d]=temp;
				}
			}
			if(d==1){
				break;
			}
		}
		return a;
	}
	/**
	 * 简单选择排序  不稳定
	 * 
	 * 在要排序的一组数中，选出最小的一个数与第一个位置的数交换；
	 * 然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。
	 * @param a
	 * @return
	 */
	public static int[] SimpleSelectSort(int[] a){
		if(a.length<=1){
			return a;
		}
		for(int i=0;i<a.length-1;i++){
			int min=a[i];
			int m=i;
			for(int j=i;j<a.length;j++){
				if(a[j]<min){
					m=j;
					min=a[j];
				}
			}
			a[m]=a[i];
			a[i]=min;
			
		}
		return a;
	}
	/**
	 * 堆排序  不稳定
	 * @param a
	 * @return
	 */
	public static int[] PileSort(int[] a){
		if(a.length<=1){
			return a;
		}
		for(int i=0;i<a.length-1;i++){
			buildMaxHeap(a, a.length-1-i);
			swap(a,  0, a.length-1-i);
		}
		return a;
	}
	//建立大根堆
	public static void buildMaxHeap(int[] data,int lastIndex){
		for(int i=(lastIndex-1)/2;i>=0;i--){
			int k=i;
			while(k*2+1<=lastIndex){
				int biggerIndex=2*k+1;
				if(biggerIndex<lastIndex){
					if(data[biggerIndex]<data[biggerIndex+1]){
						biggerIndex++;
					}
				}
				if(data[k]<data[biggerIndex]){
					swap(data,k,biggerIndex);
					k=biggerIndex;
				}else{
					break;
				}
			}
		}
	}
	//交换
	public  static void swap(int[] data,int i,int j){
		int temp=data[i];
		data[i]=data[j];
		data[j]=temp;
	}
	/**
	 * 冒泡排序  稳定
	 * 
	 * 在要排序的一组数中，对当前还未排好序的范围内的全部数，自上而下对相邻的两个数依次进行比较和调整，
	 * 让较大的数往下沉，较小的往上冒。即：每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换。
	 * @param a
	 * @return
	 */
	public static int[] BubbleSort(int[] a){
		if(a.length<=1){
			return a;
		}
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a.length-i-1;j++){
				if(a[j]>a[j+1]){
					int temp =a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
			
		}
		return a;
	}
	/**
	 * 归并排序   稳定
	 * 
	 * 将两个（或两个以上）有序表合并成一个新的有序表，即把待排序序列分为若干个子序列，
	 * 每个子序列是有序的。然后再把有序子序列合并为整体有序序列
	 * @param a
	 * @return
	 */
	public static void mergeSort(int[] a,int left, int right){
		if(left<right){
	         int middle = (left+right)/2;
	         //对左边进行递归
	         mergeSort(a, left, middle);
	         //对右边进行递归
	         mergeSort(a, middle+1, right);
	         //合并
	         merge(a,left,middle,right);
	     }
	}
	
	
	private static void merge(int[] a, int left, int middle, int right) {
         int[] tmpArr = new int[a.length];
         int mid = middle+1; //右边的起始位置
         int tmp = left;
         int third = left;
         while(left<=middle && mid<=right){
             //从两个数组中选取较小的数放入中间数组
             if(a[left]<=a[mid]){
                 tmpArr[third++] = a[left++];
             }else{
                 tmpArr[third++] = a[mid++];
             }
         }
         //将剩余的部分放入中间数组
         while(left<=middle){
             tmpArr[third++] = a[left++];
         }
         while(mid<=right){
             tmpArr[third++] = a[mid++];
         }
         //将中间数组复制回原数组
         while(tmp<=right){
             a[tmp] = tmpArr[tmp++];
         }
     }
	public static void main(String[] args) {
		int[] a ={-49,38,65,97,76,-13,27,49,-78,34,12,64,1};
		int[] b=Sort.BubbleSort(a);
		Sort.mergeSort(a, 0, a.length-1);
		for (int i : b) {
			System.out.print(i+"  ");
		}
		System.out.println();
		for (int i : a) {
			System.out.print(i+"  ");
		}
	}

}
