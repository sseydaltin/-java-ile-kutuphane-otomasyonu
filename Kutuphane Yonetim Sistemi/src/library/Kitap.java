package library;

import java.util.ArrayList;

public class Kitap {
    private String ad;
    private String yazar;
    private int sayfaSayisi;
    private String basimTarihi;
    private String tur;
    private boolean bilimselMi;
    private boolean oduncAlindi;  // Kitap ödünç alındı mı?

    private static ArrayList<Kitap> kitapListesi = new ArrayList<>();

    // Constructor
    public Kitap(String ad, String yazar, int sayfaSayisi, String basimTarihi, String tur, boolean bilimselMi) {
        this.ad = ad;
        this.yazar = yazar;
        this.sayfaSayisi = sayfaSayisi;
        this.basimTarihi = basimTarihi;
        this.tur = tur;
        this.bilimselMi = bilimselMi;
        this.oduncAlindi = false;  // Başlangıçta kitap ödünç alınmış değildir
    }

    // Kitap ekleme işlemi
    public static void kitapEkle(Kitap kitap) {
        kitapListesi.add(kitap);
    }

    // Kitap silme işlemi, başarılı olursa true döner
    public static boolean kitapSil(int index) {
        if (index >= 0 && index < kitapListesi.size()) {
            kitapListesi.remove(index);
            return true;
        }
        return false;
    }

    // Kitapları listeleme işlemi
    public static void listeleKitaplar() {
        if (kitapListesi.isEmpty()) {
            System.out.println("Kitap bulunmamaktadır."); // Liste boşsa bilgi verir
        } else {
            System.out.println("Kitaplar:");
            for (int i = 0; i < kitapListesi.size(); i++) {
                Kitap kitap = kitapListesi.get(i);
                System.out.println((i + 1) + ". " + kitap.getAd() + " - " + (kitap.isOduncAlindi() ? "Ödünç Alındı" : "Mevcut")); // Kitap bilgilerini yazdırır
            }
        }
    }

    // Kitap ödünç alma işlemi
    public void oduncAl() {
        this.oduncAlindi = true;
    }

    // Kitap iade etme işlemi
    public void iadeEt() {
        this.oduncAlindi = false;
    }

    // Getter ve Setter metotlar
    public String getAd() {
        return ad;
    }

    public boolean isOduncAlindi() {
        return oduncAlindi;
    }

    public static ArrayList<Kitap> getKitapListesi() {
        return kitapListesi;
    }
}
