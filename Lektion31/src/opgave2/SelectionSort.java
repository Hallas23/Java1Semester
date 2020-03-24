package opgave2;

import java.util.ArrayList;

import Opgave1.Customer;

public class SelectionSort {
    private static void swap(Customer[] list, int i, int j) {
        Customer temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
    
    public static void selectionSort(Customer[] list) {
        for (int i = 0; i < list.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j].compareTo(list[minPos]) < 0) {
                    minPos = j;
                }
                
            }
            swap(list, i, minPos);
        }
    }
    
    private static void swapList(ArrayList<Customer> list, int i, int j) {
        Customer temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j,temp);
    }
    
    public static void selectionSortList(ArrayList<Customer> list) {
        for (int i = 0; i < list.size(); i++) {
            int minPos = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(list.get(minPos)) < 0) {
                    minPos = j;
                }
                
            }
            swapList(list, i, minPos);
        }
    }
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
    public static void selectionSortList(ArrayList<Customer> list) {
        for (int i = 0; i < list.size(); i++) {
            int minPos = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(list.get(minPos)) < 0) {
                    minPos = j;
                }
                
            }
            swapList(list, i, minPos);
        }
    }
    
}
