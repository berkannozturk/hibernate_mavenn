package Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transaction;

import Model.Ogrenci;

public class OgrenciRepository implements IRepository<Ogrenci> {

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

	@Override
	public void Guncelle(Ogrenci ogrenci, int ogrenci_id) {

		manager.find(Ogrenci.class, ogrenci.getId());

		transaction.begin();

		manager.merge(ogrenci);

		transaction.commit();

		manager.close();
	}

	@Override
	public void Sil(Ogrenci ogrenci, int id) {

		Ogrenci ogrencii = manager.find(Ogrenci.class, id);

		transaction.begin();

		manager.remove(ogrencii);
		transaction.commit();
		manager.close();

	}

	@Override
	public List<Ogrenci> Listele(Object o) {
		Query query = manager.createQuery("SELECT o FROM Ogrenci o");

		List<Ogrenci> liste = query.getResultList();

		return liste;

	}

}
