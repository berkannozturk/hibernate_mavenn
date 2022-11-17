package Business;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import Model.Ogrenci;
import Repository.IRepository;
import Repository.RepositoryFactory;

public class Business implements IBusiness<Ogrenci> {

	@Override
	public void ekle(Ogrenci ogrenci) {

		IRepository<Ogrenci> ogrenciKayit = RepositoryFactory.getOgrenciRepository();
		ogrenciKayit.Kaydet(ogrenci);
	}



	@Override
	public void guncelle(Ogrenci ogrenci , int ogrenci_id) {
		IRepository<Ogrenci> ogrenciGüncelle = RepositoryFactory.getOgrenciRepository();
		ogrenciGüncelle.Guncelle(ogrenci , ogrenci_id);
		
	}



	@Override
	public void sil(Ogrenci ogrenci , int id) {
	
		IRepository<Ogrenci> ogrenciSil = RepositoryFactory.getOgrenciRepository();
		ogrenciSil.Sil(ogrenci,id);
	}



	@Override
	public List<Ogrenci> Listele(Object o) {

		IRepository<Ogrenci> ogrenciListele = RepositoryFactory.getOgrenciRepository();
		return ogrenciListele.Listele(o);
		
	}

	

	
	
	
	
}
