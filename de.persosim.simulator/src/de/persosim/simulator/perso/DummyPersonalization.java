package de.persosim.simulator.perso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import de.persosim.simulator.apdu.CommandApdu;
import de.persosim.simulator.apdu.ResponseApdu;
import de.persosim.simulator.apdumatching.ApduSpecification;
import de.persosim.simulator.cardobjects.FileIdentifier;
import de.persosim.simulator.cardobjects.MasterFile;
import de.persosim.simulator.platform.CardStateAccessor;
import de.persosim.simulator.platform.Iso7816;
import de.persosim.simulator.processing.ProcessingData;
import de.persosim.simulator.protocols.Protocol;
import de.persosim.simulator.tlv.TlvDataObject;
import de.persosim.simulator.utils.InfoSource;

/**
 * This class represents a minimum of personalization e.g. for testing purposes.
 * The personalization contains an MF, an EF.CardAccess and the file management protocol.
 * Please note that the content of EF.CardAccess can be chosen arbitrarily and hence may neither be valid nor any TLV structure at all.
 * The content of EF.CardAccess primarily is intended for identification of the personalization.
 * 
 * @author slutters
 *
 */
public class DummyPersonalization implements Personalization {

	@Override
	public MasterFile getObjectTree() {
		return new MasterFile(new FileIdentifier(0x3F00), null);
	}

	@Override
	public List<Protocol> getProtocolList() {
		ArrayList<Protocol> protocols = new ArrayList<Protocol>();

		/* load FM protocol */
		Protocol fileManagementProtocol = new Protocol() {
			@Override
			public void setCardStateAccessor(CardStateAccessor cardState) {
			}
			
			@Override
			public void reset() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void process(ProcessingData processingData) {
				InfoSource info = new InfoSource() {
					
					@Override
					public String getIDString() {
						return "DUMMY PROTOCOL";
					}
				};
				
				if (processingData.getCommandApdu().getIns() == 0x0A){
					ResponseApdu resp = new ResponseApdu(Iso7816.SW_9000_NO_ERROR);
					processingData.updateResponseAPDU(info,
							"file selected successfully", resp);
				} else {
					ResponseApdu resp = new ResponseApdu(Iso7816.SW_6D00_INS_NOT_SUPPORTED);
					processingData.updateResponseAPDU(info,
							"file selected successfully", resp);
				}
			}
			
			@Override
			public boolean isMoveToStackRequested() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public Collection<? extends TlvDataObject> getSecInfos(
					SecInfoPublicity publicity, MasterFile mf) {
				// TODO Auto-generated method stub
				return Collections.emptyList();
			}
			
			@Override
			public String getProtocolName() {
				// TODO Auto-generated method stub
				return "DUMMY PROTOCOL";
			}
			
			@Override
			public Collection<ApduSpecification> getApduSet() {
				ApduSpecification test  = new ApduSpecification("ID"){

					@Override
					public boolean matchesFullApdu(CommandApdu apdu) {
						return true;
					}

					@Override
					public boolean isInitialAPDU() {
						return true;
					}
					
				};
				ArrayList<ApduSpecification> list = new ArrayList<ApduSpecification>();
				list.add(test);
				return list;
			}
		};
		protocols.add(fileManagementProtocol);
		return protocols;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}
	
}
