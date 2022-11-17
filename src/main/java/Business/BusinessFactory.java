package Business;

import Model.Ogrenci;

public class BusinessFactory {

	public static IBusiness<Ogrenci> getBusinessFactory(){
		
		return new Business();
	}

	
	

}
