package seed.seyfer.aop;

import org.springframework.stereotype.Component;

@Component
public class Lens {
	public void zoom(int factor) {
		System.out.println("Zooming " + factor);
	}
}
