import java.util.ArrayList;

public class Main {
	
	public static ArrayList<Integer> quickSort(ArrayList<Integer> a) {
		
		if (a.size() > 1) {
			
			// Get the value in the middle of the array
			int middleIndex = a.size() / 2;
			int pivot = a.get(middleIndex);
			
			ArrayList<Integer> smaller = new ArrayList<Integer>();
			ArrayList<Integer> equal = new ArrayList<Integer>();
			ArrayList<Integer> larger = new ArrayList<Integer>();
			int s = 0, l = 0, e = 0;
			
			// Determine in which category (smaller, equal or larger) the values of partition1 and partition2 belong
			while (!a.isEmpty()) {
				
				int x = a.remove(0);
				
				if (x < pivot) {
					smaller.add(s, x);
					s++;
				}
				
				if (x == pivot) {
					equal.add(e, x);
					e++;
				}
				
				if (x > pivot) {
					larger.add(l, x);
					l++;
				}
			}
			
			ArrayList<Integer> r1 = quickSort(smaller);
			ArrayList<Integer> r2 = quickSort(larger);
			
			ArrayList<Integer> result = new ArrayList<Integer>();
			
			// Merge the three groups back together
			result.addAll(0, r1);
			result.addAll(result.size(), equal);
			result.addAll(result.size(), r2);
			
			return result;
			
		}
		
		return a;
		
	}

	public static void main(String[] args) {
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(39);al.add(45);al.add(4);al.add(1);al.add(0);al.add(5);al.add(6);al.add(6);al.add(78);al.add(99);al.add(1000);
		
		ArrayList<Integer> result = quickSort(al);
		
		System.out.println("Sorted array: ");
		System.out.println(result.toString());
		
	}	

}
