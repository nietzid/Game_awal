import java.util.ArrayList;
import java.util.Scanner;

public class Karakter {
    Scanner scanner = new Scanner(System.in);
    private String nama;
    private String deskripsi;
    private int hp;
    private int def;
    private int att;
    private int level;
    private int exp;
    ArrayList<Item> tas = new ArrayList<>();
    ArrayList<Item> perlengkapan = new ArrayList<>();
    private int slot = perlengkapan.size();

    public int getAtt() {
        return att;
    }

    public void setAtt(int att) {
        this.att = att;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public ArrayList<Item> getTas() {
        return tas;
    }

    public void setTas(ArrayList<Item> tas) {
        this.tas = tas;
    }

    public ArrayList<Item> getPerlengkapan() {
        return perlengkapan;
    }

    public void setPerlengkapan(ArrayList<Item> perlengkapan) {
        this.perlengkapan = perlengkapan;
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

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void serang(Karakter karakter) {
        karakter.hp -= att-karakter.def;
    }

    public void addItem(Item item) {
        tas.add(item);
    }

    public void removeItem(Item item) {
        tas.remove(item);
    }

    public Karakter(String nama, String deskripsi, int hp, int def, int att, int exp, int level, ArrayList<Item> tas, ArrayList<Item> perlengkapan){
        setNama(nama);
        setDeskripsi(deskripsi);
        setHp(hp);
        setDef(def);
        setAtt(att);
        setExp(exp);
        setLevel(level);
        setTas(tas);
        setPerlengkapan(perlengkapan);
    }

    public void pungutItem(Item item, Wilayah wilayah){
        boolean isFind = false;
        for (int i = 0; i < wilayah.getLoot().size(); i++){
            if ( wilayah.getLoot().get(i).equals(item)){
                wilayah.removeItem(item);
                tas.add(item);
                isFind = true;
            }
        }
        if (!isFind){
            System.out.println("Item tidak ada!");
        }
    }

    public void dropItem(Item item, Wilayah wilayah){
        boolean isFind = false;
        for (int i = 0; i < tas.size(); i++){
            if ( tas.get(i).equals(item)){
                wilayah.addItem(item);
                tas.remove(item);
                isFind = true;
            }
        }
        if (!isFind){
            for (int i = 0; i < perlengkapan.size(); i++){
                if ( perlengkapan.get(i).equals(item)){
                    wilayah.addItem(item);
                    perlengkapan.remove(item);
                    isFind = true;
                }
            }
        }
        if (!isFind){
            System.out.println("Item tidak ada!");
        }
    }
    public void TastoEquip(){
        if (4-slot >0 ) {
            System.out.println("Pilih item yang akan digunakan (Slot tersisa saat ini " + (4 - slot) + " )");
            for (int i = 0; i < getTas().size(); i++) {
                System.out.println("[" + (i + 1) + "] " + getTas().get(i).getNama());
            }
            System.out.print("Pilih item : ");
            int temp = scanner.nextInt();
            perlengkapan.add(tas.get(temp - 1));
            tas.remove(temp - 1);
        } else System.out.println("Slot Equipment Penuh");
    }

    public void EquiptoTas(){
        System.out.println("Pilih item yang akan disimpan :");
        for (int i = 0; i<tas.size(); i++){
            System.out.println("[" + (i+1) + "] " + tas.get(i).getNama());
        }
        System.out.print("Pilih item : ");
        int temp = scanner.nextInt();
        tas.add(perlengkapan.get(temp-1));
        perlengkapan.remove(temp-1);
    }

    public void BattleSystem(Karakter bot,Wilayah wilayah){
        while (this.getHp() >= 0 && bot.getHp() >=0){
            bot.serang(this);
            int temp = move();
            switch (temp){
                case 1:
                    this.serang(bot);
                    break;
                case 2:
                    this.TastoEquip();
                    break;
            }
        }
        if(bot.getHp() <=0){
            setExp(getExp() + bot.getExp());
//            tas.addAll(bot.tas);
//            System.out.println("ini sizenya" + wilayah.getLoot().size());
//            perlengkapan.addAll(bot.perlengkapan);
            wilayah.getMonsterDisini().remove(bot);
        }
    }

    public int move() {
        Scanner scanner = new Scanner(System.in);
        int temp;
        System.out.println("Pilih langkah :");
        System.out.println("[1] Serang");
        System.out.println("[2] Ganti/Gunakan senjata");
        System.out.print("Pilih :");
        temp = scanner.nextInt();
        return temp;
    }
}