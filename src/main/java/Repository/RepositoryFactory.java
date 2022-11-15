package Repository;

import Model.Ogrenci;

public class RepositoryFactory {

	public  static IRepository<Ogrenci> getOgrenciRepository() {
		
			return new OgrenciRepository();
	}
}
