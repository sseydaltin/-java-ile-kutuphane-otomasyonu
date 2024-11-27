package library;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Üye sınıfı
    static class Uye {
        private int uyeNo;  // Üye numarası
        private String kullanıcıAdı;
        private String şifre;
        private String ad;
        private String soyad;

        private static ArrayList<Uye> uyeListesi = new ArrayList<>();
        private static int uyeSayisi = 1; // Üye numarasının sırasıyla artması için

        public Uye(int uyeNo, String kullanıcıAdı, String şifre, String ad, String soyad) {
            this.uyeNo = uyeNo;
            this.kullanıcıAdı = kullanıcıAdı;
            this.şifre = şifre;
            this.ad = ad;
            this.soyad = soyad;
        }

        public int getUyeNo() {
            return uyeNo;
        }

        public String getKullanıcıAdı() {
            return kullanıcıAdı;
        }

        public String getŞifre() {
            return şifre;
        }

        public String getAd() {
            return ad;
        }

        public String getSoyad() {
            return soyad;
        }

        // Yeni üye ekleme
        public static void uyeEkle(Uye uye) {
            uyeListesi.add(uye);
        }

        // Üyeleri listeleme
        public static void uyeListele() {
            if (uyeListesi.isEmpty()) {
                System.out.println("Henüz üye bulunmamaktadır.");
            } else {
                System.out.println("Üye Listesi:");
                for (Uye uye : uyeListesi) {
                    System.out.println("Üye No: " + uye.getUyeNo() + ", Kullanıcı Adı: " + uye.getKullanıcıAdı() + ", Ad: " + uye.getAd() + ", Soyad: " + uye.getSoyad());
                }
            }
        }

        // Üye arama
        public static Uye uyeAra(int uyeNo) {
            for (Uye uye : uyeListesi) {
                if (uye.getUyeNo() == uyeNo) {
                    return uye;
                }
            }
            return null;  // Eğer üye bulunmazsa
        }

        // Üye silme
        public static boolean uyeSil(int uyeNo) {
            Uye uye = uyeAra(uyeNo);
            if (uye != null) {
                uyeListesi.remove(uye);
                return true;
            }
            return false;
        }

        // Giriş kontrolü
        public static boolean girisYap(String kullanıcıAdı, String şifre) {
            for (Uye uye : uyeListesi) {
                if (uye.getKullanıcıAdı().equals(kullanıcıAdı) && uye.getŞifre().equals(şifre)) {
                    return true;
                }
            }
            return false;
        }

        // Üye numarası atama
        public static int yeniUyeNo() {
            return uyeSayisi++;
        }
    }

    // Kitap sınıfı
    static class Kitap {
        private String ad;
        private String yazar;
        private int sayfaSayisi;
        private String basimTarihi;
        private String tur;
        private boolean bilimselMi;
        private boolean oduncAlindi;

        private static ArrayList<Kitap> kitapListesi = new ArrayList<>();

        public Kitap(String ad, String yazar, int sayfaSayisi, String basimTarihi, String tur, boolean bilimselMi) {
            this.ad = ad;
            this.yazar = yazar;
            this.sayfaSayisi = sayfaSayisi;
            this.basimTarihi = basimTarihi;
            this.tur = tur;
            this.bilimselMi = bilimselMi;
            this.oduncAlindi = false;
        }

        public static void kitapEkle(Kitap kitap) {
            kitapListesi.add(kitap);
        }

        public static boolean kitapSil(int index) {
            if (index >= 0 && index < kitapListesi.size()) {
                kitapListesi.remove(index);
                return true;
            }
            return false;
        }

        public static void listeleKitaplar() {
            if (kitapListesi.isEmpty()) {
                System.out.println("Kitap bulunmamaktadır.");
            } else {
                System.out.println("\n--- Kitaplar ---");
                for (int i = 0; i < kitapListesi.size(); i++) {
                    Kitap kitap = kitapListesi.get(i);
                    System.out.println((i + 1) + ". " + kitap.ad + " - Yazar: " + kitap.yazar + 
                        "\n   Sayfa Sayısı: " + kitap.sayfaSayisi + 
                        "\n   Basım Yılı: " + kitap.basimTarihi + 
                        "\n   Tür: " + kitap.tur + 
                        "\n   Bilimsel: " + (kitap.bilimselMi ? "Evet" : "Hayır") + 
                        "\n   Durum: " + (kitap.oduncAlindi ? "Ödünç Alındı" : "Mevcut"));
                }
            }
        }

        // Kitap ödünç alma
        public void oduncAl() {
            this.oduncAlindi = true;
        }

        // Kitap iade etme
        public void iadeEt() {
            this.oduncAlindi = false;
        }

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

    // Ana metod
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Başlangıçta birkaç üye ve kitap ekliyoruz
        Uye.uyeEkle(new Uye(Uye.yeniUyeNo(), "seyda", "1234", "Seyda", "Altin"));
        Uye.uyeEkle(new Uye(Uye.yeniUyeNo(), "ayse", "5678", "Ayşe", "Kaya"));
        Uye.uyeEkle(new Uye(Uye.yeniUyeNo(), "mehmet", "abcd", "Mehmet", "Çelik"));

        Kitap.kitapEkle(new Kitap("Java Programlama", "John Doe", 350, "2020", "Programlama", true));
        Kitap.kitapEkle(new Kitap("Python 101", "Jane Smith", 280, "2021", "Programlama", false));
        Kitap.kitapEkle(new Kitap("Savaş ve Barış", "Tolstoy", 1200, "1869", "Roman", false));

        // Kullanıcı girişi
        if (uyeGiris(scanner)) {
            // Eğer giriş başarılıysa ana menüye geç
            anaMenu(scanner);
        } else {
            System.out.println("Giriş başarısız! Programdan çıkılıyor.");
        }
    }

    // Kullanıcı girişi yapmak için metot
    public static boolean uyeGiris(Scanner scanner) {
        System.out.println("\n--- Üye Girişi ---");
        System.out.print("Kullanıcı Adı: ");
        String kullanıcıAdı = scanner.nextLine();
        System.out.print("Şifre: ");
        String şifre = scanner.nextLine();

        if (Uye.girisYap(kullanıcıAdı, şifre)) {
            System.out.println("Giriş başarılı.");
            return true;
        } else {
            System.out.println("Kullanıcı adı veya şifre hatalı.");
            return false;
        }
    }

    public static void anaMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Ana Menü ---");
            System.out.println("1. Kitap İşlemleri");
            System.out.println("2. Üye İşlemleri");
            System.out.println("3. Çıkış");
            System.out.print("Seçiminiz: ");
            int secim = scanner.nextInt();
            scanner.nextLine();  // Buffer temizleme

            switch (secim) {
                case 1:
                    kitapMenu(scanner);
                    break;
                case 2:
                    uyeMenu(scanner);
                    break;
                case 3:
                    System.out.println("Programdan çıkılıyor.");
                    return;
                default:
                    System.out.println("Geçersiz seçim! Lütfen tekrar deneyiniz.");
            }
        }
    }

    // Kitap işlemleri ile ilgili metotlar
    public static void kitapMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Kitap İşlemleri ---");
            System.out.println("1. Kitap Listele");
            System.out.println("2. Kitap Ekle");
            System.out.println("3. Kitap Sil");
            System.out.println("4. Kitap Ödünç Al");
            System.out.println("5. Kitap İade Et");
            System.out.println("6. Geri Dön");
            System.out.print("Seçiminiz: ");
            int secim = scanner.nextInt();
            scanner.nextLine();  // Buffer temizleme

            switch (secim) {
                case 1:
                    Kitap.listeleKitaplar();
                    break;
                case 2:
                    kitapEkle(scanner);
                    break;
                case 3:
                    kitapSil(scanner);
                    break;
                case 4:
                    kitapOduncAl(scanner);
                    break;
                case 5:
                    kitapIadeEt(scanner);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Geçersiz seçim! Lütfen tekrar deneyiniz.");
            }
        }
    }

    // Üye işlemleri ile ilgili metotlar
    public static void uyeMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Üye İşlemleri ---");
            System.out.println("1. Üye Listele");
            System.out.println("2. Üye Ekle");
            System.out.println("3. Üye Sil");
            System.out.println("4. Geri Dön");
            System.out.print("Seçiminiz: ");
            int secim = scanner.nextInt();
            scanner.nextLine();  // Buffer temizleme

            switch (secim) {
                case 1:
                    Uye.uyeListele();
                    break;
                case 2:
                    uyeEkle(scanner);
                    break;
                case 3:
                    uyeSil(scanner);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Geçersiz seçim! Lütfen tekrar deneyiniz.");
            }
        }
    }

    // Üye ekleme
    public static void uyeEkle(Scanner scanner) {
        System.out.print("Kullanıcı Adı: ");
        String kullanıcıAdı = scanner.nextLine();
        System.out.print("Şifre: ");
        String şifre = scanner.nextLine();
        System.out.print("Ad: ");
        String ad = scanner.nextLine();
        System.out.print("Soyad: ");
        String soyad = scanner.nextLine();

        Uye.uyeEkle(new Uye(Uye.yeniUyeNo(), kullanıcıAdı, şifre, ad, soyad));
        System.out.println("Üye başarıyla eklendi.");
    }

    // Üye silme
    public static void uyeSil(Scanner scanner) {
        System.out.print("Silmek istediğiniz üye numarasını girin: ");
        int uyeNo = scanner.nextInt();

        if (Uye.uyeSil(uyeNo)) {
            System.out.println("Üye başarıyla silindi.");
        } else {
            System.out.println("Geçersiz üye numarası!");
        }
    }

    // Kitap ekleme
    public static void kitapEkle(Scanner scanner) {
        System.out.print("Kitap Adı: ");
        String ad = scanner.nextLine();
        System.out.print("Yazar: ");
        String yazar = scanner.nextLine();
        System.out.print("Sayfa Sayısı: ");
        int sayfaSayisi = scanner.nextInt();
        scanner.nextLine();  // Buffer temizleme
        System.out.print("Basım Yılı: ");
        String basimTarihi = scanner.nextLine();
        System.out.print("Tür: ");
        String tur = scanner.nextLine();
        System.out.print("Bilimsel mi? (true/false): ");
        boolean bilimselMi = scanner.nextBoolean();
        scanner.nextLine();  // Buffer temizleme

        Kitap.kitapEkle(new Kitap(ad, yazar, sayfaSayisi, basimTarihi, tur, bilimselMi));
        System.out.println("Kitap başarıyla eklendi.");
    }

    // Kitap silme
    public static void kitapSil(Scanner scanner) {
        Kitap.listeleKitaplar();
        System.out.print("Silmek istediğiniz kitap numarasını girin: ");
        int index = scanner.nextInt() - 1;

        if (Kitap.kitapSil(index)) {
            System.out.println("Kitap başarıyla silindi.");
        } else {
            System.out.println("Geçersiz kitap numarası!");
        }
    }

    // Kitap ödünç alma
    public static void kitapOduncAl(Scanner scanner) {
        Kitap.listeleKitaplar();
        System.out.print("Ödünç almak istediğiniz kitap numarasını girin: ");
        int index = scanner.nextInt() - 1;

        ArrayList<Kitap> kitaplar = Kitap.getKitapListesi();
        if (index >= 0 && index < kitaplar.size()) {
            Kitap kitap = kitaplar.get(index);
            if (!kitap.isOduncAlindi()) {
                kitap.oduncAl();
                System.out.println("Kitap ödünç alındı: " + kitap.getAd());
            } else {
                System.out.println("Bu kitap zaten ödünç alındı.");
            }
        } else {
            System.out.println("Geçersiz kitap numarası.");
        }
    }

    // Kitap iade etme
    public static void kitapIadeEt(Scanner scanner) {
        Kitap.listeleKitaplar();
        System.out.print("İade etmek istediğiniz kitap numarasını girin: ");
        int index = scanner.nextInt() - 1;

        ArrayList<Kitap> kitaplar = Kitap.getKitapListesi();
        if (index >= 0 && index < kitaplar.size()) {
            Kitap kitap = kitaplar.get(index);
            if (kitap.isOduncAlindi()) {
                kitap.iadeEt();
                System.out.println("Kitap başarıyla iade edildi: " + kitap.getAd());
            } else {
                System.out.println("Bu kitap zaten iade edilmiş.");
            }
        } else {
            System.out.println("Geçersiz kitap numarası.");
        }
    }
}