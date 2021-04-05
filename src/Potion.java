import java.util.ArrayList;

public class Potion extends Item {
    private ArrayList<String> arrAksi = new ArrayList<>();
    private int nilaiEfek;

    // constructor
    public Potion(String nama, String deskripsi, int NE){
        super(nama, deskripsi);
        setNilaiEfek(NE);
        arrAksi.add("Deskripsikan potion");
        arrAksi.add("Pakai potion");

    }

    public int getNilaiEfek() {
        return nilaiEfek;
    }
    public void setNilaiEfek(int nilaiEfek) {
        this.nilaiEfek = nilaiEfek;
    }

    public void printPotion(){
        System.out.print("Potion ini mempunyai nama " + getNama());
        System.out.println(" dan dapat memulikan kesehatan sebesar " + nilaiEfek );
    }

//    public void use(Player objPlayer){
//        objPlayer.setKesehatan(objPlayer.getKesehatan()+nilaiEfek);
//    }

    public void prosesAksi(int subPil){
        if(subPil == 1){
            System.out.println(this.getDeskripsi());
        }else if(subPil == 2){
            getObjGameInfo().getObjPlayer().setKesehatan(getObjGameInfo().getObjPlayer().getKesehatan()+nilaiEfek);

        }
    }
}
