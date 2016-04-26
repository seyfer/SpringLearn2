package seed.seyfer.aop;

import org.springframework.stereotype.Component;

@Component
public class Camera {
	//adviced by
	public void snap() {
		System.out.println("Snap!");
	}
}
