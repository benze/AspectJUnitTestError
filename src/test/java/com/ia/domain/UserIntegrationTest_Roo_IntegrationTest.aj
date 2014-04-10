package com.ia.domain;

import org.junit.Assert;
import org.junit.Test;

privileged aspect UserIntegrationTest_Roo_IntegrationTest {
    
	public String UserIntegrationTest.getMethodName(){
		return Thread.currentThread().getStackTrace()[2].getClassName() + "." + Thread.currentThread().getStackTrace()[2].getMethodName();
	}
	
    @Test
    public void UserIntegrationTest.testCountAllUsers() {
//        String method = Thread.currentThread().getStackTrace()[2].getClassName() + "." + Thread.currentThread().getStackTrace()[2].getMethodName();
    	System.out.println("Method: testCountAllUsers()");
		Assert.assertTrue( isAdvised("testCountAllUser"));

    }
    
}
