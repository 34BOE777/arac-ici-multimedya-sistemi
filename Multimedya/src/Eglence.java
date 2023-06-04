public class Eglence extends  parcaDurumlari implements ISes,IGoruntu,ITitresim,ISurusModu{
    public String mod;
    public  boolean zaman; //zaman kavramı gündüz ve gece olmak üzere iki çeşittir. ture gündüz, false gece anlamına gelir

    public Eglence(String mod, boolean zaman) {
       this.mod = mod;
       this.zaman = zaman;
    }
    public Eglence(){}
    public boolean getZaman(){
        return this.zaman;
    }

    public void setMod(String mod) {
        this.mod = mod;
    }

    public void setZaman(boolean zaman) {
        this.zaman = zaman;
    }

    @Override
    public void ambiyans(int seviye) {
        //seçilen sürüş modları ve yolun durumuna göre farklı renklere bürünecek olan ambiyans sisteminin burada tanımlaması yapılır.
        switch (seviye){
            case 0:
                System.out.println("Ambiyans Beyaz olarak ayarlandı");
                break;
            case 1:
                System.out.println("Ambiyans Kırmızı olarak ayarlandı");
                break;
            case 2:
                System.out.println("Ambiyans mavi olarak ayarlandı");
                break;
            case 3:
                System.out.println("Ambiyans yeşil olarak ayarlandı");
                break;
            case 4:
                System.out.println("Ambiyans otomatik pilot modunda her şeyin normal olduğunu belirtmek için yavaşça yanıp sönen yeşil olarak ayarlandı");
                break;
            case 5:
                System.out.println("Ambiyans kaza riski tespit ettiği için hızlıca yanıp sönen kırmızı olarak ayarlandı");
                break;
            case 6 :
                System.out.println("Ambiyans zaman içerisinde farklı renklere dönüşecek şekilde gökkuşağı olarak ayarlandı");
                break;
        }
    }

    @Override
    public void gosterge(int seviye) {
        //seçilen sürüş moduna göre araç göstergesinin değişimi buradan tanımlanır
        switch (seviye) {
            case 1:
                System.out.println("Göstergeler normal moda ayarlandı");
                break;
            case 2:
                System.out.println("Göstergeler ekonomik moda ayarlandı");
                break;
            case 3:
                System.out.println("Göstergeler sport moda ayarlandı");
                break;
        }
    }

    @Override
    public void motorSesi(int seviye) {
        /*
        seçilen sürüş moduna göre aracın hoparlöründen çıkan yapay motor sesi gerçek motor sesine eklenilerek
        sürüş memnuniyeti arttırılır. tercihe göre bu ses tamamen kapatılabilir. tüm bu işlem burada tanımlanır
        */

        switch (seviye) {
            case 1:
                System.out.println("yapay motor sesi kapatıldı");
                break;
            case 2:
                System.out.println("yapay motor sesi açıldı.");
                break;
        }
    }

    @Override
    public void muzik(int seviye)
    //Araçta bulunan müzik sistemi seçilen modlara göre ekolayzer araylamasını yapar
    {
        switch (seviye){
            case 0:
                System.out.println("Ekolayzer varsayılan moda ayarlandı");
                break;
            case 1:
                System.out.println("Ekolayzer akustik moda ayarlandı");
                break;
            case 2:
                System.out.println("Ekolayzer HipHop moda ayarlandı");
                break;
            case 3:
                System.out.println("Ekolayzer elektronik moda ayarlandı");
                break;
            case 4:
                System.out.println("Ekolayzer klasik moda ayarlandı");
                break;
            case 5:
                System.out.println("Ekolayzer rock moda ayarlandı");
                break;
        }

    }
    //Bu aşamada sürüş modlarının tanımlaması yapılır.
    //0,1 ve 2 olmak üzere üç seviye vardır.
    //0 varsayılan moddur ve herhangi bir ekstra durum sunmaz
    //1 motor ve vites kutusu için ekonomik, süspansiyon için konfor ve egzoz için maksimum sessizlik anlamına gelir
    //2 sportif moddur ve her parçanın en agresif moda çevirir.
    //Tüm bu modlarda ESC true modunda yani çalışır durumdadır. Drift modunda ise ESC false'a alınır yani devre dışı bırakılır
    @Override
    public void normal() {
        //normal modda aracın teknik aksamı varsayılan değerlere ayarlanır
        this.motor = 0;
        this.suspansiyon = 0;
        this.egzoz = 0;
        this.vitesKutusu = 0;
        this.ESC = true;
        motorSesi(1);
    }

    @Override
    public void sport() {
        this.motor = 2;
        this.suspansiyon = 2;
        this.egzoz = 2;
        this.vitesKutusu = 2;
        this.ESC = true;
        motorSesi(2);
    }

    @Override
    public void eco() {
        this.motor = 1;
        this.suspansiyon = 1;
        this.egzoz = 1;
        this.vitesKutusu = 1;
        this.ESC = true;
        motorSesi(1);
    }

    @Override
    public void drift() {
        this.motor = 2;
        this.suspansiyon = 2;
        this.egzoz = 2;
        this.vitesKutusu = 2;
        this.ESC = false;
        motorSesi(2);
    }

    @Override
    public void comfort(){
        this.motor = 0;
        this.suspansiyon = 1;
        this.egzoz = 1;
        this.vitesKutusu = 0;
        this.ESC = true;
        motorSesi(1);
    }

    @Override
    public void burmester8D() {
        /*
        Aracımızda Burmester 8D ses sistemi vardır. Bu sistem, zaten aşırı kaliteli müzik deneyimi sunarken
        aynı zamanda koltuklara da müziğe göre bir titreşim yollar ve böylece sadece duyma duyusuyla değil
        dokunma duyusuyla da müziği hissedebiliyorsunuz.
         */
        System.out.println("8D titreşim modu açıldı");
    }

    @Override
    public void uyari(int seviye) {
        //burada farklı durumlar için farklı uyarı titreşimleri ve sesleri çalışır
        switch (seviye){
            case(0):
                System.out.println("sürüş modunun normale geçtiğine dair göze batmayan sakin bir ses ve direksiyonda hafif bir titreşim çıktı");
                break;
            case 1:
                System.out.println("sürüş modunun eco'ya geçtiğine dair rahatlatıcı ve barışçıl bir ses çıktı (titreşim yok)");
                break;
            case 2:
                System.out.println("sürüş modunun sport'a geçtiğine dair savaşa hazır ol tarzı bir ses ve direksiyonda sürücüyü uyaran bir titreşim çıktı");
                break;
            case 3:
                System.out.println("sürüş modunun drift olarak ayarlanması üzerine sürücüyü dikkatlı olması gerektiği hakkında bir ses ve bir titreşim çıkar");
                break;

        }

    }
    public void ruhHali(String mod){
        //girilen ruh haline göre araç kendisini ayarlar.
    switch (this.mod){
        case "normal":
            System.out.println("pekala hadi normal bir sürüşe çıkalım");
            ambiyans(6);
            gosterge(1);
            muzik(0);
            normal();
            uyari(0);
            break;

        case "rahat":
            System.out.println("Rahatına bak. Yolu hissetmeyeceksin ama sakın uyuyakalma :D");
            ambiyans(6);
            gosterge(1);
            muzik(0);
            burmester8D();
            comfort();
            uyari(0);
            break;

        case "ruh hastası":
            System.out.println("ölmemeye çalış ! pert olana kadar seninleyim");
            ambiyans(1);
            gosterge(3);
            muzik(2);
            sport();
            uyari(2);
            break;

        case "uzun yol":
            System.out.println("Boşuna mı sol şerit arabası aldın ? Hadi bunu en iyi şekilde kullanalım. iyi yolculuklar");
            ambiyans(2);
            gosterge(1);
            muzik(0);
            normal();
            uyari(0);
            break;

        case "drift":
            System.out.println("Sen gerçekten kafayı sıyırmışsın :D kameralardan uzak dur yeter");
            ambiyans(1);
            gosterge(3);
            muzik(2);
            drift();
            uyari(3);
            break;
    }

    }
    //ekran parlaklığını stabil ya da zamana göre ayarlayan metodların tanımı yapılır
    public void ekranlar(){
        System.out.println("ekranların parlaklığı varsayılan değerde");
    }
    public void  ekranlar(boolean zaman){
        if(this.zaman){
            System.out.println("Ekranların parlaklığı arttırıldı");
        }
        else {
            System.out.println("Ekranların parlaklığı gözleri yormaması için azaltıldı");

        }
    }
    /*
    navigasyon çalıştırma işlemi iki şekildedir. Birinci metod sadece navigasyonu açar ve adres manuel olarak girilir.
    İkinci metod ise sesli komut ile çalışır. Örneğin 'beni eve götür' sesli komutunda Ev kaydedilmişse otomatik olarak evin
    adresini 'ev' String'ine eşitler ve parametre olarak onu kullanır. Böylece navigasyon otomatik olarak açılır ve gerekli rotayı çizer
     */
    public void navi(){
        System.out.println("Navigasyon - Hazır");
    }
    public void navi(String adres){
        System.out.println("Girilen adres onaylandı..\nRota oluşturuldu !");
    }
}
