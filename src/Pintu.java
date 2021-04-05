import java.util.ArrayList;

public class Pintu extends Item{
    private ArrayList<String> arrAksi = new ArrayList<>();
    private GameInfo objGameInfo;

    //constructor
    public Pintu(String nama, String deskripsi){
        super(nama, deskripsi);
        arrAksi.add("Deskripsikan pintu");
        arrAksi.add("Coba buka pintu");
    }

    // setter - getter atribut
    public void setObjGameInfo(GameInfo objGameInfo){
        this.objGameInfo = objGameInfo;
    }

    public ArrayList<String> getAksi(){
        return arrAksi;
    }


    // method di Pintu
    public void prosesAksi(int subPil){
        if(subPil == 1){
            System.out.println(this.getDeskripsi());
        }else if(subPil == 2){
            // cek apakah mempunyai kunci
            if(objGameInfo.getObjPlayer().cariItem("Kunci"));
            // kunci ada, pintu terbuka
            System.out.println("Player menggunakan kunci untuk membuka pintu dan pintu terbuka!");
            objGameInfo.setGameOver(true); // game over
        } else {
            // kunci tidak ada
            System.out.println("Player mencoba membuka pintu. TERKUNCI!");
        }
    }
}
