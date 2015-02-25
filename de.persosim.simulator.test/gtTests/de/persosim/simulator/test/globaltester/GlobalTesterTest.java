package de.persosim.simulator.test.globaltester;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.persosim.simulator.PersoSim;
import de.persosim.simulator.Simulator;
import de.persosim.simulator.adapter.socket.SimulatorProvider;
import de.persosim.simulator.adapter.socket.SocketAdapter;
import de.persosim.simulator.cardobjects.AuthObjectIdentifier;
import de.persosim.simulator.cardobjects.CardFile;
import de.persosim.simulator.cardobjects.CardObject;
import de.persosim.simulator.cardobjects.DedicatedFileIdentifier;
import de.persosim.simulator.cardobjects.ElementaryFile;
import de.persosim.simulator.cardobjects.MrzAuthObject;
import de.persosim.simulator.cardobjects.PasswordAuthObject;
import de.persosim.simulator.cardobjects.ShortFileIdentifier;
import de.persosim.simulator.perso.DefaultPersonalization;
import de.persosim.simulator.perso.Personalization;
import de.persosim.simulator.protocols.Tr03110;
import de.persosim.simulator.test.PersoSimTestCase;
import de.persosim.simulator.utils.HexString;

public abstract class GlobalTesterTest extends PersoSimTestCase implements Tr03110 {

	private static final String GT_SERVER_HOST = "localhost";
	private static final int GT_SERVER_PORT = 6789;
	private static final int GT_SERVER_RESULT_PORT = 6788;
	
	private static final int SIM_PORT = 9876;
	
//	private static final String BASE_PATH = "\\persosim_servermode_tests";
//	private static final String PATH_LOGGING = BASE_PATH + "\\logging";

	private static GtServerConnection gtServer;

	@BeforeClass
	public static void setUpSuite() throws Exception {
		// initialize GT server connection
		gtServer = new GtServerConnection(GT_SERVER_HOST, GT_SERVER_PORT,
				GT_SERVER_RESULT_PORT);
		gtServer.connect();

	}

	@AfterClass
	public static void tearDownSuite() {
		// disconnect GT server connection
		if (gtServer != null) {
			gtServer.closeConnection();
		}
	}

	private SocketAdapter simulator;
	
	@Before
	public void setUp() throws Exception {
		startSimulator();
		configureGtServer();
	}
	
	@After
	public void tearDown(){
		stopSimulator();
	}
	
	private void resetSimulator(){
		stopSimulator();
		getPersonalization().reset();
		startSimulator();
	}
	
	private void stopSimulator(){
		//stop PersoSim Thread
		if (simulator != null) {
			simulator.stop();
			simulator = null;
		}
	}

	
	@Test
	public void testAllApplicableTests() throws Exception {
		gtServer.clearCollectedResults();
		
		Collection<JobDescriptor> suites = getAllApplicableGtTests();
		for (JobDescriptor curSuite : suites) {
			if (curSuite instanceof SimulatorReset){
				resetSimulator();
			} else if (curSuite instanceof GtSuiteDescriptor){
				gtServer.runSuiteAndSaveResults((GtSuiteDescriptor)curSuite);
			}
		}
		
		gtServer.checkAndClearResults(0, 0);
	}

	private void startSimulator() {
		if (simulator == null) {
			simulator = new SocketAdapter(new SimulatorProvider() {
				@Override
				public Simulator getSimulator() {
					return new PersoSim();
				}
			}, SIM_PORT);
		}
		
		if (!simulator.isRunning()) {
			simulator.start();
		}
	}
	
	private void configureGtServer() throws Exception {
		//disable dialogs
		gtServer.setPreferences(GtServerConnection.PREF_QUALIFIER_TESTMANAGER, "PROFILES_SHOW_DIALOG", "false");
		gtServer.setPreferences(GtServerConnection.PREF_QUALIFIER_TESTMANAGER, "INTEGRITY_WARNING_DIALOG", "false");
		
		//set logging options
		gtServer.setPreferences(GtServerConnection.PREF_QUALIFIER_LOGGING, "GT Test - Logging level", "0");
		gtServer.setPreferences(GtServerConnection.PREF_QUALIFIER_LOGGING, "GT Simulator - Logging level", "0");
//		gtServer.setPreferences(GtServerConnection.PREF_QUALIFIER_LOGGING, "manualDirSettings", "true");
//		gtServer.setPreferences(GtServerConnection.PREF_QUALIFIER_LOGGING, "GT Test - Add single logfiles for Testcases", "false");
//		gtServer.setPreferences(GtServerConnection.PREF_QUALIFIER_LOGGING, "GT Test - Logging directory", gtServer.getWorkspaceDir()+PATH_LOGGING);

		//configure profiles
		gtServer.setSupportedProfiles(getSupportedProfiles());
		
		
		//TODO configureGtServer
		transmitPasswords();
		transmitEidData();
//		configureCertificates();
//		transmitCertificates();
//		generateCertificatesIfNeeded();
	}
	
	private void transmitEidData() {

		CardFile dg18 = getEidDg(0x12);
		if(dg18 instanceof ElementaryFile) {
			try {
				Field f = ElementaryFile.class.getDeclaredField("content");
				f.setAccessible(true);
				byte[] content = (byte[]) f.get(dg18); 
				content = Arrays.copyOfRange(content, 4, content.length);
				gtServer.setPreferences(GtServerConnection.PREF_QUALIFIER_EAC2, "pref_epa_communityID", HexString.encode(content));
			} catch (IOException | NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				// ignore communityId if it can't be extracted
			}
		}
			
	}

	private CardFile getEidDg(int sfid) {
		Collection<CardObject> cardApplications = getPersonalization().getObjectTree().findChildren(new DedicatedFileIdentifier(HexString
				.toByteArray(DefaultPersonalization.AID_EID)));
		
		for (Iterator<CardObject> iterator = cardApplications.iterator(); iterator.hasNext();) {
			CardObject eidApplication = iterator.next();
		
			Collection<CardObject> cardFiles = eidApplication.findChildren(new ShortFileIdentifier(sfid));
			if (!cardFiles.isEmpty()) {
				return (CardFile) cardFiles.iterator().next();
			}
		}

		return null;
	}

	private void transmitPasswords() throws IOException {
		String mrz = getMrz();
		byte[] can = getPassword(ID_CAN);
		byte[] pin = getPassword(ID_PIN);
		byte[] puk = getPassword(ID_PUK);
		
		if (mrz != null) {
			gtServer.setPreferences(GtServerConnection.PREF_QUALIFIER_SECUREMESSAGING, "Use MRZ Reader", "false");
			
			String mrz1 = null;
			String mrz2 = null; 
			String mrz3 = null;
			
			switch (mrz.length()) {
			case 74:
				mrz1 = mrz.substring(0, 36);
				mrz2 = mrz.substring(36, 74);
				mrz3 = "";
				break;
				
			case 88:
				mrz1 = mrz.substring(0, 44);
				mrz2 = mrz.substring(44, 88);
				mrz3 = "";
				break;
				
			case 90:
				mrz1 = mrz.substring(0, 30);
				mrz2 = mrz.substring(30, 60);
				mrz3 = mrz.substring(60, 90);
				break;

			default:
				break;
			}
			
			gtServer.setPreferences(GtServerConnection.PREF_QUALIFIER_SECUREMESSAGING, "Default definition of first line in MRZ", mrz1);
			gtServer.setPreferences(GtServerConnection.PREF_QUALIFIER_SECUREMESSAGING, "Default definition of second line in MRZ", mrz2);
			gtServer.setPreferences(GtServerConnection.PREF_QUALIFIER_SECUREMESSAGING, "Default definition of third line in MRZ", mrz3);
			
			gtServer.setPreferences(GtServerConnection.PREF_QUALIFIER_SECUREMESSAGING, "Activate third MRZ line", mrz3.length() > 0 ? "true" : "false");
		}
		
		if (can != null) {
			gtServer.setPreferences(GtServerConnection.PREF_QUALIFIER_SECUREMESSAGING, "pref_epa_can", new String(can));
		}
		
		if (pin != null) {
			gtServer.setPreferences(GtServerConnection.PREF_QUALIFIER_SECUREMESSAGING, "pref_epa_pin", new String(pin));
		}
		
		if (puk != null) {
			gtServer.setPreferences(GtServerConnection.PREF_QUALIFIER_SECUREMESSAGING, "pref_epa_puk", new String(puk));
		}

	}
	
	/**
	 * This method returns the MRZ used for personalization. If no MRZ is set null is returned.
	 * @return the MRZ used for personalization
	 */
	protected String getMrz() {
		PasswordAuthObject pwdAuthObject = getPasswordAuthObject(Tr03110.ID_MRZ);
		
		if((pwdAuthObject == null) || (!(pwdAuthObject instanceof MrzAuthObject))) {
			return null;
		}
		
		return ((MrzAuthObject) pwdAuthObject).getMrz();
	}
	
	/**
	 * This method returns the requested password as set during personalization.
	 * If no such password is set null is returned.
	 * Valid password identifiers as set in {@link Tr03110} e.g. are ID_MRZ, ID_CA, ID_PIN, ID_PUK.
	 * @param passwordIdentifier the password identifier
	 * @return the requested password as set during personalization
	 */
	protected byte[] getPassword(int passwordIdentifier) {
		PasswordAuthObject pwdAuthObject = getPasswordAuthObject(passwordIdentifier);
		
		if(pwdAuthObject == null) {
			return null;
		}
		
		return pwdAuthObject.getPassword();
	}
	
	/**
	 * This method returns the {@link PasswordAuthObject} identified by the provided password identifier.
	 * @param passwordIdentifier the password identifier to identify a password auth object
	 * @return the identified password auth object if found, otherwise null
	 */
	protected PasswordAuthObject getPasswordAuthObject(int passwordIdentifier) {
		Collection<CardObject> cardObjects = getPersonalization().getObjectTree().findChildren(new AuthObjectIdentifier(passwordIdentifier));
		
		if(cardObjects.isEmpty()) {
			return null;
		}
		
		CardObject cardObject = cardObjects.iterator().next();
		
		if(cardObject instanceof PasswordAuthObject) {
			return (PasswordAuthObject) cardObject;
		} else{
			return null;
		}
	}

	/**
	 * Returns the {@link Personalization} instance to be used with the
	 * GlobalTester test cases
	 */
	public abstract Personalization getPersonalization();

	/**
	 * Returns all GlobalTester profiles that the current personalization
	 * supports.
	 * <p/>
	 * In order to ensure that no tests are missed abstract superclasses are
	 * expected to either don't implement this method at all or implement it in
	 * a way that provides all possible profiles so that subclasses are required
	 * to call the super implementation and restrict the returned Collection.
	 * 
	 * @return
	 */
	public abstract Collection<String> getSupportedProfiles();

	/**
	 * Return a collection of applicable GlobalTester test suites/test cases
	 * represented by their according {@link GtSuiteDescriptor}s. These are
	 * executed by {@link #testAllApplicableTests()} and expected to return
	 * Failures.
	 * 
	 * This must not return an empty List as the number of executed test cases is
	 * expected to be larger than 0.
	 * 
	 * @return
	 */
	public abstract Collection<JobDescriptor> getAllApplicableGtTests();

}