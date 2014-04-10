package com.ia.security;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Injects the appropriate permissions required to run the test.  
 * 
 * Only applies to classes that use the SpringJUnit4ClassRunner.class runner
 * 
 * @author Eric Benzacar
 *
 */

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequiredUserDetails {
	
	/**
	 * Set of permissions required for this test
	 */
	boolean enabled() default true;
	boolean accountNonExpired() default true;
	boolean credentialsNonExpired() default true;
	boolean accountNonLocked() default true;

}
