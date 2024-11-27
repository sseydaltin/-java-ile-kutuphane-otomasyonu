package library;

import java.util.ArrayList;

public class Uye {
    private String kullaniciAdi;
    private String sifre;
    private String ad;
    private String soyad;
    private int id;
    private static int idCounter = 1;

    // Statik üye listesi
    private static ArrayList<Uye> uyeListesi = new ArrayList<>();

    // Constructor
    public Uye(String kullaniciAdi, String sifre, String ad, String soyad) {
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
        this.ad = ad;
        this.soyad = soyad;
        this.id = idCounter++;
    }

    // Getter ve Setter metotlar
    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public String getSifre() {
        return sifre;
    }

    public String getAd() {
        return ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public int getId() {
        return id;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    // Üye giriş işlemi, başarılı ise true döner
    public static boolean uyeGirisi(String kullaniciAdi, String sifre) {
        for (Uye uye : uyeListesi) {
            if (uye.kullaniciAdi.equals(kullaniciAdi) && uye.sifre.equals(sifre)) {
                return true; // Giriş başarılı
            }
        }
        return false; // Giriş başarısız
    }

    // Yeni üye ekleme işlemi
    public static void uyeEkle(Uye uye) {
        uyeListesi.add(uye);
    }

    // Üye silme işlemi, başarılı ise true döner
    public static boolean uyeSil(String kullaniciAdi) {
        for (Uye uye : uyeListesi) {
            if (uye.kullaniciAdi.equals(kullaniciAdi)) {
                uyeListesi.remove(uye);
                return true; // Üye başarıyla silindi
            }
        }
        return false; // Üye bulunamadı
    }

    // Üye bilgilerini güncelleme işlemi, başarılı ise true döner
    public static boolean uyeGuncelle(String kullaniciAdi, String yeniAd, String yeniSoyad, String yeniSifre) {
        for (Uye uye : uyeListesi) {
            if (uye.kullaniciAdi.equals(kullaniciAdi)) {
                uye.setAd(yeniAd);
                uye.setSoyad(yeniSoyad);
                uye.setSifre(yeniSifre);
                return true; // Bilgiler güncellendi
            }
        }
        return false; // Üye bulunamadı
    }

    // Üye listesini döner
    public static ArrayList<Uye> getUyeListesi() {
        return uyeListesi;
    }

    // Üye bilgilerini string olarak döner
    @Override
    public String toString() {
        return "ID: " + id + ", Kullanıcı Adı: " + kullaniciAdi + ", Ad Soyad: " + ad + " " + soyad;
    }
}
