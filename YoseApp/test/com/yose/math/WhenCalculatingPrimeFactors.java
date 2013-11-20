package com.yose.math;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.rules.ExpectedException;

public class WhenCalculatingPrimeFactors {

	@Test
	public void shouldBreak16InTo2s() {
		int number = 16;
		
		PrimeFactors prime = new PrimeFactors();
		List<Integer> decomposition = prime.calculateFor(number);
		
		assertEquals(4, decomposition.size());
	}

	@Test
	public void shouldBreak512InTo2s() {
		int number = 512;
		
		PrimeFactors prime = new PrimeFactors();
		List<Integer> decomposition = prime.calculateFor(number);
		
		assertEquals(9, decomposition.size());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldNotAcceptNumbersOver1000000() {
		int number = 1000001;
		
		PrimeFactors prime = new PrimeFactors();
		prime.calculateFor(number);
	}
}
