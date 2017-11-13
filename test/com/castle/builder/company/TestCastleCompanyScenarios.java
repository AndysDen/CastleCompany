package test.com.castle.builder.company;

import java.io.ByteArrayInputStream;

import com.castle.builder.company.CastleCompany;


import junit.framework.TestCase;

/**
 * Following test cases are incorporated in this  :
 * 1. There nonValue Present in Start and we are building a Castle. 
 * 2. For end element of array we are only comparing it with element previous and Its Should be NonZero
 * 3. If we have consecutive same elements we are buliding only one castle. 
 * 
 * 
 * @author anandsoni
 *
 */

public class TestCastleCompanyScenarios extends TestCase{

	
	protected CastleCompany castleCompany;
	
	public void setUp(){
		castleCompany = new CastleCompany();
	}
	
	public void testCastleBuildOnNonZeroValueAsFirstElementOfArray(){
		ByteArrayInputStream in = new ByteArrayInputStream((3+"\r\n"+
				1+"\r\n"+
				2+"\r\n"+
				2+"\r\n").getBytes());
		System.setIn(in);
		castleCompany.receiveInput();
		//number of elements in array
		assertEquals(3,castleCompany.getCastleInput().length);
		castleCompany.countCastle();
		//number of castle build
		assertEquals(2,castleCompany.getCastleCounter());
		
	}
	
	public void testNoCastleBuildWithZeroValueAsFirstElementOfArray(){
		ByteArrayInputStream in = new ByteArrayInputStream((3+"\r\n"+
				0+"\r\n"+
				2+"\r\n"+
				2+"\r\n").getBytes());
		System.setIn(in);
		castleCompany.receiveInput();
		//number of elements in array
		assertEquals(3,castleCompany.getCastleInput().length);
		castleCompany.countCastle();
		//number of castle build
		assertEquals(1,castleCompany.getCastleCounter());
		
	}
	
	public void testOnlyOneCastleIsBuildForConsecutiveElements(){
		ByteArrayInputStream in = new ByteArrayInputStream((3+"\r\n"+
				1+"\r\n"+
				1+"\r\n"+
				1+"\r\n").getBytes());
		System.setIn(in);
		castleCompany.receiveInput();
		//number of elements in array
		assertEquals(3,castleCompany.getCastleInput().length);
		castleCompany.countCastle();
		//number of castle build
		assertEquals(1,castleCompany.getCastleCounter());
		
	}
	
	public void testAlwaysBuildACastleWhenLastElementIsNotSameAsPreviousOneAndIsNonZero(){
		ByteArrayInputStream in = new ByteArrayInputStream((3+"\r\n"+
				1+"\r\n"+
				1+"\r\n"+
				2+"\r\n").getBytes());
		System.setIn(in);
		castleCompany.receiveInput();
		//number of elements in array
		assertEquals(3,castleCompany.getCastleInput().length);
		castleCompany.countCastle();
		//number of castle build
		assertEquals(2,castleCompany.getCastleCounter());
		
	}
	
	public void testDontBuildACastleWhenLastElementIsNotSameAsPreviousOneAndIsZero(){
		ByteArrayInputStream in = new ByteArrayInputStream((3+"\r\n"+
				1+"\r\n"+
				1+"\r\n"+
				0+"\r\n").getBytes());
		System.setIn(in);
		castleCompany.receiveInput();
		//number of elements in array
		assertEquals(3,castleCompany.getCastleInput().length);
		castleCompany.countCastle();
		//number of castle build
		assertEquals(1,castleCompany.getCastleCounter());
		
	}
	public void testBuildACastleForAllPeaksAndValley(){
		ByteArrayInputStream in = new ByteArrayInputStream((5+"\r\n"+
				1+"\r\n"+
				2+"\r\n"+
				1+"\r\n"+
				2+"\r\n"+
				3+"\r\n").getBytes());
		System.setIn(in);
		castleCompany.receiveInput();
		//number of elements in array
		assertEquals(5,castleCompany.getCastleInput().length);
		castleCompany.countCastle();
		//number of castle build
		assertEquals(4,castleCompany.getCastleCounter());
		
	}
	
	
}
