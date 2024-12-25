package interview;

import java.util.*;

/*
  Note: the Plan start from the truck's location(0,0). The distance of the truck from a delivery destination(x,y) is the square root of x2+y2.
        IF there are ties then return any of the location as long as you satisfy returning X deliveries. 
 Input: 
 numDestination =3
 allLocations =[[1,2],[3,4],[1-1]]
 numDeleveries= 2
 
 
 Output: 
 [1,-1], [1,2]
 */
public class AmazonGroceryExample {
	List<List<Integer>> closeXdestinations(int numDestination, List<List<Integer>> allLocations, int numDeleveries) {
		List<List<Integer>> returnAllLocations = new ArrayList<>();
		TreeMap<Integer, List<Integer>> iterateValue = new TreeMap<Integer, List<Integer>>();
		for (int i = 0; i < allLocations.size(); i++) {
			System.out.println(allLocations.get(i));
			List<Integer> location = allLocations.get(i);
			location.get(0);
			int squareX = (int) Math.pow(location.get(0), 2);
			int squareY = (int) Math.pow(location.get(1), 2);
			// System.out.println("squareX : " + squareX);
			// System.out.println("squareY : " + squareY);
			int rootVal = (int) Math.sqrt(Math.abs(squareX) + Math.abs(squareY));
			System.out.println("rootVal :" + rootVal);
			iterateValue.put(rootVal, allLocations.get(i));
		}
		System.out.println("Iteration Map..............................\n \n ");
		Iterator it = iterateValue.entrySet().iterator();
		int count = 0;
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			System.out.println("count : " + count);
			System.out.println("numDeleveries : " + numDeleveries);
			System.out.println(pair.getKey() + " = " + pair.getValue());
			if (count < numDeleveries) {
				if (numDeleveries <= numDestination) {
					System.out.println("Inside count : " + count);
					returnAllLocations.add((List<Integer>) pair.getValue());
				}
			}
			count++;
		}
		return returnAllLocations;
	}

	public static void main(String[] args) {
		AmazonGroceryExample grocery = new AmazonGroceryExample();
		int numDestination = 3;

		List<Integer> location1 = new ArrayList<>();
		location1.add(1);
		location1.add(2);

		List<Integer> location2 = new ArrayList<>();
		location2.add(3);
		location2.add(4);

		List<Integer> location3 = new ArrayList<>();
		location3.add(1);
		location3.add(-1);

		List<List<Integer>> allLocations = new ArrayList<>();
		allLocations.add(location1);
		allLocations.add(location2);
		allLocations.add(location3);

		int numDeleveries = 2;

		List<List<Integer>> returnAllLocations = grocery.closeXdestinations(numDestination, allLocations,
				numDeleveries);
		/*
		 * int square = (int) Math.pow(4, 2); System.out.println("square : "+square);
		 */
		System.out.println("Result .......... \n \n ");
		for (int i = 0; i < returnAllLocations.size(); i++) {

			System.out.println(returnAllLocations.get(i));
		}

	}

}
