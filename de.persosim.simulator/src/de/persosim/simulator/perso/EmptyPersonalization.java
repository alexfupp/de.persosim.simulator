package de.persosim.simulator.perso;

import java.util.Collections;
import java.util.List;

import de.persosim.simulator.cardobjects.MasterFile;
import de.persosim.simulator.protocols.Protocol;

/**
 * This class represents a minimum of personalization e.g. for testing purposes.
 * The personalization contains an MF, an EF.CardAccess and the file management protocol.
 * Please note that the content of EF.CardAccess can be chosen arbitrarily and hence may neither be valid nor any TLV structure at all.
 * The content of EF.CardAccess primarily is intended for identification of the personalization.
 * 
 * @author slutters
 *
 */
public class EmptyPersonalization implements Personalization {

	@Override
	public MasterFile getObjectTree() {
		return new MasterFile();
	}

	@Override
	public List<Protocol> getProtocolList() {
		return Collections.emptyList();
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}
	
}
