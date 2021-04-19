public class Item {
    private String nama;
    private String deskripsi;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Item(String nama, String deskripsi){
        setNama(nama);
        setDeskripsi(deskripsi);
    }

    public void printItem(){
        System.out.println("Item ini bernama" + nama);
        System.out.println(deskripsi);
    }

    public void use(Karakter karakter){
        karakter.TastoEquip();
    }
}
