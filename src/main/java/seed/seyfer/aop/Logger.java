package seed.seyfer.aop;

import org.apache.bcel.classfile.Deprecated;
import org.aspectj.lang.JoinPoint;
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
	// @Pointcut("@org.springframework.sterotype.Component
	// within(seed.seyfer.aop.Camera)")
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

	// @Pointcut("args(int)")
	// @Pointcut("args(seed.seyfer.aop.Car)")
	// @Pointcut("args(Object)")
	@Pointcut("args(int, *)")
	public void cameraSnapArgs() {
	}
	
	@Pointcut("args(exposure, some)")
	public void cameraSnapArgsNamed(int exposure, double some) {
	}

	@Before("cameraSnapArgs()")
	public void aboutArgs(JoinPoint jp) {
		System.out.println(new Object() {
		}.getClass().getEnclosingMethod().getName());

		for (Object obj : jp.getArgs()) {
			System.out.println(obj);
		}
	}
	
	//could be combined
	//@Before("cameraSnapArgs() && cameraSnapArgsNamed(exposure, some)")
	@Before("cameraSnapArgsNamed(exposure, some)")
	public void aboutArgsNamed(JoinPoint jp, int exposure, double some) {
		System.out.println(new Object() {
		}.getClass().getEnclosingMethod().getName());

		System.out.printf("%d , %.2f \n", exposure, some);
	}
	
	@After("cameraSnapArgsNamed(exposure, some) && !@annotation(Deprecated)")
	public void aboutArgsNamedNotDeprecated(JoinPoint jp, int exposure, double some) {
		System.out.println(new Object() {
		}.getClass().getEnclosingMethod().getName());

		System.out.printf("%d , %.2f \n", exposure, some);
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
