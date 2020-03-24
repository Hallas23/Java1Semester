package cartester;

public class Car {

	private double fuelefficiency;
	private double fuel;
	private double drive;
	
	public Car (double Addfuel, double Addfuelefficiency) {
		fuelefficiency = Addfuelefficiency;
		fuel = Addfuel;	
		drive = fuel / fuelefficiency;
	}
	
	public double getfuelefficiency() {
		return fuelefficiency;
	}
	
	public double getfuel() {
		return fuel;
	}
	
	
	public void Addfuelefficiency(double Addfuelefficiency) {
		this.fuelefficiency = Addfuelefficiency;
	}
	
	public void Addfuel(double Addfuel) {
		this.fuel = Addfuel;
		
	}
	
	public void Drive(double Drive) {
		this.drive = drive;
	}

		public void printCar() {
			System.out.println(fuelefficiency);
			System.out.println(fuel);
			System.out.println(drive);
		}
	}
