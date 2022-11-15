package Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Model.Ogrenci;

public class OgrenciRepository implements IRepository<Ogrenci>{

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnitName");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	
	
	@Override
	public void Kaydet(Ogrenci ogrenci) {
		transaction.begin();
		manager.persist(ogrenci); // persist insert anlamına geliyor.
		transaction.commit();
		manager.close();
		
	}

}
