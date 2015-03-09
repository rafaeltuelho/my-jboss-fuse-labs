package br.net.rafaeltuelho.osgi.time;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TimeUtilTest {

	@Test
	public void testCreateClock() {
		System.out.println(TimeUtil.createClock(TimeUtil.TimeZone.SAO_PAULO).getLocalTime());
		System.out.println(TimeUtil.createClock(TimeUtil.TimeZone.BAHIA).getLocalTime());
		System.out.println(TimeUtil.createClock(TimeUtil.TimeZone.ACRE).getLocalTime());
		
		assertTrue(true);
	}

}
