package seed.seyfer.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//aspect
@Aspect
@Component
public class Logger {

	@Pointcut("execution(void seed.seyfer.aop.Camera.snap())")
	public void cameraSnap() {
	}

	// advice
	// @Before("execution(void seed.seyfer.aop.Camera.snap())")
	@Before("cameraSnap()")
	public void aboutToTakePhoto() {
		System.out.println(new Object() {}.getClass().getEnclosingMethod().getName());
	}
}
