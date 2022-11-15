package Model;

import javax.persistence.*; // java persistence api 'ın package'ı.

@Entity
@Table(name = "ogrenciler")
public class Ogrenci {

	@Id // primary key olmasını sağladı.
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ogrenci_id")
	private int id;

	private String ad;
	private String soyad;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public Ogrenci() {

	}

	public Ogrenci(String ad, String soyad) {
		super();
		this.ad = ad;
		this.soyad = soyad;
	}

}
