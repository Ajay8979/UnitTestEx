package com.ojas.entityTest;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import com.ojas.entity.Caculator;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // it will create one instance for all the method of a class otherwise
												// multiple instance how many methods we have that many
public class CaclulatorTest {
	Caculator calculator = null;

	@BeforeAll // it will execute before all the methods how using static key word as we know
				// static is class level
	public static void all() {
		System.out.println("befoe ecah method is executed..");
	}

	@BeforeEach // the logic that we want to execute before test method where we have some
				// initialization logic thats it
	public void init() {
		calculator = new Caculator();
	}

	// nest use
	@Nested // use for checking multiple test method inside class so all the combiltion and
			// permutations we are using here
	class addNestedTest {

		@Test
		@DisplayName("add for negative")
		public void testAddNegative() {
			assertEquals(4, calculator.add(2, 2));
		}

		@Test
		@DisplayName("add for positive")
		public void testAddPositive() {
			assertEquals(-4, calculator.add(-2, -2));
		}

	}

	@Test
	@DisplayName("testing add method") // if you want some readable name for method you can change using this
	@EnabledOnOs(OS.WINDOWS) // this testcase only will work with windows not other os
	public void testAdd() {
		Caculator calculator = new Caculator();
		int expected = 2;
		int actual = calculator.add(1, 1);
		assertEquals(expected, actual);

	}

	// checking if exception how to get

	@Test
	@Tag("Math")//we can write this tag for math cal,exception , so i want to execute only math taged test cases then we should go for @tag
	@DisplayName("testing div method")
	public void testDiv() {
		calculator = new Caculator();
		// int expected=1;
		// int actual=calculator.div(1, 0);
		// assertEquals(expected, actual);
		Assertions.assertThrows(ArithmeticException.class, () -> calculator.div(1, 0), "divide by 0 show throw");
	}

	@Test
	public void helloTest() {
		System.out.println("hiiii....");
	}

	@Test
	@Disabled // if you want to skip some test cases
	@DisplayName("this test method should not run")
	@RepeatedTest(value = 2)//SAY IF i want execute this test cases two time reapeatedly
	public void helloTest1() {
		System.out.println("failed to execute");
	}

	@Test
//	@DisplayName("multiply method")
	public void mulTest() {

		assertAll // assertAll is used to execute multiple assertEquals for checking multiple
					// conditions at a time
		(

				() -> assertEquals(4, calculator.mul(2, 2)), () -> assertEquals(0, calculator.mul(2, 0)),
				() -> assertEquals(-2, calculator.mul(2, -1))

		);

	}

	@AfterEach
	public void afterAll() {
		System.out.println("clean up code....");
	}

	@AfterAll
	public static void all1() {
		System.out.println("last...");
	}

}
