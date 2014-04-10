AspectJUnitTestError
====================

Sample Application to demonstrate weaving problems when using AspectJ in Unit Tests advising aspects.

The pointcut in RequiredUserDetails.java is supposed to advise any methods in a class that is annotated with custom annotation @RequiredUserDetails
and the @Test annotation.  This works fine for the UserINtegrationTest.java class.  However, in the UserINtegrationTest_Roo_integration.aj
aspect, a @Test method is crosscut into the class and yet the advice is not called for that method.


