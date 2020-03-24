package opgave2;

public class Fletning2 {

	public static int[] flet(int[] l1, int[] l2) {
		int[] result = new int[l1.length + l2.length];
		int i1 = 0;
		int i2 = 0;
		int j = 0;

		while (i1 < l1.length && i2 < l2.length) {
			if (l1[i1] < l2[i2]) {
				result[j] = l1[i1];
				i1++;
				j++;
			}
			else {
				result[j] = l2[i2];
				i2++;
				j++;
			}
		}
		
		while (i1 < l1.length) {
			result[j] = l1[i1];
			i1++;
			j++;
		}
		while (i2 < l2.length) {
			result[j] = l2[i2];
			i2++;
			j++;
		}

		return result;
	}
}
