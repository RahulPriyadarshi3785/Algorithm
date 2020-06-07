package week2;

import java.util.ArrayList;
import java.util.List;

public class ShellSortIncrementSeqFunction {
	
	public static List<Long> shellSortIncrementSeqFunctionGood(int length) {
		int argForFunction1 = 0;
		int argForFunction2 = 2;
		List<Long> res = new ArrayList<>();
		for(int i = 0; i < length; i++) {
			long val1 = shellSortArgFunction1(argForFunction1);
			long val2 = shellSortArgFunction2(argForFunction2);
			if(val1 < val2) {
				res.add(val1);
				argForFunction1++;
			} else {
				res.add(val2);
				argForFunction2++;
			}
		}
		return res;
	}
	
	public static List<Long> shellSortIncrementSeqFunction(int length) {
		List<Long> res = new ArrayList<>();
		for(int i = 0; i < length; i++)
				res.add((long)(3 * i + 1));
		return res;
	}
	
	private static long shellSortArgFunction1(int arg) {
		return (long)(9 * Math.pow(4, arg) - 9 * Math.pow(2, arg) + 1);
	}
	
	private static long shellSortArgFunction2(int arg) {
		return (long)(Math.pow(4, arg) - 3 * Math.pow(2, arg) + 1);
	}
	
	public static void main(String[] args) {
		shellSortIncrementSeqFunctionGood(10).forEach(x -> System.out.print(x + " -> "));
	}

}
