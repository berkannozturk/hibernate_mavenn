package Repository;

import java.util.List;

import Model.Ogrenci;

public interface IRepository<T> {

	void Kaydet(T t);

	void Guncelle(Ogrenci ogrenci, int ogrenciId);

	List<Ogrenci> Listele(Object o);

	void Sil(Ogrenci ogrenci, int id);

}
