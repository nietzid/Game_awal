public class itemArmor extends Item{
    private int def;

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public itemArmor(String nama, String deskripsi, int def){
        super(nama,deskripsi);
        setDef(def);
    }

    public void printItem(){
        System.out.println("Item ini bernama" + getNama());
        System.out.println(getDeskripsi());
        System.out.println("Armor ini memiliki defense power sebesar " + def);
    }

    public void use(Karakter karakter){
        karakter.TastoEquip();
        karakter.setDef(karakter.getDef()+def);
    }
}
