import java.util.ArrayList;
import java.util.Scanner;

public class Ruangan {
    private Pintu objPintu;
    private NPC objNPC;
    private String deskripsi;
    private Item objRoti;
    private Karakter musuh;
    private Senjata objSenjata;
    private Potion objPotion;
    private GameInfo objGameInfo;
    private ArrayList<Item> arrItem = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);


    // constructor Ruangan
    public Ruangan(){
        // init
        objNPC = new NPC();
        objPintu =  new Pintu("Pintu", "Pintu berwarna merah dengan tulisan 'EXIT' di atas");
        objRoti = new Item("Roti", "Roti rasa coklat dalam bungkusan plastik");
        objSenjata = new Senjata("Pedang", "Pedang digunakan untuk menebas musuh", 25);
        objPotion = new Potion("Polyjuice", "Polyjuice dapat menambah kesehatan", 10);
        musuh = new Karakter("Kurtet", 100, 10);
        objRoti.setObjRuangan(this);


        // tambah item ke array
        arrItem.add(objRoti);
        arrItem.add(objPintu);
        arrItem.add(objSenjata);
        arrItem.add(objPotion);
    }


    // getter setter
    public String getDeskripsi(){
        return deskripsi;
    }
    public void setDeskripsi(String deskripsi){
        this.deskripsi = deskripsi;
    }


    // objGame juga diset pada pintu dan item2
    public void setObjGameInfo(GameInfo objGameInfo){
        this.objGameInfo = objGameInfo;
//        objPintu.
    }


    // method di Ruangan

    // -untuk menghapus item di ruangan
    public void hapusItem(Item objItem){
        arrItem.remove(objItem); // buang item
    }

    // -untuk menambahkan item
    public void addItem(Item objItem){
        arrItem.add(objItem);
    }



    public void bertanding(){
        System.out.println("Mulai bertanding");
        while(true){
            System.out.println("\nPlayer menyerang");
            objGameInfo.getObjPlayer().serang(musuh);
            objGameInfo.getObjPlayer().printInfo();
            if(objGameInfo.getObjPlayer().getKesehatan()<=0){
                break;
            }
            System.out.println("\nMusuh menyerang");
            musuh.serang(objGameInfo.getObjPlayer());
            musuh.printInfo();
            if(musuh.getKesehatan()<=0){
                break;
            }
        }
        if(musuh.getKesehatan()<=0){
            System.out.println("Player menang");
        }else{
            System.out.println("Musuh menang");
        }
    }

    // - aksi di ruangan
    public void pilihanAksi(){
        System.out.println("==== Pilihan Aksi pada Ruangan ====");
        int urutPil = 0;
        int subPil;

        // aksi item
        System.out.println("Item di ruangan");
        for(Item objItem:arrItem){
            urutPil++;
            subPil = 0;
            System.out.println(objItem.getNama());
            // ambil pilihannya
            ArrayList<String> arrPil = objItem.getAksi();
            //print pilihan
            for (String strPil:arrPil){
                subPil++;
                System.out.printf("%d%d. %s %n", urutPil, subPil, strPil);
            }
        }

        // aksi NPC
        urutPil++;
        subPil = 0;
        int pilNPC = urutPil; // catat untuk npc
        System.out.println("NPC");
        for(String strPil: objNPC.getAksi()){
            subPil++;
            System.out.printf("%d%d. %s %n", urutPil, subPil, strPil);
        }


        System.out.print("Pilihan Anda? ");
        String strPil = sc.next();
        System.out.println("--");

        // split pilihan dan subpilihan
        int pil = Integer.parseInt(strPil.substring(0,1)); // ambil digit pertama, asumsikan jumlah tidak lebih dari 10
        subPil = Integer.parseInt(strPil.substring(1,2)); // ambil digit kedua, asumsikan jumlah tidak lebih dari 10

        if(pil == pilNPC){
            objNPC.prosesAksi(subPil);
        }
        else{
            //item
            Item objItemPilih = arrItem.get(pil-1);
            if(arrItem.get(pil-1).getNama().equals("Pintu")){
                objPintu.prosesAksi(subPil);
            } else if(arrItem.get(pil-1).getNama().equals("Pedang")){
                objSenjata.prosesAksi(subPil);
            } else if(arrItem.get(pil-1).getNama().equals("Polyjuice")){
                objPotion.prosesAksi(subPil);
            }
            else{
                objItemPilih.prosesAksi(subPil); //aksi item
            }
        }
    }


}
