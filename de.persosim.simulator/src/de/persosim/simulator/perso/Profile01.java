package de.persosim.simulator.perso;

import de.persosim.simulator.crypto.CryptoUtil;
import de.persosim.simulator.utils.HexString;

/**
 * @author slutters
 *
 */
public class Profile01 extends AbstractProfile {
	
	@Override
	public void setPersoDataContainer() {		persoDataContainer = PersonalizationDataContainer.getDefaultContainer();
		persoDataContainer.setDg4PlainData("ERIKA");
		persoDataContainer.setDg5PlainData("MUSTERMANN");
		persoDataContainer.setDg8PlainData("19640812");
		persoDataContainer.setDg9PlainData("BERLIN");
		persoDataContainer.setDg13PlainData("GABLER");
		persoDataContainer.setDg17StreetPlainData("HEIDESTRASSE 17");
		persoDataContainer.setDg17CityPlainData("KÖLN");
		persoDataContainer.setDg17CountryPlainData("D");
		persoDataContainer.setDg17ZipPlainData("51147");
		persoDataContainer.setDg18PlainData("02760503150000");
		persoDataContainer.setEfCardAccess("3181C13012060A04007F0007020204020202010202010D300D060804007F00070202020201023012060A04007F00070202030202020102020129301C060904007F000702020302300C060704007F0007010202010D020129303E060804007F000702020831323012060A04007F0007020203020202010202012D301C060904007F000702020302300C060704007F0007010202010D02012D302A060804007F0007020206161E687474703A2F2F6273692E62756E642E64652F6369662F6E70612E786D6C");
		persoDataContainer.setEfCardSecurity("308206B006092A864886F70D010702A08206A13082069D020103310F300D0609608648016503040204050030820188060804007F0007030201A082017A04820176318201723012060A04007F0007020204020202010202010D300D060804007F00070202020201023017060A04007F0007020205020330090201010201010101003019060904007F000702020502300C060704007F0007010202010D3017060A04007F0007020205020330090201010201020101FF3012060A04007F00070202030202020102020129301C060904007F000702020302300C060704007F0007010202010D0201293062060904007F0007020201023052300C060704007F0007010202010D0342000419D4B7447788B0E1993DB35500999627E739A4E5E35F02D8FB07D6122E76567F17758D7A3AA6943EF23E5E2909B3E8B31BFAA4544C2CBF1FB487F31FF239C8F8020129303E060804007F000702020831323012060A04007F0007020203020202010202012D301C060904007F000702020302300C060704007F0007010202010D02012D302A060804007F0007020206161E687474703A2F2F6273692E62756E642E64652F6369662F6E70612E786D6CA08203EE308203EA30820371A00302010202012D300A06082A8648CE3D0403033055310B3009060355040613024445310D300B060355040A0C0462756E64310C300A060355040B0C03627369310D300B0603550405130430303033311A301806035504030C115445535420637363612D6765726D616E79301E170D3134303732333036333034305A170D3235303232333233353935395A305C310B3009060355040613024445310C300A060355040A0C03425349310D300B06035504051304303035303130302E06035504030C275445535420446F63756D656E74205369676E6572204964656E7469747920446F63756D656E7473308201133081D406072A8648CE3D02013081C8020101302806072A8648CE3D0101021D00FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF000000000000000000000001303C041CFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFE041CB4050A850C04B3ABF54132565044B0B7D7BFD8BA270B39432355FFB4043904B70E0CBD6BB4BF7F321390B94A03C1D356C21122343280D6115C1D21BD376388B5F723FB4C22DFE6CD4375A05A07476444D5819985007E34021D00FFFFFFFFFFFFFFFFFFFFFFFFFFFF16A2E0B8F03E13DD29455C5C2A3D020101033A00043A79C3CBFDB8A6E569C9226CD54E81DE14381BC92A61AD554EBF349BFAFD72F18DC85D78E49742F37A75411E28E894308D6880D1380FBEB4A382016D30820169301F0603551D23041830168014A38DB7C0DBECF5A91FCA6B3D5EB2F328B5A5DC17301D0603551D0E04160414CF0A2AC150F28ADE4329F662E3D21CE5C78BCDE9300E0603551D0F0101FF040403020780302B0603551D1004243022800F32303134303732333036333034305A810F32303135303232333233353935395A30160603551D20040F300D300B060904007F000703010101302D0603551D1104263024821262756E646573647275636B657265692E6465A40E300C310A300806035504070C014430510603551D12044A30488118637363612D6765726D616E79406273692E62756E642E6465861C68747470733A2F2F7777772E6273692E62756E642E64652F63736361A40E300C310A300806035504070C01443019060767810801010602040E300C02010031071301411302494430350603551D1F042E302C302AA028A0268624687474703A2F2F7777772E6273692E62756E642E64652F746573745F637363615F63726C300A06082A8648CE3D040303036700306402300D90B1C6E52B5E20D8ECE1520981E11EF1AF02906A930420F87E90315588B70C0C9642160E877E42B1CE311849E388B802303450209749C1368D965CE879460F729E68BAB9D5D3269724721D0C564FB2752EC4C0F8F5542990CFDB7C848AA7D0A2BB3182010730820103020101305A3055310B3009060355040613024445310D300B060355040A0C0462756E64310C300A060355040B0C03627369310D300B0603550405130430303033311A301806035504030C115445535420637363612D6765726D616E7902012D300D06096086480165030402040500A046301706092A864886F70D010903310A060804007F0007030201302B06092A864886F70D010904311E041CC57AFB616E6837B63B22666F48547E3AD71795E33326C0CE5FF27C3A300A06082A8648CE3D040301043F303D021C58AE1E82475BE9C9167810593FCF7CA791DE45910380D5CF4FEB84D7021D00FFD316D91D85664479596BAFBBB2532540047334668E0C47EE99B826");
		persoDataContainer.setEfChipSecurity("308208DC06092A864886F70D010702A08208CD308208C9020103310F300D06096086480165030402040500308203B5060804007F0007030201A08203A7048203A33182039F3012060A04007F0007020204020202010202010D300D060804007F00070202020201023017060A04007F0007020205020330090201010201010101003019060904007F000702020502300C060704007F0007010202010D3017060A04007F0007020205020330090201010201020101FF3012060A04007F00070202030202020102020129301C060904007F000702020302300C060704007F0007010202010D0201293062060904007F0007020201023052300C060704007F0007010202010D0342000419D4B7447788B0E1993DB35500999627E739A4E5E35F02D8FB07D6122E76567F17758D7A3AA6943EF23E5E2909B3E8B31BFAA4544C2CBF1FB487F31FF239C8F80201293081A3060804007F00070202083181963012060A04007F0007020203020202010202012D301C060904007F000702020302300C060704007F0007010202010D02012D3062060904007F0007020201023052300C060704007F0007010202010D034200041AC6CAE884A6C2B8461404150F54CD1150B21E862A4E5F21CE34290C741104BD1BF31ED91E085D7C630E8B4D10A8AE22BBB2898B44B52EA0F4CDADCF57CFBA2502012D302A060804007F0007020206161E687474703A2F2F6273692E62756E642E64652F6369662F6E70612E786D6C308201C3060804007F0007020207308201B5300B0609608648016503040204308201A43021020101041C2FF0247F59DD3C646E314F03ABB33EE91A586577EBDF48D3864EC34D3021020102041C37823963B71AF0BF5698D1FDC30DA2B7F9ECE57CFA4959BEE9D6D9943021020103041CA105E4EF19FEEC01DC64FBE1AECBEBC2A492DE78C89D439A8C301E853021020104041CAD81D20DBD4F5687FDB05E5037EC267609FDE28C6036FDBDF2C8B4333021020105041CA90F28EB7A0FA0DE83ABF3293D14E0838B9C85FC7277CBB97737A32B3021020106041C712B8550E49A13C64DCED4457E9A0F5A85DC26CD6A321596723005D63021020107041C42A8FA36B60887ED022CD3B6ECC255220FBE8CB3F607E416601FCAA63021020108041C6446E0A909967462B5C1117634F8A1B557EF74BE3F606C1E94EFAE433021020109041C635D1017F4ABC656B9FDDDD7E0FBB1E992B7686E89485E6AB51B638B302102010D041C04DB93544A64BC1245B10AAB266386F08F8E89F72E1DB178C172624D3021020111041CF0CBFF6A779EDF9D354EC73AF2297DA08389D5AE492F6F6B36C040143021020112041C57CE396CA707B96FA37C580F693230E4D4AEBB97293F0909489D95CBA08203EE308203EA30820371A00302010202012D300A06082A8648CE3D0403033055310B3009060355040613024445310D300B060355040A0C0462756E64310C300A060355040B0C03627369310D300B0603550405130430303033311A301806035504030C115445535420637363612D6765726D616E79301E170D3134303732333036333034305A170D3235303232333233353935395A305C310B3009060355040613024445310C300A060355040A0C03425349310D300B06035504051304303035303130302E06035504030C275445535420446F63756D656E74205369676E6572204964656E7469747920446F63756D656E7473308201133081D406072A8648CE3D02013081C8020101302806072A8648CE3D0101021D00FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF000000000000000000000001303C041CFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFE041CB4050A850C04B3ABF54132565044B0B7D7BFD8BA270B39432355FFB4043904B70E0CBD6BB4BF7F321390B94A03C1D356C21122343280D6115C1D21BD376388B5F723FB4C22DFE6CD4375A05A07476444D5819985007E34021D00FFFFFFFFFFFFFFFFFFFFFFFFFFFF16A2E0B8F03E13DD29455C5C2A3D020101033A00043A79C3CBFDB8A6E569C9226CD54E81DE14381BC92A61AD554EBF349BFAFD72F18DC85D78E49742F37A75411E28E894308D6880D1380FBEB4A382016D30820169301F0603551D23041830168014A38DB7C0DBECF5A91FCA6B3D5EB2F328B5A5DC17301D0603551D0E04160414CF0A2AC150F28ADE4329F662E3D21CE5C78BCDE9300E0603551D0F0101FF040403020780302B0603551D1004243022800F32303134303732333036333034305A810F32303135303232333233353935395A30160603551D20040F300D300B060904007F000703010101302D0603551D1104263024821262756E646573647275636B657265692E6465A40E300C310A300806035504070C014430510603551D12044A30488118637363612D6765726D616E79406273692E62756E642E6465861C68747470733A2F2F7777772E6273692E62756E642E64652F63736361A40E300C310A300806035504070C01443019060767810801010602040E300C02010031071301411302494430350603551D1F042E302C302AA028A0268624687474703A2F2F7777772E6273692E62756E642E64652F746573745F637363615F63726C300A06082A8648CE3D040303036700306402300D90B1C6E52B5E20D8ECE1520981E11EF1AF02906A930420F87E90315588B70C0C9642160E877E42B1CE311849E388B802303450209749C1368D965CE879460F729E68BAB9D5D3269724721D0C564FB2752EC4C0F8F5542990CFDB7C848AA7D0A2BB3182010630820102020101305A3055310B3009060355040613024445310D300B060355040A0C0462756E64310C300A060355040B0C03627369310D300B0603550405130430303033311A301806035504030C115445535420637363612D6765726D616E7902012D300D06096086480165030402040500A046301706092A864886F70D010903310A060804007F0007030201302B06092A864886F70D010904311E041CD467691DFC209B26321A8BBF89EA8FFE93135C31478A8BE33C0A8805300A06082A8648CE3D040301043E303C021C53E23179A645613CB23387B13FCCD8D0F015D6227D59F8343B0D46CA021C2D238B6224860725EC52C59AF6E75591193AB541DEB161BC89FCD9D7");
		
		String documentNumber = "000000001";
		String sex = "F";
		String mrzLine3 = "MUSTERMANN<<ERIKA<<<<<<<<<<<<<";
		String mrz = persoDataContainer.createMrzFromDgs(documentNumber, sex, mrzLine3);
		
		persoDataContainer.setMrz(mrz);
		persoDataContainer.setEpassDg1PlainData(mrz);
		
		// unprivileged CA key
		persoDataContainer.addCaKeyPair(CryptoUtil.reconstructKeyPair(13,
				HexString.toByteArray("0419D4B7447788B0E1993DB35500999627E739A4E5E35F02D8FB07D6122E76567F17758D7A3AA6943EF23E5E2909B3E8B31BFAA4544C2CBF1FB487F31FF239C8F8"),
				HexString.toByteArray("A07EB62E891DAA84643E0AFCC1AF006891B669B8F51E379477DBEAB8C987A610")),
				41, false);
		
		// privileged CA key
		persoDataContainer.addCaKeyPair(CryptoUtil.reconstructKeyPair(13,
				HexString.toByteArray("041AC6CAE884A6C2B8461404150F54CD1150B21E862A4E5F21CE34290C741104BD1BF31ED91E085D7C630E8B4D10A8AE22BBB2898B44B52EA0F4CDADCF57CFBA25"),
				HexString.toByteArray("763B6BBF8A7DFC5DAB3205791BA64D211BBC4E8A5C531C77488792C508BD3D1E")),
				45, true);
		
		// individual RI key - 1st sector public/private key pair (Sperrmerkmal)
		persoDataContainer.addRiKeyPair(CryptoUtil.reconstructKeyPair(13,
				HexString.toByteArray("041BB377A683CE97DF9FDD5D121FFB235DDFF4F489BF645D75AF87A5B7D4B74EA22DFE7200EA90D3820CA9EBBC7ACE272B0919AA2703C591D78960854F7E498D20"),
				HexString.toByteArray("9E14FD0D1F5828CF828BA71EC13440DD44E0D95A7F903F9F50C05E0402503871")),
				1, false);

		// individual RI key - 2nd sector public/private key pair (Pseudonym)
		persoDataContainer.addRiKeyPair(CryptoUtil.reconstructKeyPair(13,
				HexString.toByteArray("049862543716B0F5C580D62653C19DF2F0E117E085E1C210E7ED8050F678EB79A91D2EA91B022A0BA3852CE03AB5A1FE39B98D2F3111CD20E8E7B5447A50DB6E64"),
				HexString.toByteArray("A96900652CD324770078AEBF8C52EF462E5DEA406B9B977138DF891B44DCE7D8")),
				2, true);
	}
	
}
