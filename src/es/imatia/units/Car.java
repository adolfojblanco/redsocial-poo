package es.imatia.units;

public class Car {
	private String brand;
	private String model;
	private boolean reverse = false;
	private String gear = "N";
	private static final int MAX_SPEED = 120;
	private int fuel;
	private int speedometer = 0;
	private int tachometer = 0;
	private int steeringWheelAngle = 0;
	
	public Car(String brand, String model, int fuel) {
		this.brand = brand;
		this.model = model;
		this.fuel = fuel;
	}
	
	public static void main(String[] args) {
		Car myCar = new Car("Ford", "Aveo", 10);
		String option = "";
		System.out.println();
		do {
			System.out.println();
			myCar.showDetails();
			option = Input.string(
					"Seleccione: \n '+' - Acelerar\nXirar a dereita\n 'i' - Xirar a esquerda\n 'end' - Acaba o programa\nQuÃ© opciÃ3n desexa facer?: ");
			System.out.println();
			switch (option) {
			case "+":
				myCar.acelerate();
				break;
			case "-":
				myCar.brake();
				break;
			case "r":
				myCar.setReverse(true);
				break;
			case "n":
				myCar.setReverse(false);
				break;
			case "d":
				myCar.turnSteeringWheel(5);
				break;
			case "i":
				myCar.turnSteeringWheel(-5);
				break;
			case "end":
				
				break;
			default:
				System.out.println("Non existe esa opción");
				break;
			}

		} while (!option.equalsIgnoreCase("end"));

	}


	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public boolean isReverse() {
		return reverse;
	}

	public void setReverse(boolean reverse) {
		if (this.speedometer != 0) {
			System.out.println("El Coche no esta detenido");
		}else {
			if(reverse == this.reverse) {
				System.out.println("La marcha atras ya esta puesta");
			}else if (reverse == true){
				this.gear = "R";
				System.out.println("La marcha atras ya esta engranada");
			}else {
				System.out.println("La marcha directa ya esta engranada");
			}
		}

	}

	public String getGear() {
		return gear;
	}

	public void setGear(String gear) {
		this.gear = gear;
	}

	public int getFuel() {
		return fuel;
	}

	public void setFuel(int fuel) {
		this.fuel = fuel;
	}

	public int getSpeedometer() {
		return speedometer;
	}

	public void setSpeedometer(int speedometer) {
		this.speedometer = speedometer;
	}

	public int getTachometer() {
		return tachometer;
	}

	public void setTachometer(int tachometer) {
		this.tachometer = tachometer;
	}

	private void calculateTachometer() {
		double gearVel = (float) this.speedometer / 25;
		double gearVelInt = Math.floor(gearVel);
		this.gear = Integer.toString((int) (gearVelInt) + 1);
		double fract = gearVel -gearVelInt;
		this.tachometer = (int) ((fract * 100 * 1500) / 100) + 1000;
	}
	
	/* Up velocity in 10 km/h */
	public void start() {
		if(this.tachometer == 0) {
			this.tachometer = 1000;
			System.out.println("Coche encendido");
		}else {
			System.out.println("El Coche ya esta encendido");
		}
		
	}
	
	public void acelerate() {
		if(this.speedometer < this.MAX_SPEED) {
			this.speedometer = this.speedometer + 20;
			this.calculateTachometer();
			System.out.println("Coche acelerado: " + this.getSpeedometer());
		}else {
			System.out.println("Ya tienes la maxima velocidad permitida");
		}
		
	}
	
	/* stop the car 0 km/h */
	public void stop() {
		this.speedometer = 0;
		this.tachometer = 0;
		System.out.println("Coche apagado");
	}
	
	/* down velocity in 10 km/h */
	public void brake() {
		if(this.speedometer == 0) {
			System.out.println("El coche esta detenido");
		}else {
			this.speedometer = this.speedometer-5;
			System.out.println("Se a desacelerado el coche: " + this.getSpeedometer());
		}
	}
	
	public void turnSteeringWheel(int angle) {
		
		if(this.steeringWheelAngle <= 45 || this.steeringWheelAngle >= -45) {
			System.out.println("El coche se giro");
		}else {
			System.out.println("El Coche no se puede girar");
		}
		
	}

	
	public String showDetails() {
		return "Car [brand=" + brand + ", model=" + model + ", fuel=" + fuel + ", speedometer=" + speedometer
				+ ", tachometer=" + tachometer + "]";
	}
	
}
