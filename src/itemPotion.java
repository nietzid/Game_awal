public class itemPotion extends Item {
    private int nilaiEfek;

    public int getNilaiEfek() {
        return nilaiEfek;
    }

    public void setNilaiEfek(int nilaiEfek) {
        this.nilaiEfek = nilaiEfek;
    }
    public itemPotion(String nama, String deskripsi, int NE){
        super(nama, deskripsi);
        setNilaiEfek(NE);
    }

    public void printPotion(){
        System.out.print("Potion ini mempunyai nama " + getNama());
        System.out.println(" dan dapat memulikan hp sebesar " + nilaiEfek );
    }

    public void use(Karakter karakter){
        karakter.TastoEquip();
        karakter.setDef(karakter.getHp()+nilaiEfek);
    }

}
