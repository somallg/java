package java.scjp6.exams.practice.dump;

import java.util.Arrays;
import java.util.Comparator;

public class GeoCache {

	public static void main(String[] args) {
		String[] s = { "d", "b", "e", "c", "a" };
		System.out.println(Arrays.binarySearch(s, "c"));
	}
	
	static class Othello implements Comparator<String> {

		@Override
		public int compare(String a, String b) {
			return b.compareTo(a);
		}
		
	}
	

}
