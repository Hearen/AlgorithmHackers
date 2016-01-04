package leetcode_njz;

public class _004_medianOfTwoSortedArrays {
	
	//快排实现－－－超�?
	public static double findMedianSortedArrays(int[] a, int[] b){
		if(a==null && b==null){
			return 0;
		}else if(a==null){
			if(b.length%2 == 0)
				return (b[b.length/2-1]+b[b.length/2])/2.0;
			else 
				return (double)b[b.length/2];
		}else if(b == null){
			if(a.length%2 == 0)
				return (a[a.length/2-1]+a[a.length/2])/2.0;
			else 
				return (double)a[a.length/2];
		}else{
			int a_len = a.length;
			int b_len = b.length;
			int L = a_len + b_len;
			int[] c = new int[L];
			
			System.arraycopy(a, 0, c, 0, a_len);
			System.arraycopy(b, 0, c, a_len, b_len);
			
			for(int i=0; i<L; i++)
				System.out.print(c[i]+" ");
			System.out.println();
			
			quickSort(c,0,L-1);
			
			for(int k=0; k<L; k++){
				System.out.println(k+" : "+c[k]);
			}
			
			if(L%2 == 0)
				return (c[c.length/2-1]+c[c.length/2])/2.0;
			else 
				return (double)c[c.length/2];
		}
		
	}//end find
	
	private static void quickSort(int[] c, int left, int right) {
		if(left<right){
			int mid = getMiddle(c, left, right);
			quickSort(c, left, mid-1);
			quickSort(c, mid+1, right);
		}
	}
	
	private static int getMiddle(int[] list, int left, int right){
		
		int temp = list[left];//数组第一位作为标志位（待比较�?
		while(left < right){
			while(left<right && list[right] >= temp){
				right--;
			}
			list[left] = list[right];
			
			while(left<right && list[left] <= temp){
				left++;
			}
			list[right] = list[left];
		}
		list[left] = temp;
		return left;
	}

	//归并思想
	public static double findMedianSortedArrays1(int[] a, int[] b){
		if((a==null && b==null) || (a.length==0&&b.length==0)){
			return 0;
		}else if(a==null || a.length==0){
			if(b.length%2 == 0)
				return (b[b.length/2-1]+b[b.length/2])/2.0;
			else 
				return (double)b[b.length/2];
		}else if(b == null || b.length==0){
			if(a.length%2 == 0)
				return (a[a.length/2-1]+a[a.length/2])/2.0;
			else 
				return (double)a[a.length/2];
		}else{
			int a_len = a.length;
			int b_len = b.length;
			int L = a_len + b_len;
			int[] c = new int[L];
			
			int count = 0;
			int i = 0, j = 0;
			while(count <= L/2){
				if(i<a.length && j<b.length){
					if(a[i] >= b[j]){
						c[count] = b[j];
						j++;
					}else if(a[i] < b[j]){
						c[count] = a[i];
						i++;
					}
				}else if(i >= a.length){
					c[count] = b[j];
					j++;
				}else{
					c[count] = a[i];
					i++;
				}
				count++;
			}
			
			if(L%2 == 0)
				return (c[c.length/2-1]+c[c.length/2])/2.0;
			else 
				return (double)c[c.length/2];

		}
	}//end find1
	
	public static void main(String[] args){
		//两个排序好的数组
//		int[] a = {0,1,3,4,5,6,34,1231};
//		int[] b = {3,5,7,9,12,123,453,976};
		int[] a = {1,3,4,5,6};
		int[] b = {1};
		double medial = findMedianSortedArrays1(a, b);
		System.out.println("\nmedial:"+medial);
	}
}
