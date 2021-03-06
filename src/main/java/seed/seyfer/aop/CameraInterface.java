package seed.seyfer.aop;

public interface CameraInterface {

	// adviced by
	void snap();

	// adviced by
	void snap(int exposure);

	// adviced by
	String snap(String name);

	// adviced by
	void snapNighttime();

	void snap(double d);

	void snap(int exposure, double d);
	
	void snapCar(Car car);
}