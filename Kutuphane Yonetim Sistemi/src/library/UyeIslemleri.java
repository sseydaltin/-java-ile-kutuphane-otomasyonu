package library;

import java.util.ArrayList;
import java.util.Scanner;

public class UyeIslemleri {
    // Üye listesini statik olarak alır
    private static ArrayList<Uye> uyeListesi = Uye.getUyeListesi();

    // Üye ekleme işlemi
    public static void uyeEkle(String kullaniciAdi, String sifre, String ad, String soyad) {
        Uye yeniUye = new Uye(kullaniciAdi, sifre, ad, soyad);
        uyeListesi.add(yeniUye); // Yeni üyeyi listeye ekler
        System.out.println("Üye başarıyla eklendi: " + yeniUye);
    }

    // Üye listeleme işlemi
    public static void uyeListele() {
        if (uyeListesi.isEmpty()) {
            System.out.println("Üye bulunmamaktadır."); // Liste boşsa bilgi verir
        } else {
            System.out.println("Üyeler:");
            for (Uye uye : uyeListesi) {
                System.out.println(uye); // Her bir üyeyi yazdırır
            }
        }
    }

    // Üye arama işlemi
    public static void uyeAra(String kullaniciAdi) {
        for (Uye uye : uyeListesi) {
            if (uye.getKullaniciAdi().equals(kullaniciAdi)) {
                System.out.println("Üye bulundu: " + uye); // Üye bulunursa bilgi verir
                return;
            }
        }
        System.out.println("Üye bulunamadı."); // Üye bulunamazsa bilgi verir
    }

    // Üye silme işlemi
    public static void uyeSil(String kullaniciAdi) {
        for (Uye uye : uyeListesi) {
            if (uye.getKullaniciAdi().equals(kullaniciAdi)) {
                uyeListesi.remove(uye); // Üyeyi listeden siler
                System.out.println("Üye başarıyla silindi.");
                return;
            }
        }
        System.out.println("Üye bulunamadı."); // Üye bulunamazsa bilgi verir
    }

    // Konsol üzerinden üye işlemleri menüsü
    public static void konsolMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Üye İşlemleri ---");
            System.out.println("1. Yeni Üye Ekle");
            System.out.println("2. Üyeleri Listele");
            System.out.println("3. Üye Ara");
            System.out.println("4. Üye Sil");
            System.out.println("5. Çıkış");
            System.out.print("Seçiminiz: ");
            int secim = scanner.nextInt();
            scanner.nextLine(); // Buffer temizleme

            switch (secim) {
                case 1:
                    System.out.print("Kullanıcı adı: ");
                    String kullaniciAdi = scanner.nextLine();
                    System.out.print("Şifre: ");
                    String sifre = scanner.nextLine();
                    System.out.print("Ad: ");
                    String ad = scanner.nextLine();
                    System.out.print("Soyad: ");
                    String soyad = scanner.nextLine();
                    uyeEkle(kullaniciAdi, sifre, ad, soyad); // Yeni üye ekler
                    break;
                case 2:
                    uyeListele(); // Üyeleri listeler
                    break;
                case 3:
                    System.out.print("Aramak istediğiniz kullanıcının adını giriniz: ");
                    String araKullaniciAdi = scanner.nextLine();
                    uyeAra(araKullaniciAdi); // Üye arar
                    break;
                case 4:
                    System.out.print("Silmek istediğiniz kullanıcının adını giriniz: ");
                    String silKullaniciAdi = scanner.nextLine();
                    uyeSil(silKullaniciAdi); // Üye siler
                    break;
                case 5:
                    System.out.println("Üye işlemlerinden çıkılıyor."); // Menüyü sonlandırır
                    return;
                default:
                    System.out.println("Geçersiz seçim! Lütfen tekrar deneyiniz."); // Geçersiz seçim uyarısı
            }
        }
    }
}
