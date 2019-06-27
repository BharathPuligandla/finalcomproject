package com.bharath.eshopbackend;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class Testprogram
{
@BeforeClass
public static void test1()
{
	System.out.println("before class");
}
@Test
public void test3()
{Cal cal=new Cal();
	System.out.println("test");
	assertEquals("jnkjn ",true,cal.even(86));
}
@AfterClass
public static void testlast()
{
	System.out.println("after class");
}
}
