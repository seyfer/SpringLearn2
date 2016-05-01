package seed.seyfer.aop;

import org.springframework.stereotype.Component;

@Component("camera")
public class Camera implements PhotoShooter, CameraInterface {

	public Camera() {
		System.out.println("camera construct");
	}

	// adviced by
	/*
	 * (non-Javadoc)
	 * 
	 * @see seed.seyfer.aop.CameraInterface#snap()
	 */
	public void snap() {
		System.out.println("Snap!");
	}

	// adviced by
	/*
	 * (non-Javadoc)
	 * 
	 * @see seed.seyfer.aop.CameraInterface#snap(int)
	 */
	public void snap(int exposure) {
		System.out.println("Snap! " + exposure);
	}

	// adviced by
	/*
	 * (non-Javadoc)
	 * 
	 * @see seed.seyfer.aop.CameraInterface#snap(int)
	 */
	public void snap(double some) {
		System.out.println("Snap! " + some);
	}

	// adviced by
	/*
	 * (non-Javadoc)
	 * 
	 * @see seed.seyfer.aop.CameraInterface#snap(int)
	 */
	public void snap(int exposure, double some) {
		System.out.println("Snap! " + exposure + " " + some);
	}

	// adviced by
	/*
	 * (non-Javadoc)
	 * 
	 * @see seed.seyfer.aop.CameraInterface#snap(java.lang.String)
	 */
	public String snap(String name) {
		System.out.println("Snap! " + name);

		return name;
	}

	// adviced by
	/*
	 * (non-Javadoc)
	 * 
	 * @see seed.seyfer.aop.CameraInterface#snapNighttime()
	 */
	public void snapNighttime() {
		System.out.println("Snap! night mode");
	}

	public void snapCar(Car car) {
		// TODO Auto-generated method stub
		System.out.println("Car snap! " + car);
	}
}