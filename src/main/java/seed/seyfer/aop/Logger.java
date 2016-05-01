package seed.seyfer.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//aspect
@Aspect
@Component
public class Logger {

	// no arguments
	// @Pointcut("execution(void seed.seyfer.aop.Camera.snap())")
	// any number of arguments
	// @Pointcut("execution(void seed.seyfer.aop.Camera.snap(..))")
	// @Pointcut("within(seed.seyfer.aop.Camera)")
	// for deprecated
	// @Pointcut("@Deprecated within(seed.seyfer.aop.Camera)")
	// for spring component
	// @Pointcut("@org.springframework.sterotype.Component within(seed.seyfer.aop.Camera)")
	// for annotation global
	// @Pointcut("@target(@org.springframework.sterotype.Component")
	// @Pointcut("@annotation(@java.lang.Deprecated")
	// for arguments passed into method, not method
	// @Pointcut("@args(@org.springframework.sterotype.Component")
	// can't use wildcard
	// @Pointcut("target(seed.seyfer.aop.Camera)")
	// for bean
	// @Pointcut("bean(camera)")
	// @Pointcut("bean(*camera)")
	// for particular instance type
	// @Pointcut("this(seed.seyfer.aop.CameraInterface)")
	@Pointcut("execution(* seed.seyfer.aop.Camera.*(..))")
	public void cameraSnap() {
	}

	// @Pointcut("execution(* *.*(..))")
	@Pointcut("execution(* seed.seyfer.aop.*.*(..))")
	public void cameraRelatedAction() {
	}

	@Pointcut("execution(String seed.seyfer.aop.Camera.snap(String))")
	public void cameraSnapName() {
	}

	// advice
	// @Before("execution(void seed.seyfer.aop.Camera.snap())")
	@Before("cameraSnap()")
	public void aboutToTakePhoto() {
		System.out.println(new Object() {
		}.getClass().getEnclosingMethod().getName());
	}

	// no exceptions
	// @AfterReturning("cameraSnap()")
	// expetion
	// @AfterThrowing("cameraSnap()")
	@After("cameraSnap()")
	public void afterToTakePhoto() {
		System.out.println(new Object() {
		}.getClass().getEnclosingMethod().getName());
	}

	@Before("cameraSnapName()")
	public void aboutToTakePhotoWithName() {
		System.out.println(new Object() {
		}.getClass().getEnclosingMethod().getName());
	}

	@Before("cameraRelatedAction()")
	public void aboutCameraRelatedAction() {
		System.out.println(new Object() {
		}.getClass().getEnclosingMethod().getName());
	}

	@Around("cameraSnap()")
	public void aroundAdvice(ProceedingJoinPoint p) {
		System.out.println(new Object() {
		}.getClass().getEnclosingMethod().getName());

		try {
			p.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("around AFTER !!!");
	}
}
