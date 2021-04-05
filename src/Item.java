import java.util.ArrayList;

public class Item {
    private String nama;
    private String deskripsi;
    private Ruangan objRuangan; // ruangan tempat item itu ada
    private ArrayList<String> arrAksi = new ArrayList<>();
    private GameInfo objGameInfo;
    private Pintu objPintu;

    // constructor
    public Item(String nama, String deskripsi){
        this.nama = nama;
        this.deskripsi = deskripsi;
    }



    // getter setter atribut
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }
    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Ruangan getObjRuangan() {
        return objRuangan;
    }
    public void setObjRuangan(Ruangan objRuangan) {
        this.objRuangan = objRuangan;
    }

    public GameInfo getObjGameInfo() {
        return objGameInfo;
    }
    public void setObjGameInfo(GameInfo objGameInfo) {
        this.objGameInfo = objGameInfo;
    }



    // method di Item

    // - untuk membuang item yg dimiliki player ke ruangan
    private void dibuang(){
        System.out.println("Item dibuang Player ke Ruangan");
        objGameInfo.getObjPlayer().hapusItem(this); // hapus dari player
        objGameInfo.getObjRuangan().addItem(this); // tambah ke ruangan
        objRuangan = objGameInfo.getObjRuangan();
    }

    // - memindahkan item dari ruangan ke player
    private void diambil(){
        System.out.println("Item diambil Player");
        objGameInfo.getObjPlayer().addItem(this); // menambahkan ke player
        objRuangan.hapusItem(this); // menghapus dari ruangan
        objRuangan = null;
    }

    // - print deskripsi item
    public void printItem(){
        System.out.println(deskripsi);
    }

    // - untuk aksi item
    public ArrayList<String> getAksi(){
        // aksi dinamik terantung ada di ruangan atau dipegang player/npc
        ArrayList<String> arrOut = new ArrayList<>();
        if(objRuangan == null){
            // ada di player, ada opsi buang
            arrOut.add("Deskripsi Item");
            arrOut.add("Buang item");
        } else{
            // item ada di ruangan, ada opsi diambil
            arrOut.add("Deskripsi Item");
            arrOut.add("Ambil item");
        }
        return (arrOut);
    }

    public void prosesAksi(int pil){
        // pilihan user untuk aksi yang akan diambil
        // urutan harus sama dengan isi arrAksi
        if(pil == 1){
            System.out.println(deskripsi);
        }
        else if(pil == 2) {
            if (objRuangan == null) {
                //dipegang player, dibuang ke ruangan
                dibuang();
            } else {
                // ada di ruangan, diambil player
                diambil();
            }
        }
    }
}
