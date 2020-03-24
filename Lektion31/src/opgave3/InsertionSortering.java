package opgave3;


public class InsertionSortering {

	public static void insertioneSort(String[] list) {
		for (int i = 1; i < list.length; i++) {
			String next = list[i];
			int j = i;
			boolean found = false;
			while (!found && j > 0) {
				if (next.compareTo(list[j - 1]) > 0) {
					found = true;
				} else {
					list[j] = list[j - 1];
					j--;
				}
			}
			list[j] = next;
		}
	}
	
	public static void insertioneSortC(opgave2.Customer[] list) {
		for (int i = 1; i < list.length; i++) {
			opgave2.Customer next = list[i];
			int j = i;
			boolean found = false;
			while (!found && j > 0) {
				if (next.compareTo(list[j - 1]) > 0) {
					found = true;
				} else {
					list[j] = list[j - 1];
					j--;
				}
			
			list[j] = next;
		}
	}

}
