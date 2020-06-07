package week2;

import java.util.ArrayList;
import java.util.List;

public class SortDate<T> {
	
	@SuppressWarnings("unchecked")
	private boolean less(Comparable<T> thisDate, Comparable<T> thatDate) {
		if(!Comparable.class.isAssignableFrom(thatDate.getClass()))
			throw new IllegalArgumentException();
		return  thisDate.compareTo((T) thatDate) < 0;
	}

	private void exch(List<Comparable<T>> dates, int x, int y) {
		Comparable<T> date = dates.get(x);
		dates.set(x, dates.get(y));
		dates.set(y, date);
	}

	private void exchArray(Comparable<T>[] dates, int x, int y) {
		Comparable<T> date = dates[x];
		dates[x] = dates[y];
		dates[y] = date;
	}
	
	public boolean isSorted(List<Comparable<T>> dates) {
		boolean res = true;
		int len = dates.size();
		for(int i = 1; i < len ; i++) 
			res &= !less(dates.get(i), dates.get(i - 1));
		return res;
	}
	
	public boolean isSortedArray(Comparable<T>[] dates) {
		boolean res = true;
		for(int i = 1; i < dates.length ; i++) 
			res &= !less(dates[i], dates[i - 1]);
		return res;
	}
	
	public List<Comparable<T>> sortSelectionList(List<Comparable<T>> dates) {
		int len = dates.size() - 1;
		for(int i = 0; i < len; i++) {
			int min = i;
			for(int j = len; j > i; j--) {
				if(less(dates.get(j), dates.get(min)))
					min = j;
				exch(dates, i, min);
			}
		}
		return dates;
	}
	
	public Comparable<T>[] sortSelectionArray(Comparable<T>[] dates) {
		int len = dates.length - 1;
		for(int i = 0; i < len; i++) {
			int min = i;
			for(int j = len; j > i; j--) {
				if(less(dates[j], dates[min]))
					min = j;
				exchArray(dates, i, min);
			}
		}
		return dates;
	}

	private void sortInsertionArray(Comparable<T>[] datesArray) {
		int len = datesArray.length;
		for(int i = 1; i < len; i++)
			for(int j = i - 1; j >= 0; j--)
				if(less(datesArray[i], datesArray[j]))
					exchArray(datesArray, i, j);
				else
					break;
	}

	private void sortInsertionList(List<Comparable<T>> dates) {
		int len = dates.size();
		for(int i = 1; i < len; i++)
			for(int j = i - 1; j >= 0; j--)
				if(less(dates.get(i), dates.get(j)))
					exch(dates, i, j);
				else
					break;
	}


	public static void main(String[] args) {
		SortDate<Date> sd = new SortDate<>();
		List<Date> datesColl = new ArrayList<>(4);
		datesColl.add(new Date(1, 10, 2013));
		datesColl.add(new Date());
		datesColl.add(new Date(1, 11, 2013));
		datesColl.add(new Date(1, 11, 2013));
//		Collections.sort(datesColl);
		List<Comparable<Date>> dates = new ArrayList<>(4);
		dates.add(new Date(1, 10, 2013));
		dates.add(new Date());
		dates.add(new Date(1, 11, 2013));
		dates.add(new Date(1, 11, 2013));
		System.out.println(dates);
		System.out.println(sd.isSorted(dates));
//		sd.sortSelectionList(dates);
		sd.sortInsertionList(dates);
		System.out.println(dates);
		System.out.println(sd.isSorted(dates));
		System.out.println("++++++++++++++++++++++++");
		Date[] datesArray = new Date[4];
		datesArray[0] = (new Date(1, 10, 2013));
		datesArray[1] = (new Date());
		datesArray[2] = (new Date(1, 11, 2013));
		datesArray[3] = (new Date(1, 11, 2013));
		System.out.println(datesArray);
		System.out.println("[" + datesArray[0] + ", " + datesArray[1] + ", " + datesArray[2] + ", " + datesArray[3] + "]");
		System.out.println(sd.isSortedArray(datesArray));
//		Arrays.sort(datesArray);
//		sd.sortSelectionArray(datesArray);
		sd.sortInsertionArray(datesArray);
		System.out.println("[" + datesArray[0] + ", " + datesArray[1] + ", " + datesArray[2] + ", " + datesArray[3] + "]");
		System.out.println(sd.isSortedArray(datesArray));
	}
}
