package com.ia.domain;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.ia.security.RequiredUserDetails;


@RequiredUserDetails()
public class UserIntegrationTest {
	
	static private List<String> advisedMethods = new ArrayList<>();

	/**
	 * Add method name to the advisedMethods list
	 * @param method
	 */
	static public void adviceRun(String method ){
		advisedMethods.add(method);
	}
	
	/**
	 * Indicates if the method has been advised
	 * @param method
	 * @return
	 */
	static public boolean isAdvised(String method ){
		return advisedMethods.contains(method);
	}
	
	
	@Test
	public void test(){
		// empty test to see if advice fires first
		System.out.println( "Method: test()" );
		Assert.assertTrue( isAdvised("test"));
	}
}