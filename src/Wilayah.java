import java.security.PrivateKey;
import java.util.ArrayList;

public class Wilayah {
    private String nama;
    private String deskripsi;
    private String misi;
    private ArrayList<Item> loot = new ArrayList();
    private ArrayList<Karakter> monsterDisini =  new ArrayList();

    public String getMisi() {
        return misi;
    }

    public void setMisi(String misi) {
        this.misi = misi;
    }

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

    public ArrayList<Item> getLoot() {
        return loot;
    }

    public void setLoot(ArrayList<Item> loot) {
        this.loot = loot;
    }

    public ArrayList<Karakter> getMonsterDisini() {
        return monsterDisini;
    }

    public void setMonsterDisini(ArrayList<Karakter> monsterDisini) {
        this.monsterDisini = monsterDisini;
    }

    public Wilayah(String nama, String deskripsi, String misi, ArrayList<Item> loot, ArrayList<Karakter> monster){
        setNama(nama);
        setDeskripsi(deskripsi);
        setMisi(misi);
        setLoot(loot); //item yg ada di wilayah
        setMonsterDisini(monster);
    }

    public void addItem(Item baru){
        loot.add(baru);
    }

    public void removeItem(Item item){
        removeItem(item);
    }

    public void addMonster(Karakter baru){
        monsterDisini.add(baru);
    }

    public void removeMonster(Karakter monster){
        removeMonster(monster);
    }

    public void printWilayah(){
        System.out.println("Wilayah ini bernama " + nama);
        System.out.println(deskripsi);
    }


}
