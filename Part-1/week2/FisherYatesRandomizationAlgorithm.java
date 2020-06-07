package week2;

import java.util.Arrays;
import java.util.Random;

//Knuth Shuffle
public class FisherYatesRandomizationAlgorithm<T> {

	public T[] fisherYatesRandomizationAlgorithm(T[] t) {
		Random random = new Random();
		int length = t.length;
		for(int i = length-1; i > 0; i--)
			exchange(t, i, random.nextInt(i + 1));
		return t;
	}
	
	private void exchange(T[] t, int i, int j) {
		T temp = t[i];
		t[i] = t[j];
		t[j] = temp;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Integer[]{1,2,3,4,5}));
		Arrays.stream(new FisherYatesRandomizationAlgorithm<Integer>().fisherYatesRandomizationAlgorithm(new Integer[]{1,2,3,4,5})).forEach(x -> System.out.print(x + ", "));
	}

}
