import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Karakter{
    private Item objCincin = new Item("Cincin Emas", "Cincin emas beruliskan suatu kalimat..");
    private Ruangan ruanganAktif;
    private GameInfo objGameinfo;
    private ArrayList<Item> arrItem = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);


    // constructor
    public Player(String nama, int kesehatan, int kekuatan){
        super(nama, kesehatan, kekuatan);
        arrItem = new ArrayList<>();
        arrItem.add(objCincin);
    }


    // setter getter
    public Ruangan getRuanganAktif() {
        return ruanganAktif;
    }
    public void setRuanganAktif(Ruangan ruanganAktif) {
        this.ruanganAktif = ruanganAktif;
    }

    public GameInfo getObjGameinfo() {
        return objGameinfo;
    }
    public void setObjGameinfo(GameInfo objGameinfo) {
        this.objGameinfo = objGameinfo;
    }


    // method yang ada di Player

    // - untuk menambahkan item ke arrItem
    public void addItem(Item objItem){
        arrItem.add(objItem);
    }

    // - untuk mencari item  yang player punya
    public boolean cariItem(String namaItem){
        for(Item objItem:arrItem){
            if(namaItem.equals(objItem.getNama())){
                return (true);
            }
        }
        return (false);
    }

    // - untuk menghapus item di ruangan,
    // digunakan saat player mengambil item dari ruangan
    public void hapusItem(Item objItem){
        arrItem.remove(objItem);
    }

    // - aksi yang bisa dilakukan Player
    public void pilihanAksi(){
        System.out.println("==== Pilihan Aksi pada Player ===");

        int urutPil = 0; // item
        int subPil; // aksinya
        System.out.println("Item yang dimiliki Player");
        for(Item objItem: arrItem){
            urutPil++;
            subPil = 0;
            System.out.println(objItem.getNama());
            ArrayList<String> arrPil = objItem.getAksi();
            // print pilihan
            for(String strPil:arrPil){
                subPil++;
                System.out.printf("%d%d. %s %n", urutPil, subPil, strPil);
            }
        }

        // info seputar player
        urutPil++;
        subPil = 0;
        int pilInfoPlayer = urutPil;
        System.out.println("Info Player");
        // hanya satu
        subPil++;
        System.out.printf("%d%d. Info player%n", urutPil, subPil);


        System.out.print("Pilihan anda?");
        String strPil = sc.next();
        System.out.println("--");

        int pil    =  Integer.parseInt(strPil.substring(0,1)); //ambil digit pertama, asumsikan jumlah tidak lebih dari 10
        subPil     =  Integer.parseInt(strPil.substring(1,2)); //ambil digit kedua, asumsikan jumlah tidak lebih dari 10

        if(pil == pilInfoPlayer){
            printInfo();
        } else{
            Item objItemPilih = arrItem.get(pil-1);
            objItemPilih.prosesAksi(subPil);
        }

    }

    // method serang
    public void serang(Karakter musuh){
        musuh.setKesehatan(musuh.getKesehatan() - getKekuatan());

    }
}
