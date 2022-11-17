package Business;

import java.util.List;

import Model.Ogrenci;

public interface IBusiness<T> {

	void ekle(T t);

	void guncelle(Ogrenci ogrenci, int ogrenci_id);

	List<Ogrenci> Listele(Object o);

	void sil(Ogrenci ogrenci ,int id);

}
