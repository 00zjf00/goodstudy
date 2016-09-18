package test;

public class Sort {
	/**
	 * ֱ�Ӳ�������  �ȶ�
	 * 
	 * ÿ����һ��������ļ�¼������˳�����С���뵽ǰ���Ѿ�����������еĺ���λ�ã��Ӻ���ǰ�ҵ�����λ�ú󣩣�ֱ��ȫ������������Ϊֹ��
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
				if(a[i]<b[j]){//�Ӻ���ǰ����
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
	 * ���ֲ�������   �ȶ�
	 * 
	 * ���ַ����������˼���ֱ�Ӳ���һ����ֻ���Һ��ʵĲ���λ�õķ�ʽ��ͬ�������ǰ����ַ��ҵ����ʵ�λ�ã����Լ��ٱȽϵĴ�����
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
			for (int j = i-1; j >= left; j--) {//ƽ������
				b[j+1] = b[j];
			}
			b[left] = temp;
		}
		return b;
	}
	/**
	 * ϣ������   ���ȶ�
	 * 
	 * ��ȡһ��С��n������d1��Ϊ��һ�����������ļ���ȫ����¼�ֳ�d1���顣
	 * ���о���Ϊd1�ı����ļ�¼����ͬһ�����С����ڸ����ڽ���ֱ�Ӳ�������
	 * Ȼ��ȡ�ڶ�������d2<d1�ظ������ķ��������ֱ����ȡ������dt=1(dt<dt-l<��<d2<d1)��
	 * �����м�¼����ͬһ���н���ֱ�Ӳ�������Ϊֹ��
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
	 * ��ѡ������  ���ȶ�
	 * 
	 * ��Ҫ�����һ�����У�ѡ����С��һ�������һ��λ�õ���������
	 * Ȼ����ʣ�µ�������������С����ڶ���λ�õ������������ѭ���������ڶ����������һ�����Ƚ�Ϊֹ��
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
	 * ������  ���ȶ�
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
	//���������
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
	//����
	public  static void swap(int[] data,int i,int j){
		int temp=data[i];
		data[i]=data[j];
		data[j]=temp;
	}
	/**
	 * ð������  �ȶ�
	 * 
	 * ��Ҫ�����һ�����У��Ե�ǰ��δ�ź���ķ�Χ�ڵ�ȫ���������϶��¶����ڵ����������ν��бȽϺ͵�����
	 * �ýϴ�������³�����С������ð������ÿ�������ڵ����ȽϺ������ǵ�����������Ҫ���෴ʱ���ͽ����ǻ�����
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
	 * �鲢����   �ȶ�
	 * 
	 * �����������������ϣ������ϲ���һ���µ���������Ѵ��������з�Ϊ���ɸ������У�
	 * ÿ��������������ġ�Ȼ���ٰ����������кϲ�Ϊ������������
	 * @param a
	 * @return
	 */
	public static void mergeSort(int[] a,int left, int right){
		if(left<right){
	         int middle = (left+right)/2;
	         //����߽��еݹ�
	         mergeSort(a, left, middle);
	         //���ұ߽��еݹ�
	         mergeSort(a, middle+1, right);
	         //�ϲ�
	         merge(a,left,middle,right);
	     }
	}
	
	
	private static void merge(int[] a, int left, int middle, int right) {
         int[] tmpArr = new int[a.length];
         int mid = middle+1; //�ұߵ���ʼλ��
         int tmp = left;
         int third = left;
         while(left<=middle && mid<=right){
             //������������ѡȡ��С���������м�����
             if(a[left]<=a[mid]){
                 tmpArr[third++] = a[left++];
             }else{
                 tmpArr[third++] = a[mid++];
             }
         }
         //��ʣ��Ĳ��ַ����м�����
         while(left<=middle){
             tmpArr[third++] = a[left++];
         }
         while(mid<=right){
             tmpArr[third++] = a[mid++];
         }
         //���м����鸴�ƻ�ԭ����
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
