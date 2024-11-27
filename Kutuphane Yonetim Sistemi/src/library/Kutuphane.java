package library;

public class Kutuphane {

    // ID sayacı, her kitap eklendiğinde otomatik olarak artar
    private static int ID_counter = 0;
    private int ID;
    private String kitapIsim;
    private String yazar;
    private int sayfaSayisi;
    private String basimTarihi;

    // Yapıcı metot, yeni bir kitap nesnesi oluşturur
    public Kutuphane(String kitapIsim, String yazar, int sayfaSayisi, String basimTarihi) {
        this.kitapIsim = kitapIsim;
        this.yazar = yazar;
        this.sayfaSayisi = sayfaSayisi;
        this.basimTarihi = basimTarihi;
        ID_counter++;
        this.ID = ID_counter;
    }

    // Getter ve Setter metodları, özel alanlara erişimi sağlar
    public int getID() {
        return ID;
    }

    public String getKitapIsim() {
        return kitapIsim;
    }

    public void setKitapIsim(String kitapIsim) {
        this.kitapIsim = kitapIsim;
    }

    public String getYazar() {
        return yazar;
    }

    public void setYazar(String yazar) {
        this.yazar = yazar;
    }

    public int getSayfaSayisi() {
        return sayfaSayisi;
    }

    public void setSayfaSayisi(int sayfaSayisi) {
        this.sayfaSayisi = sayfaSayisi;
    }

    public String getBasimTarihi() {
        return basimTarihi;
    }

    public void setBasimTarihi(String basimTarihi) {
        this.basimTarihi = basimTarihi;
    }

    // Kitap bilgilerini döndürür
    public String bilgileri_getir(String kitapBilgi) {
        return kitapBilgi;
    }
}
