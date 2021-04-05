public class Karakter {
    private String nama;
    private int kesehatan;
    private int kekuatan;


    public Karakter(String nama, int kesehatan, int kekuatan){
        this.nama = nama;
    }

    // getter setter
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getKesehatan() {
        return kesehatan;
    }
    public void setKesehatan(int kesehatan) {
        this.kesehatan = kesehatan;
    }

    public int getKekuatan() {
        return kekuatan;
    }
    public void setKekuatan(int kekuatan) {
        this.kekuatan = kekuatan;
    }

    // method yang dimiliki karakter
    public void serang(Player objPlayer){
        objPlayer.setKesehatan(objPlayer.getKesehatan() - kekuatan);

    }

    // mengetahui info karakter
    public void printInfo(){
        System.out.println("Nama      : "+getNama());
        System.out.println("Kesehatan : "+getKesehatan());
        System.out.println("Kekuatan  : "+getKekuatan());
    }

}
