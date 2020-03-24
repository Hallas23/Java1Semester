package soegningelevopgaver;

public class Soegning {

	public boolean findUlige(int[] tabel) {
		boolean found = false;
		int i = 0;
		while (!found && i < tabel.length) {
			int k = tabel[i];
			if (k % 2 != 0) {
				found = true;
			} else {
				i++;
			}
		}
		return found;
	}

	// her skriver du metoder til opgaverne 2,3,5 og 6

	public int findHeltal10til15(int[] tabel) {
		int i = 0;
		while (i < tabel.length) {
			int k = tabel[i];
			if (k >= 10 && k <= 15) {
				return k;
			} else {
				i++;
			}
		}
		return -1;
	}

	public boolean checkfor2ens(int[] tabel) {
		int i = 0;
		int j = 1;
		while (j < tabel.length) {
			int k = tabel[i];
			int l = tabel[j];
			if (k == l) {
				return true;
			} else {
				i++;
				j++;
			}
		}
		return false;
	}
}
