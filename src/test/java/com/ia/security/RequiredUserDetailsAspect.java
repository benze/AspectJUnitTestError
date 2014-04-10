package com.ia.security;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import com.ia.domain.UserIntegrationTest;

/**
 * Aspect to inject/set permissions for a user based on the {@link RequiredUserDetails} annotation.
 * Aspect must be configured via xml to allow for Spring IOC.  See {@link  http://docs.spring.io/spring/docs/3.2.x/spring-framework-reference/html/aop.html#aop-aj-configure}
 * 
 * @author Eric Benzacar
 *
 */
@Aspect
public class RequiredUserDetailsAspect {

	/**
	 * Defines any public <code>@Test</code> method
	 */
	@Pointcut("execution(public * *(..)) && @annotation(org.junit.Test)")
	public void testMethod() {};
	
	/**
	 * Anything with the {@link RequiredUserDetails} annotation
	 * @param requiredUserDetails
	 */
	@Pointcut("@annotation(requiredUserDetails)")
	public void requiresPermission( RequiredUserDetails requiredUserDetails) {};
	
	/**
	 * Anything with the {@link RequiredUserDetails} annotation on the method
	 */
	@Pointcut("@annotation(RequiredUserDetails)")
	public void annotatedMethod(){};
	
	
	/**
	 * Anything with the {@link RequiredUserDetails} annotation on the class
	 */
	@Pointcut("@within(RequiredUserDetails)")
	public void annotatedClass(){};
	
	
	

	/**
	 * Authenticate the user.  If a authentication context already exists, use the user credentials
	 * already injected.  If not, create a new test user for that purpose.
	 * 
	 * @param requiredUserDetails
	 */
	@Before("testMethod() && (annotatedClass() || annotatedMethod())")
	public void authenticateUser(JoinPoint jp){
		System.out.println("Aspect Working here before method: " + ((MethodSignature)jp.getSignature()).getName());
		UserIntegrationTest.adviceRun( ((MethodSignature)jp.getSignature()).getName() );
	}
	
	
}
