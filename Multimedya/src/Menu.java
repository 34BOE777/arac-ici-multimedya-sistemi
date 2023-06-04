import java.time.LocalTime;
import java.util.Scanner;

public class Menu {
    private  Eglence e1;
    private Guvenlik g1;

    boolean dongu = true;
    public void Menu(){
        while(dongu){
            Eglence e1 = new Eglence();
            Scanner scanner = new Scanner(System.in);
            System.out.println("----------------- Hoşgeldiniz ! harcadığınız paraya kesinlikle değecek ----------------- ");

            //----------------saat ayarlaması yapılıyor--------------------------
            LocalTime saat = LocalTime.now(); // Sabah 9'dan akşam 9'a kadar gündüz olacak
            LocalTime gunduzBaslangic = LocalTime.of(9, 0); // 9:00
            LocalTime gunduzBitis = LocalTime.of(21, 0);   // 21:00
            if (saat.isAfter(gunduzBaslangic) && saat.isBefore(gunduzBitis)) {
                e1.setZaman(true);
            } else {
                e1.setZaman(false);
            }
            //----------------------------------------------------------------------------

            e1.ekranlar(e1.getZaman());

            System.out.println("bugün nasıl hissediyorsunuz ? (normal,rahat,ruh hastası,uzun yol ve drift seçeneklerinden birini seçin)");
            String mod = scanner.nextLine();
            e1.setMod(mod);
            e1.ruhHali(mod);

            System.out.println("------------------------------------------------------------------------------");
            System.out.println("Diğer işlemler:\nnavigasyon için 1\nsesli komut için 2\nses ayarları için 3\nBurmester ses sisteminden tamamen yararlanmak için 4");
            System.out.println("serit takip için 5\notomatik pilot için 6");
            Guvenlik g1 = new Guvenlik(true,true,true,true);
            int tercih = scanner.nextInt();
            switch (tercih){
                case 1:
                    e1.navi();
                    break;
                case 2:
                    System.out.println("gideceğiniz yeri belirtin");
                    String adres = scanner.nextLine();
                    e1.navi(adres);
                    break;
                case 3:
                    System.out.println("ekolayzer ayarı :\nvarsayılan için 0\nakustik için 1\nHipHop için 2\nelekronik için 3\n klasik için 4\n rock için 5");
                    tercih = scanner.nextInt();
                    e1.muzik(tercih);
                    break;
                case 4:
                    e1.burmester8D();
                    break;
                case 5:
                    g1.seritTakip();
                case 6:
                    g1.otopilot();
            }
            System.out.println("------------------multimedya konfigürasyonu bittiyse iyi yolculuklar dilerim------------------");
            break;
        }
    }
}
