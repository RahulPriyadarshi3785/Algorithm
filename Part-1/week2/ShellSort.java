package week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Beat classical sort methods in medium sized arrays
public class ShellSort<T> {
	
	//Knuth's function for shell sort
	//0(n^3/2) in practice much better
	public static List<Integer> shellSortIncrementSeqFunction(int length) {
		List<Integer> res = new ArrayList<>();
		for(int i = 0; i < length; i++)
				res.add(3 * i + 1);
		return res;
	}
	
	//Sedwick function after a year research good function tough to compete
	private List<Integer> shellSortIncrementSeqFunctionGood(int length) {
		int argForFunction1 = 0;
		int argForFunction2 = 2;
		List<Integer> res = new ArrayList<>();
		while(true) {
			int val1 = shellSortArgFunction1(argForFunction1);
			int val2 = shellSortArgFunction2(argForFunction2);
			if(val1 < val2) {
				if(val1 >= length)
					break;
				res.add(val1);
				argForFunction1++;
			} else {
				if(val2 >= length)
					break;
				res.add(val2);
				argForFunction2++;
			}
		}
		return res;
	}
	
	private int shellSortArgFunction1(int arg) {
		return (int)(9 * Math.pow(4, arg) - 9 * Math.pow(2, arg) + 1);
	}
	
	private int shellSortArgFunction2(int arg) {
		return (int)(Math.pow(4, arg) - 3 * Math.pow(2, arg) + 1);
	}
	

	@SuppressWarnings("unchecked")
	private boolean less(Comparable<T> thisComparable, Comparable<T> thatComparable) {
//		if(!Comparable.class.isAssignableFrom(thisComparable.getClass()))
//			throw new IllegalArgumentException();
		return thisComparable.compareTo((T) thatComparable) < 0;
	}
	
	private void exchange(Object[] comparableArray, int thisIndex, int thatIndex) {
		Object temp = comparableArray[thisIndex];
		comparableArray[thisIndex] = comparableArray[thatIndex];
		comparableArray[thatIndex] = temp;
	}
	
	public boolean isSorted(Comparable<T>[] comparableArray) {
		boolean res = true;
		int len = comparableArray.length;
		for(int i = 1; i < len; i++)
			res &= !less(comparableArray[i], comparableArray[i - 1]);
		return res;
	}
	
	public void shellSort(Comparable<T>[] comparableArray) {
		int len = comparableArray.length;
		List<Integer> incrementSequence = shellSortIncrementSeqFunctionGood(len);
		int seqLen = incrementSequence.size() - 1;
		for(int i = seqLen; i >= 0; i--) {
			int step = incrementSequence.get(i);
			//h-sorting the array
			for(int j = step; j < len; j++)
				for(int k = j; k >= step && less(comparableArray[k], comparableArray[k-step]); k -= step)
					exchange(comparableArray, k, k-step);
		}
		assert isSorted(comparableArray);
	}
	
	private void show(Comparable<T>[] comparableArray) {
		Arrays.stream(comparableArray).forEach(x -> System.out.print(x + ", "));
		System.out.println();
	} 
	
	public static void main(String[] args) {
		ShellSort<Integer> s = new ShellSort<>();
		s.shellSortIncrementSeqFunctionGood(2162).forEach(x -> System.out.print(x + " -> "));
		Integer[] test1 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,14,14,14,14,14,14,21};
		System.out.println();
		System.out.println(s.isSorted(test1));
		s.shellSort(test1);
		s.show(test1);
		Integer[] test2 = {1,2,3,43,5,6,17,87,9,10,101,12,13,14,14,154,14,194,154,14,21,0};
		System.out.println(s.isSorted(test2));
		s.show(test2);
		s.shellSort(test2);
		s.show(test2);
	}

}
