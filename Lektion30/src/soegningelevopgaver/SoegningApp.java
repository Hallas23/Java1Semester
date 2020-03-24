package soegningelevopgaver;

public class SoegningApp {

	 
	
	public static void main(String[] args) {
		Soegning s = new Soegning();
		
		// Kode til afprøvning af opgave 1
		int[] talArray = {2,3,8,2};
		System.out.println("Er der et ulige tal i talArray ? " + s.findUlige(talArray));	
		
		int [] opgave2Array = {7, 56, 34, 3, 7, 14, 13, 4};
		System.out.println("Er der et helttal i heltalArray ? " + s.findHeltal10til15(opgave2Array));
		
		int [] opgave3Array = {7, 9, 13, 14, 19, 9};
		System.out.println("Er der to ens i opgave3Array ? " + s.checkfor2ens(opgave3Array));

		// Her tilføjes kode til at afprøve opgaverne 2,3,5 og 6
		
		
	}

}
