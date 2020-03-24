package modelchild;

public class Institution {

	private String navn;
	private String adresse;
	private int[] children;
	private boolean boy;
	private int numberofchildren;
	private static final int MAX_NUMBER_OF_CHILDREN = 100;

	public Institution(String navn, String adresse) {
		this.navn = navn;
		this.adresse = adresse;
		children = new int[MAX_NUMBER_OF_CHILDREN];
	}
	  public String getNavn() {
	        return navn;
	    }
	  
	  
	  
	  public String getAdresse() {
	        return adresse;
	    }
	  
	  public void setAdresse(String adresse) {
	        this.adresse = adresse;
	    }
	  public void setNavn(String navn) {
	        this.navn = navn;
	    }
	  public void addChild(int child) {
			if (numberofchildren < MAX_NUMBER_OF_CHILDREN) {
				children[numberofchildren] = child;
				numberofchildren++;
			}
	  }
	  
	  public int[] getChildren() {
		  return children;
	  }
}
