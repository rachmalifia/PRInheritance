import java.util.ArrayList;

public class Senjata extends Item{
    private ArrayList<String> arrAksi = new ArrayList<>();
    private int dayaSerang;

    // constructor
    public Senjata(String nama,String deskripsi, int dayaSerang){
        super(nama, deskripsi);
        setDayaSerang(dayaSerang);
        arrAksi.add("Deskripsikan senjata");
        arrAksi.add("Pakai senjata");

    }


    // setter - getter
    public int getDayaSerang() {
        return dayaSerang;
    }
    public void setDayaSerang(int att) {
        this.dayaSerang = att;
    }


    // method di senjata
    public void printItem(){
        System.out.println("Item ini bernama" + getNama());
        System.out.println(getDeskripsi());
        System.out.println("Senjata ini memiliki kekuatan sebesar " + dayaSerang);
    }

//    // saat digunakan oleh player
//    public void use(Player objPlayer){
//        objPlayer.setKekuatan(objPlayer.getKekuatan()+dayaSerang);
//    }

    public void prosesAksi(int subPil){
        if(subPil == 1){
            System.out.println(this.getDeskripsi());
        }else if(subPil == 2){
            getObjGameInfo().getObjPlayer().setKekuatan(getObjGameInfo().getObjPlayer().getKekuatan()+dayaSerang);

        }
    }
}
