package Week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

	//Memory - O(1), Time - O(n^2)
	public static List<List<Integer>> threeSum(int[] arr) {
		// TODO Auto-generated method stub

		List<List<Integer>> res = new ArrayList<>();
		int len = arr.length;
		Arrays.parallelSort(arr);
		for(int i = 0; i < len; i++) {
			int l = i + 1;
			int r = len - 1;
			while(l < r)
				if(arr[i] + arr[l] + arr[r] == 0)
					res.add(Arrays.asList(arr[i], arr[l], arr[r]));
				else if(arr[i] + arr[l] + arr[r] > 0)
					r--;
				else
					l++;
		}
			
		return res;
	}
	
	//Memory - O(n), Time - O(n^2)
	public static List<List<Integer>> HashThreeSum(int[] arr) {
		// TODO Auto-generated method stub

		List<List<Integer>> res = new ArrayList<>();
		int len = arr.length;
		Arrays.parallelSort(arr);
		for(int i = 0; i < len - 1; i++) {
			Set<Integer> hs = new HashSet<>();
			for(int j = i + 1; j < len; j++)
				if(hs.contains((arr[i]+arr[j])*-1))
					res.add(Arrays.asList(arr[i],arr[j],-1*(arr[i]+arr[j])));
				else
					hs.add(j);
		}
		return res;
	}

}
