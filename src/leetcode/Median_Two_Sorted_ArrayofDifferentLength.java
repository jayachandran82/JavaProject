package leetcode;

import java.util.Arrays;
/**

	0	1	2	3	4	5	
x	1	3	8	9	15
    x1  x2  x3  x4  x5
Y	7	11	18	19	21	25
    y1  y2  y3  y4  y5  y6
1,3 		| 8,9,15
7,11,18,19	| 21, 25

Rule  is ===>  x2 <= y5 && y4 <= x3

start=0, end= 4
PartitionX=(start+end)/2        =========> (0+4)/2 =2
PartitionY=(x+y+1)/2 - PartitionX =========>  (5+6+1)/2 -2 =  4

found
maxleftX<= MinRightY
maxLeftY<= MinRightX

elseif
	maxLeftX > minRightY 
	Move towards left in X
else
	Move towards right in X
 
 */
public class Median_Two_Sorted_ArrayofDifferentLength {

	public double findMedianSortArray(int input1[], int input2[]) {
		if (input1.length > input2.length) {
			return findMedianSortArray(input2, input1);
		}
		System.out.println("input1.length : "+input1.length +" \n   Contains : "+ Arrays.toString(input1));
		System.out.println("input2.length : "+input2.length +" \n   Contains : "+ Arrays.toString(input2));
		int x = input1.length;
		int y = input2.length;
		int start = 0;
		int end = x;
		while (start <= end) {
			int partitionX = (start + end) / 2;
			int partitionY = (x + y + 1) / 2 - partitionX;
			
			//if PartitionX is 0 it means nothing is there is on left side. Use -INFINITE  for maxleftX
			//if partitionX is length of input then there is nothing on right side. Use +INFINITE for maxRightX
			int maxleftX = (partitionX == 0) ? Integer.MIN_VALUE : input1[partitionX - 1];
			int minRightX = (partitionX == x) ? Integer.MAX_VALUE : input1[partitionX];

			int maxleftY = (partitionY == 0) ? Integer.MIN_VALUE : input2[partitionY - 1];
			int minRightY = (partitionY == y) ? Integer.MAX_VALUE : input2[partitionY];

			if (maxleftX <= minRightY && maxleftY <= minRightX) {
				if ((x + y) % 2 == 0) {
					return ((double) Math.max(maxleftX, minRightY) + Math.min(maxleftY, minRightX)) / 2;
				} else {
					return (double) Math.max(maxleftX, minRightY);
				}
			} else if (maxleftX > minRightY) {  // we are too far on right side for PartitionX. Go on left side.
				end = partitionX - 1;
			} else { // we are too far on left side for PartitionX. Go on right side.
				start = partitionX + 1;
			}
		}
		throw new IllegalArgumentException();
	}

	public static void main(String[] args) {
		int[] x = { 1, 3, 8, 9, 15 };
		Arrays.sort(x);
		int[] y = { 7, 11,  19, 21, 18, 25 };
		Arrays.sort(y);
		Median_Two_Sorted_ArrayofDifferentLength medArr = new Median_Two_Sorted_ArrayofDifferentLength();
		System.out.println("Value : "+ medArr.findMedianSortArray(x, y));
	}

}
