package de.persosim.simulator.perso;

import org.junit.Before;

public class Profile03Test extends PersonalizationTest {

	Personalization perso;
	
	@Before
	public void setUp() throws Exception {
		perso = null;
	}

	@Override
	public Personalization getPerso() {
		
		if (perso == null) {
			perso = new Profile03();
		}
			
		return perso;
	}

}