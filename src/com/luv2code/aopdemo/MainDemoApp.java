package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
	
		 // read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// get membership bean from spring container
	    
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		// call the bussiness method
		Account myAccount = new Account();
		myAccount.setName("madu");
		myAccount.setLevel("platinum");
		theAccountDAO.addAccount(myAccount,true);
		theAccountDAO.doWork();
		
		// call the getter and setter methods
		theAccountDAO.setName("vinod");
		theAccountDAO.setServiceCode("silver");
		
		String name= theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();
		
		// call the membership bussiness method
		theMembershipDAO.addSillyMember();
	    theMembershipDAO.goToSleep();
		
	
		// close the context
         context.close();
	}

}
