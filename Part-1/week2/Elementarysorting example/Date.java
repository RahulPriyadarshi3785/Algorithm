package week2;

import java.time.LocalDate;
import java.util.Comparator;

public class Date implements Comparable<Date>, Comparator<Date> {

	private int date, month, year;

	public Date(int date, int month, int year) {
		this.date = date;
		this.month = month;
		this.year = year;
	}

	public Date() {
		LocalDate date = LocalDate.now();
		this.date = date.getDayOfMonth();
		this.month = date.getMonthValue();
		this.year = date.getYear();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.date + "/" + this.month + "/" + this.year;
	}
	
	@Override
	public int compareTo(Date that) {
		// Compare Date
		if (this.year < that.year) return -1;
		else if (this.year > that.year) return 1;
		else if (this.month > that.month) return 1;
		else if (this.month < that.month) return -1;
		else if (this.date > that.date) return 1;
		else if (this.date < that.date) return -1;
		return 0;
	}

	@Override
	public int compare(Date thisDate, Date thatDate) {
		if (thisDate.year < thatDate.year) return -1;
		else if (thisDate.year > thatDate.year) return 1;
		else if (thisDate.month > thatDate.month) return 1;
		else if (thisDate.month < thatDate.month) return -1;
		else if (thisDate.date > thatDate.date) return 1;
		else if (thisDate.date < thatDate.date) return -1;
		return 0;
	}
	
}
