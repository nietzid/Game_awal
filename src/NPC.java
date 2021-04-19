import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class NPC {
    private String nama;
    private Wilayah wilAktif;
    private ArrayList<Item> loot = new ArrayList();
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Wilayah getWilAktif() {
        return wilAktif;
    }

    public void setWilAktif(Wilayah wilAktif) {
        this.wilAktif = wilAktif;
    }

    public ArrayList<Item> getLoot() {
        return loot;
    }

    public void setLoot(ArrayList<Item> loot) {
        this.loot = loot;
    }

    public static void cls() {
        for (int i = 0; i < 50; ++i) System.out.print("-");
        System.out.println();
    }

    public NPC(String nama, Wilayah wilAktif, ArrayList<Item> loot){
        setNama(nama);
        setWilAktif(wilAktif);
        setLoot(loot);
    }

    public void interaksi(Karakter karakter, Wilayah wilayah){
        System.out.println("Halo, " + karakter.getNama() + "!");
        System.out.println("Selamat datang di " + wilAktif.getNama());
        System.out.println(wilAktif.getDeskripsi());
        setWilAktif(wilayah);
        while(wilAktif.getMonsterDisini().size()!=0) {
            System.out.println("[1] Apa yang harus saya lakukan disini?\n" +
                    "[2] Dapatkan item pembantu \n" +
                    "[3] Lawan musuh");
            System.out.print("Pilih : ");
            int menu = scanner.nextInt();
            cls();
            switch (menu) {
                case 1:
                    System.out.println("Misi kamu disini adalah " + wilAktif.getMisi());
                    break;
                case 2:
                    System.out.println("Berikut bekal dari saya untuk anda, sang petualang yang pemberani");
                    for (Item i : getLoot()) {
                        System.out.println("Selamat kamu mendapatkan " + i.getNama());
                        karakter.addItem(i);
                        this.loot.remove(i);
                    }
                    break;
                case 3:
                    int ran = random.nextInt(wilAktif.getMonsterDisini().size());
                    System.out.println("Kamu akan melawan " + wilAktif.getMonsterDisini().get(ran).getNama() );
                    karakter.BattleSystem(wilAktif.getMonsterDisini().get(ran), wilAktif);
            }
        }
        if(wilAktif.getMonsterDisini().size()==0){
            System.out.println("Selamat kamu telah melawan seluruh monster disini!");
            for (int i = 0; i < wilAktif.getLoot().size(); i++) {
                System.out.println("Selamat kamu mendapatkan " + wilAktif.getLoot().get(i).getNama());
                karakter.addItem(wilAktif.getLoot().get(i));
                wilAktif.getLoot().remove(wilAktif.getLoot().get(i));
            }
            System.out.println("Kamu telah menyelesaikan wilayah ini! Silahkan lanjut ke wilayah selanjutnya!");
        }
    }
}