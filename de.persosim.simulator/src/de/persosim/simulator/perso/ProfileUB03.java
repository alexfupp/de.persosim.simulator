package de.persosim.simulator.perso;

import de.persosim.simulator.crypto.CryptoUtil;
import de.persosim.simulator.utils.HexString;

/**
 * @author amay
 *
 */
public class ProfileUB03 extends AbstractProfile {
	
	@Override
	public void setPersoDataContainer() {
		persoDataContainer = PersonalizationDataContainer.getDefaultContainer();
		persoDataContainer.setDg1PlainData("UB");
		persoDataContainer.setDg3PlainData("20291031");
		persoDataContainer.setDg4PlainData("MARIA ELENA INÊS");
		persoDataContainer.setDg5PlainData("GARCIA LÓPEZ");
		persoDataContainer.setDg6PlainData("SCHWESTER ANNA");
		persoDataContainer.setDg7PlainData("DR.");
		persoDataContainer.setDg8PlainData("19640812");
		persoDataContainer.setDg9PlainData("GRANADA");
		persoDataContainer.setDg10PlainData("ESP");
		persoDataContainer.setDg17StreetPlainData("AMTSPLATZ 4A");
		persoDataContainer.setDg17CityPlainData("EISENACH");
		persoDataContainer.setDg17CountryPlainData("D");
		persoDataContainer.setDg17ZipPlainData("99817");
		persoDataContainer.setDg18PlainData("02761600560000");
		persoDataContainer.setEfCardAccess("3181C13012060A04007F0007020204020202010202010D300D060804007F00070202020201023012060A04007F00070202030202020102020129301C060904007F000702020302300C060704007F0007010202010D020129303E060804007F000702020831323012060A04007F0007020203020202010202012D301C060904007F000702020302300C060704007F0007010202010D02012D302A060804007F0007020206161E687474703A2F2F6273692E62756E642E64652F6369662F6E70612E786D6C");
		persoDataContainer.setEfCardSecurity("308209E506092A864886F70D010702A08209D6308209D2020103310F300D06096086480165030402030500308203D8060804007F0007030201A08203CA048203C6318203C23012060A04007F0007020204020202010202010D300D060804007F00070202020201023017060A04007F0007020205020330090201010201010101003019060904007F000702020502300C060704007F0007010202010D3017060A04007F0007020205020330090201010201020101FF3012060A04007F00070202030202020102020129301C060904007F000702020302300C060704007F0007010202010D0201293062060904007F0007020201023052300C060704007F0007010202010D0342000467C26931380033AF00024BA205E8BC592426387A3AB77B38C5996852F3279092570A545BC66A440B2157307CA931CEC064F031AA0D14AC95391ED4B95C5F537E0201293081A3060804007F00070202083181963012060A04007F0007020203020202010202012D301C060904007F000702020302300C060704007F0007010202010D02012D3062060904007F0007020201023052300C060704007F0007010202010D034200046BBCEB5553AE4690377296587F9CB22CD7917014C8CC783852EF17365C8772943D1A6EF3EBC2EE8801131151DB5B4C3CC7CF84E202746C13B724B1DFA1FD8C4C02012D302A060804007F0007020206161E687474703A2F2F6273692E62756E642E64652F6369662F6E70612E786D6C308201E6060804007F0007020207308201D8300B0609608648016503040204308201C73021020101041C8AC93144E93B0B69419544A9893160952DDE1731EA8E669606A18D203021020102041C37823963B71AF0BF5698D1FDC30DA2B7F9ECE57CFA4959BEE9D6D9943021020103041CE8B2A171DC1290A765F124AAFE33061C08C918A1069DFF5CAF4C62B53021020104041C087FC51ACFA1BC5836B691FAB46B15315E8743FEFA7FEC1C859FEC223021020105041C9D68329B8835E0ADC3D76050418372361B39477F212B60E97E3549FC3021020106041CAEFE9EA60255EBBF63A9BA102E53285B90967F85159DAC87A2DB46CF3021020107041C5EAE1006F624C5268D732916CEC70312309203F602171121A0D520133021020108041C6446E0A909967462B5C1117634F8A1B557EF74BE3F606C1E94EFAE433021020109041CEEDB83A3C08D2993B48E298750BEB93A6E4DC6518BE6198EB06FAFC3302102010D041C859FE631F5DA379D44239EB85FAFDF7D52FDBC88986B254045DCF82A3021020111041C0333AF0A9C5020FE5D8DB0E631DD5938544009ED092E6E0798BBC8733021020112041C3665AF65ACD4651387F8341EBF176FABA46457DFBEAF70A050186181302102010A041C5FD795B42F971223729CCF1EC0E4EDF35657A39EC8B45A93DC3362EFA082049530820491308203F6A003020102020204D6300A06082A8648CE3D0403043046310B3009060355040613024445310D300B060355040A0C0462756E64310C300A060355040B0C03627369311A301806035504030C115445535420637363612D6765726D616E79301E170D3230303531383039313634385A170D3330313231383233353935395A3057310B3009060355040613024445310C300A060355040A0C03425349310D300B0603550405130430303031312B302906035504030C225445535420446F63756D656E74205369676E65722065494420446F63756D656E7473308201B53082014D06072A8648CE3D020130820140020101303C06072A8648CE3D01010231008CB91E82A3386D280F5D6F7E50E641DF152F7109ED5456B412B1DA197FB71123ACD3A729901D1A71874700133107EC53306404307BC382C63D8C150C3C72080ACE05AFA0C2BEA28E4FB22787139165EFBA91F90F8AA5814A503AD4EB04A8C7DD22CE2826043004A8C7DD22CE28268B39B55416F0447C2FB77DE107DCD2A62E880EA53EEB62D57CB4390295DBC9943AB78696FA504C110461041D1C64F068CF45FFA2A63A81B7C13F6B8847A3E77EF14FE3DB7FCAFE0CBD10E8E826E03436D646AAEF87B2E247D4AF1E8ABE1D7520F9C2A45CB1EB8E95CFD55262B70B29FEEC5864E19C054FF99129280E4646217791811142820341263C53150231008CB91E82A3386D280F5D6F7E50E641DF152F7109ED5456B31F166E6CAC0425A7CF3AB6AF6B7FC3103B883202E9046565020101036200044FE09E288203B2665042982F5E818C0BD239A47F5A6DB2961140AED85AC76CAA90D2BF03E9989F8C10AA85612548B85963F3D568515DB26AD410FAE4F114F9CBC23AA02A781618DE13279DF80F79285A276BEDB75209C0A2A03BA5E14E4FF9B5A38201633082015F301F0603551D23041830168014539DB1872AAC9193D76392EE80D9E5996CF99B3B301D0603551D0E04160414D38EF323DF2F76B21883F81477A45835A9FDC204300E0603551D0F0101FF040403020780302B0603551D1004243022800F32303230303531383039313634385A810F32303230313231383233353935395A30160603551D20040F300D300B060904007F00070301010130260603551D11041F301D820B6273692E62756E642E6465A40E300C310A300806035504070C014430510603551D12044A30488118637363612D6765726D616E79406273692E62756E642E6465861C68747470733A2F2F7777772E6273692E62756E642E64652F63736361A40E300C310A300806035504070C01443016060767810801010602040B300902010031041302554230350603551D1F042E302C302AA028A0268624687474703A2F2F7777772E6273692E62756E642E64652F746573745F637363615F63726C300A06082A8648CE3D04030403818800308184024077DC62E5EBACD558CF27A9D8D2DA93BE46C0E34B55D6069F60E5B864E2459E069FEE1D6C1E65F171E7DEB0E8295CB3D9B1AD6E25015052FE90331BD6E431737F0240390E913A1017B7E5825C03E5D6FA29F2A8B0F74124C166DEA320D957C369FC05E096559C970E75296AD74B1992C2A8DE3E3B4D278A9038FB824BA633BAD076FA3182014530820141020101304C3046310B3009060355040613024445310D300B060355040A0C0462756E64310C300A060355040B0C03627369311A301806035504030C115445535420637363612D6765726D616E79020204D6300D06096086480165030402030500A06A301706092A864886F70D010903310A060804007F0007030201304F06092A864886F70D01090431420440B6F81A4694BAEE26AB80A0C989302AE97F1FC23304F1C07FA6895BBA9E7F03C46B9DFFA13EE099EAF817379400167911166BF9DC6347F9FF2BC870D7A4336617300A06082A8648CE3D0403040467306502302372CC8BFBA8749F83105A00159A9F538BF460C938E6E3BC1B53E84236A38B78496F981162B46695B82C825A4D60509C02310081425B3816DE99286A0BB3664BFA3ED41BB8080BAACEDE6EFDF4C6CA7D74B6DF3D593D5E145ECA90D6DE52D08ACF6295");
		persoDataContainer.setEfChipSecurity("3082079406092A864886F70D010702A082078530820781020103310F300D0609608648016503040203050030820188060804007F0007030201A082017A04820176318201723012060A04007F0007020204020202010202010D300D060804007F00070202020201023017060A04007F0007020205020330090201010201010101003019060904007F000702020502300C060704007F0007010202010D3017060A04007F0007020205020330090201010201020101FF3012060A04007F00070202030202020102020129301C060904007F000702020302300C060704007F0007010202010D0201293062060904007F0007020201023052300C060704007F0007010202010D0342000467C26931380033AF00024BA205E8BC592426387A3AB77B38C5996852F3279092570A545BC66A440B2157307CA931CEC064F031AA0D14AC95391ED4B95C5F537E020129303E060804007F000702020831323012060A04007F0007020203020202010202012D301C060904007F000702020302300C060704007F0007010202010D02012D302A060804007F0007020206161E687474703A2F2F6273692E62756E642E64652F6369662F6E70612E786D6CA082049530820491308203F6A003020102020204D6300A06082A8648CE3D0403043046310B3009060355040613024445310D300B060355040A0C0462756E64310C300A060355040B0C03627369311A301806035504030C115445535420637363612D6765726D616E79301E170D3230303531383039313634385A170D3330313231383233353935395A3057310B3009060355040613024445310C300A060355040A0C03425349310D300B0603550405130430303031312B302906035504030C225445535420446F63756D656E74205369676E65722065494420446F63756D656E7473308201B53082014D06072A8648CE3D020130820140020101303C06072A8648CE3D01010231008CB91E82A3386D280F5D6F7E50E641DF152F7109ED5456B412B1DA197FB71123ACD3A729901D1A71874700133107EC53306404307BC382C63D8C150C3C72080ACE05AFA0C2BEA28E4FB22787139165EFBA91F90F8AA5814A503AD4EB04A8C7DD22CE2826043004A8C7DD22CE28268B39B55416F0447C2FB77DE107DCD2A62E880EA53EEB62D57CB4390295DBC9943AB78696FA504C110461041D1C64F068CF45FFA2A63A81B7C13F6B8847A3E77EF14FE3DB7FCAFE0CBD10E8E826E03436D646AAEF87B2E247D4AF1E8ABE1D7520F9C2A45CB1EB8E95CFD55262B70B29FEEC5864E19C054FF99129280E4646217791811142820341263C53150231008CB91E82A3386D280F5D6F7E50E641DF152F7109ED5456B31F166E6CAC0425A7CF3AB6AF6B7FC3103B883202E9046565020101036200044FE09E288203B2665042982F5E818C0BD239A47F5A6DB2961140AED85AC76CAA90D2BF03E9989F8C10AA85612548B85963F3D568515DB26AD410FAE4F114F9CBC23AA02A781618DE13279DF80F79285A276BEDB75209C0A2A03BA5E14E4FF9B5A38201633082015F301F0603551D23041830168014539DB1872AAC9193D76392EE80D9E5996CF99B3B301D0603551D0E04160414D38EF323DF2F76B21883F81477A45835A9FDC204300E0603551D0F0101FF040403020780302B0603551D1004243022800F32303230303531383039313634385A810F32303230313231383233353935395A30160603551D20040F300D300B060904007F00070301010130260603551D11041F301D820B6273692E62756E642E6465A40E300C310A300806035504070C014430510603551D12044A30488118637363612D6765726D616E79406273692E62756E642E6465861C68747470733A2F2F7777772E6273692E62756E642E64652F63736361A40E300C310A300806035504070C01443016060767810801010602040B300902010031041302554230350603551D1F042E302C302AA028A0268624687474703A2F2F7777772E6273692E62756E642E64652F746573745F637363615F63726C300A06082A8648CE3D04030403818800308184024077DC62E5EBACD558CF27A9D8D2DA93BE46C0E34B55D6069F60E5B864E2459E069FEE1D6C1E65F171E7DEB0E8295CB3D9B1AD6E25015052FE90331BD6E431737F0240390E913A1017B7E5825C03E5D6FA29F2A8B0F74124C166DEA320D957C369FC05E096559C970E75296AD74B1992C2A8DE3E3B4D278A9038FB824BA633BAD076FA3182014430820140020101304C3046310B3009060355040613024445310D300B060355040A0C0462756E64310C300A060355040B0C03627369311A301806035504030C115445535420637363612D6765726D616E79020204D6300D06096086480165030402030500A06A301706092A864886F70D010903310A060804007F0007030201304F06092A864886F70D01090431420440AEEB6102672366A1BDBEF9B2CBAD19CFEA31B5FA763F085F1BE9BCAD88CF184B8B0394CA3A3316760EB6AAE28D60627F543BA7955F64D14A188F41115EE73D16300A06082A8648CE3D040304046630640230478E86E49AB5E90256BBF0ED19EBF545C09517954AD2B01276083DAA82CC4985C9C469825B3936AC79F8EDE7BABF775502306D96F8978D2E000C33F5C72BA9A30C51C8B6158F2745AE4CBE7F3553B9099969F48035DDE6BB2A8743A4A213C851089F");
		
		String documentNumber = "00000UB03";
		String sex = "F";
		String mrzLine3 = "GARCIA<LOPEZ<<MARIA<ELENA<INES";
		String mrz = persoDataContainer.createMrzFromDgs(documentNumber, sex, mrzLine3);
		
		persoDataContainer.setMrz(mrz);
		persoDataContainer.setEpassDg1PlainData(mrz);
		
		// unprivileged CA key
		persoDataContainer.addCaKeyPair(CryptoUtil.reconstructKeyPair(13,
				HexString.toByteArray("0467C26931380033AF00024BA205E8BC592426387A3AB77B38C5996852F3279092570A545BC66A440B2157307CA931CEC064F031AA0D14AC95391ED4B95C5F537E"),
				HexString.toByteArray("751B90F43087F3295E8BD811F8290F2504D06602DA8CD5A2EAAF53FB660C634C")),
				41, false);
		
		// privileged CA key
		persoDataContainer.addCaKeyPair(CryptoUtil.reconstructKeyPair(13,
				HexString.toByteArray("046BBCEB5553AE4690377296587F9CB22CD7917014C8CC783852EF17365C8772943D1A6EF3EBC2EE8801131151DB5B4C3CC7CF84E202746C13B724B1DFA1FD8C4C"),
				HexString.toByteArray("2A8D79D6ADD76A258E20B121B71FED879A615632612A7D7072BAE0B0E365580B")),
				45, true);
		
		// individual RI key - 1st sector public/private key pair (Sperrmerkmal)
		persoDataContainer.addRiKeyPair(CryptoUtil.reconstructKeyPair(13,
				HexString.toByteArray("0478EC4B2A1483BF1BADC150A9C6C8962DC6F53B1AB7E1EB7C6C6A4D38E9059E43274450AE84C87C0DF5FE6F70DF71424A1F2C92A05CC628F6770F8096CCE5464F"),
				HexString.toByteArray("424D92F0BE31D6B7923C50AE4A0BA3155E21BF117B89B4E5252ABC0E74904618")),
				1, false);

		// individual RI key - 2nd sector public/private key pair (Pseudonym)
		persoDataContainer.addRiKeyPair(CryptoUtil.reconstructKeyPair(13,
				HexString.toByteArray("042D6102CE1B32D0E0BB139EEA089A575D7F031706F297B6E67EE93F9A3DF062101AAB592EE4FA3A486CB20C9B8065A97614DE135CFF00283CDBB4BCA470BBE985"),
				HexString.toByteArray("5DA9C0796882D1775C67C40098788FFD595217A9FAF1EB1806CF22060078F9DA")),
				2, true);
	}

}