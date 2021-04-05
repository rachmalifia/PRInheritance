import java.util.ArrayList;

public class NPC {
    //kunci dipindahkan dari ruangan
    private Item objKunci;
    private ArrayList<String> arrAksi = new ArrayList<>();
    private GameInfo objGameInfo;
    private boolean isKenal = false;


    // constructor
    public NPC(){
        //init kunci
        objKunci = new Item("Kunci", "Sebuah kunci kecil yang sudah agak berkarat");

        // aksi npc
        arrAksi.add("Perkenalan dengan NPC");
        arrAksi.add("Minta kunci");
    }


    // setter - getter atribut
    public void setObjGameInfo(GameInfo objGameInfo){
        this.objGameInfo = objGameInfo;
        objKunci.setObjGameInfo(objGameInfo);
    }

    public ArrayList<String> getAksi(){
        return arrAksi;
    }

    // method di NPC
    public void prosesAksi(int subPil){
        //1: perkenalan dengan npc
        //2: buka pintu
        if(subPil == 1){
            System.out.println("Halo saya penjaga pintu ini");
            isKenal = true;
        } else if(subPil == 2){
            if(isKenal){
                //berikan kunci pada player
                if(objKunci == null){
                    System.out.println("Masa lupa, kunci kan sudah saya berikan!");
                } else{
                    System.out.println("Kunci diberikan pada player");
                    objGameInfo.getObjPlayer().addItem(objKunci);
                    objKunci = null;
                }
            } else{
                System.out.println("Siapa anda? kenalan dulu dong");
            }
        }
    }
}
