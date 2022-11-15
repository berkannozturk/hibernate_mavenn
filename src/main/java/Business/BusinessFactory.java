package Business;

import Model.Ogrenci;

public class BusinessFactory {

	public static IBusiness<Ogrenci> getEklemeFactory(){
		
		return new Business();
	}

	

}
