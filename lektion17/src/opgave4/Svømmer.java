package opgave4;

import java.time.LocalDate;
import java.util.ArrayList;

public class Svømmer {

	private String navn;
	private String klub;
	private LocalDate fødselsdag;
	private ArrayList<Double> tider = new ArrayList<Double>();
	private double tid;
	private double tid2;
	private double tid3;

	public Svømmer(String navn, LocalDate fødselsdag, String klub, double tid, double tid2, double tid3) {
		this.navn = navn;
		this.fødselsdag = fødselsdag;
		this.klub = klub;
		tider.add(tid);
		tider.add(tid2);
		tider.add(tid3);

	}

	public String getNavn() {
		return navn;
	}

	public String getKlub() {
		return klub;
	}

	public void setKlub(String klub) {
		this.klub = klub;
	}

	public LocalDate getFødselsdag() {
		return fødselsdag;
	}

	public double bedsteTid() {
		double tid = 0;
		int svømmer = 0;
		double max = 1000;
		for (int i = 0; i < tider.size(); i++) {
			tid = tider.get(i);
			if (tid <= max) {
				max = tid;
				svømmer = i + 1;

			}
		}
		System.out.println("Svømmerens bedste tid var i den " + svømmer + " runde: " + max);
		return max;
	}

	public double gennemsnitAfTid() {
		double tid = 0;
		double gennemsnit = 0;
		for (int i = 0; i < tider.size(); i++) {
			tid = tid + tider.get(i);
		}
		gennemsnit = tid / tider.size();
		System.out.println("Gennemsnitstiden er " + gennemsnit);
		return gennemsnit;
	}

	public double snitUdenDårligste() {
		double tid = 0;
		double temptid = 0;
		double max = 0;
		double gennemsnit = 0;
		int svømmer = 0;
		for (int i = 0; i < tider.size(); i++) {
			tid = tider.get(i);
			if (tid > max) {
				max = tid;
				svømmer = i;
			}	
		}
		tider.remove(svømmer);
		for (int i = 0; i < tider.size(); i++) {
			temptid = temptid + tider.get(i);
		}
		gennemsnit = temptid / tider.size();
		System.out.println("Gennemsnitstiden uden den værste tid er " + gennemsnit);
		tider.add(svømmer, tid);
		return gennemsnit;
	}
}