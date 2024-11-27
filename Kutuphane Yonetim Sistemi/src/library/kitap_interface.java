package library;

// Kitaplar üzerinde yapılacak işlemleri tanımlayan arayüz
public interface kitap_interface {
    
    // Yeni bir kitap ekleme metodu
    public void kitapEkle(Kitap kitap);
    
    // Bir kitabı silme metodu
    public void kitapSil(Kitap kitap);
    
    // Bir kitabı ödünç alma metodu
    public void kitapOduncAl(Kitap kitap);
    
    // Ödünç alınan kitabı geri getirme metodu
    public void kitapGeriGetir(Kitap kitap);
}
