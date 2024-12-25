package leetcode;

import java.util.PriorityQueue;

/**
 * The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.
 * <p>
 * For example, for arr = [2,3,4], the median is 3.
 * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
 * Implement the MedianFinder class:
 * <p>
 * MedianFinder() initializes the MedianFinder object.
 * void addNum(int num) adds the integer num from the data stream to the data structure.
 * double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 * <p>
 * <p>
 * Time Complexity :
 * Insertion (addNum): O(logn) due to heap insertion and balancing.
 * Finding the median (findMedian): O(1) since it's just peeking at the top elements of the heaps.
 * <p>
 * Space Complexity:
 * O(n), where n is the number of elements in the stream, as we store all elements in the two heaps.
 */
public class Find_Median_Number_Stream {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public Find_Median_Number_Stream() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    // Finds the median of the current data stream
    public double findMedian() {
        if(maxHeap.size()> minHeap.size()){
            return maxHeap.peek();
        }else {
            return (maxHeap.peek()+minHeap.peek())/2.0;
        }
    }

    public static void main(String[] args) {
        Find_Median_Number_Stream mf = new Find_Median_Number_Stream();
        mf.addNum(1);
        mf.addNum(2);
        System.out.println("Median: " + mf.findMedian()); // Output: 1.5
        mf.addNum(3);
        System.out.println("Median: " + mf.findMedian()); // Output: 2
    }


}
