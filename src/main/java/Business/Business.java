package Business;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Model.Ogrenci;
import Repository.IRepository;
import Repository.RepositoryFactory;

public class Business implements IBusiness<Ogrenci> {

	@Override
	public void ekle(Ogrenci ogrenci) {

		IRepository<Ogrenci> ogrenciKayit = RepositoryFactory.getOgrenciRepository();
		ogrenciKayit.Kaydet(ogrenci);
	}

}
