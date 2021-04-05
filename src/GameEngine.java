import java.util.Scanner;

public class GameEngine {
    // user interface game
    Scanner sc = new Scanner(System.in);
//    Karakter objKarakter = new Karakter("Kurtet", 100, 10);
    Player objPlayer = new Player("Budiwati", 100, 10);
    Ruangan objRuangan = new Ruangan(); //cuma satu ruangan
    GameInfo objGameInfo = new GameInfo();


    // constructor
    public GameEngine(){
        // init ruangannya
        objRuangan.setObjGameInfo(objGameInfo);
        objRuangan.setDeskripsi("Ruangan kecil, dengan satu pintu dan jendela");
        objPlayer.setRuanganAktif(objRuangan);  //set ruangan aktif player
        objPlayer.setObjGameinfo(objGameInfo);

        objGameInfo.setObjPlayer(objPlayer);
        objGameInfo.setObjRuangan(objRuangan);
    }

    // method aksi
    private void aksi(){
        System.out.println();
        System.out.println("==============================================");
        System.out.println("1. Aksi yang dapat dilakukan di ruangan");
        System.out.println("2. Aksi terhadap player");
        System.out.println("3. Lawan musuh");
        System.out.println("4. Keluar");
        System.out.println("==============================================");
        System.out.print("Pilihan anda?");
        int pil = sc.nextInt();
        System.out.println("--");
        if(pil == 4){
            objGameInfo.setGameOver(true); //keluar
        } else if(pil == 1){
            objRuangan.pilihanAksi();
        } else if(pil == 2){
            objPlayer.pilihanAksi();
        } else if(pil == 3){
            objRuangan.bertanding();
        }
    }

    // method mulai
    public void mulai(){
        while (!objGameInfo.getGameOver()){
            aksi();
        }
    }

    // main
    public static void main(String[] args) {
        GameEngine objGameEngine;
        objGameEngine = new GameEngine();
        objGameEngine.mulai();
    }
}
