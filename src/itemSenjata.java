public class itemSenjata extends Item{
    private int att;

    public int getAtt() {
        return att;
    }

    public void setAtt(int att) {
        this.att = att;
    }

    public itemSenjata(String nama, String deskripsi, int att){
        super(nama, deskripsi);
        setAtt(att);
    }

    public void printItem(){
        System.out.println("Item ini bernama" + getNama());
        System.out.println(getDeskripsi());
        System.out.println("Senjata ini memiliki kekuatan sebesar " + att);
    }

    public void use(Karakter karakter){
        karakter.TastoEquip();
        karakter.setDef(karakter.getAtt()+att);
    }
}
