import java.util.ArrayList;
import java.util.Scanner;

public class GameEngine {
    public static void main(String[] args) {
        Wilayah wilayahAktif;
        //Buat player
        ArrayList<Item> lootp = new ArrayList<>();
        Item pedang = new itemSenjata("Pedang kayu", "Sebuah pedang untuk pemula", 200);
        lootp.add(pedang);
        Karakter player = new Karakter("Arfi", "manusia", 1000, 500, 400, 50, 1, lootp, lootp);

        //Buat wilayah
        ArrayList<Item> loot = new ArrayList<>();
        Item Fragment1 = new Item("Fragment 1", "Sebuah bagian senjata yang dapat memusnahkan raja iblis");
        loot.add(Fragment1);

        ArrayList<Karakter> monster = new ArrayList<>();
        Karakter monsterA = new Karakter("Goblin", "Monster yang berwarna hijau dan tidak biru", 150, 30, 75, 250, 2, loot, loot);
        monster.add(monsterA);

        Wilayah pemukiman = new Wilayah("Pemukiman", "Wilayah pemukiman warga Katara yang gelap gulita, hanya terdapat beberapa gubuk tak berpenghuni.", "Mebunuh monster", loot, monster);

        //Buat NPC
        ArrayList<Item> lootnpc = new ArrayList<>();
        Item kunci = new Item("Kunci", "Sebuah kunci");
        Item pedang1 = new itemSenjata("Pedang kayu", "Sebuah pedang untuk pemula", 200);
        lootnpc.add(kunci);
        lootnpc.add(pedang);
        //UI
        wilayahAktif=pemukiman;
        NPC wargaWil1 = new NPC("Supri", wilayahAktif, lootnpc);
        wargaWil1.interaksi(player,wilayahAktif);
        System.out.println("ok");
    }
}

