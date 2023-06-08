public class Guvenlik implements IGoruntu,ITitresim{
    //sensörlerin güvenliği,gizliliği ve dışarıdan müdahaleye kapalı olması için private olarak belirlendi
    //sensörler true ise tehlike yok demektir
    //sensörler false ise tehlike var demektir ve ona göre çarpışma önleyici sistemler devreye girecektir
    private boolean onSensor;
    private boolean arkaSensor;
    private boolean sagSensor;
    private boolean solSensor;

    public Guvenlik(boolean onSensor, boolean arkaSensor, boolean sagSensor, boolean solSensor) {
        this.onSensor = onSensor;
        this.arkaSensor = arkaSensor;
        this.sagSensor = sagSensor;
        this.solSensor = solSensor;
    }
    public Guvenlik(){}


    @Override
    public void ambiyans(int seviye) {
        //Bu bölümde ambiyans ayarlarını otomatik pilot, şerit ihlali ve çarpışma uyarısı gibi durumlar için ayrı ayrı özelleştireceğiz
    switch (seviye){
        case 1:
            System.out.println("Ambiyans otomatik pilot modunda her şeyin normal olduğunu belirtmek için yavaşça yanıp sönen yeşil olarak ayarlandı");
            break;
        case 2:
            System.out.println("Ambiyans kaza riski tespit ettiği için hızlıca yanıp sönen kırmızı olarak ayarlandı");
            break;
        case 3:
            System.out.println("Ambiyans şerit ihlali tespit ettiği için orta hızda yanıp sönen turuncu olarak ayarlandı");
    }
    }

    @Override
    public void gosterge(int seviye) {
        //sağa sinyal verildiğinde devir saati yerine sağ dikiz aynasının kamerası çalışır.
        //sola sinyal verildiğinde hız göstergesinin yerine sol dikiz aynasının kamerası çalışır.
        //araç durduğunda öndeki araç hareket ettiyse ve araç hala yerinde duruyorsa göstergede 'öndeki araç hareket etti' diye bir uyarı çalışır. Bunu ön sensör ile yapar
        //aracın sensörlerine göre farkı yerlerden gelecek olan çarpışma tehlikelerine karşı çarpışma uyarısı verir
        //devamlı şerit ihlali yapılması durumunda mola verilmesi için uyarıda bulunur
        switch (seviye){
            case 1:
                System.out.println("sağ dikiz aynasının kamerası çalıştı");
                break;
            case 2:
                System.out.println("sol dikiz aynasının kamerası çalıştı");
                break;
            case 3:
                System.out.println("göstergede öndeki araç hareket etti uarısı çalıştı");
                break;
            case 4:
                System.out.println("çarpışma uyarısı çalıştı");
                break;
            case 5:
                System.out.println("lütfen mola verin uyarısı çalıştı");
                break;
            case 6:
                System.out.println("otomatik pilotun devreye girdiğine dair bir uyarı verir");
            case 7:
                System.out.println("otomatik pilotun devre dışı kaldığına dair bir uyarı verir");

        }
    }

    @Override
    public void burmester8D() {
        //çarpışma uyarısında koltuklar titreyerek sürücü uyarılır
        System.out.println("koltuklar uyarı modunda titredi");

    }

    @Override
    public void uyari(int seviye) {
        //farklı durumlarda bazen aynı uyarı sesi kullanılmak üzere bazı sesler ve titreşimler tanımlanır
        switch (seviye){
            case 1:
                System.out.println("standart uyarı sesi çalıştı - titreşim yok");
            case 2:
                System.out.println("orta seviye uyarı sesi çalıştı - direksiyona doğrudan müdahale var");
                //şerit ihlalinde aracı şeride geri döndürmek için
            case 3:
                System.out.println("yüksek seviye uyarı sesi çalıştı - direksiyonda titreme var");
        }

    }

    public void kazaOnleme(boolean arkaSensor,boolean sagSensor, boolean solSensor){
        //arkadan hızla gelen bir aracı uyarmak adına 4'lüler otomatik yanar
        if ((this.arkaSensor == false) || (this.sagSensor == false) || (this.solSensor == false)){
            gosterge(4);
            uyari(3);
            burmester8D();
            ambiyans(2);
            System.out.println("4'lüler devreye girdi arka güvenlik sağlanılıyor");
        }
    }
    public void kazaOnleme(boolean onSensor){
        //ondeki araca doğru çok hızlı bir şekilde yaklaşılırsa çalışacak olan uyarı sistemidir
        if (this.onSensor == false){
            gosterge(4);
            uyari(3);
            burmester8D();
            ambiyans(2);
            System.out.println("acil frenleme devreye girdi");
        }
    } 
    public void seritTakip(){
        System.out.println("şerit takip çalşmaya başladı");
        System.out.println("sağ ve sol sensörler çalıştı ama göstergeye yansımıyor");
        if ((this.sagSensor == false) || (this.solSensor == false)){
            gosterge(5);
            ambiyans(3);
            uyari(2);
        }
    }
    public void otopilot(){
        if((this.arkaSensor) && (this.sagSensor) && (this.solSensor) && (this.onSensor)){
            uyari(1);
            gosterge(6);
            System.out.println("otomatik pilot devrede. Çevreyi kontrol etmeyi unutmayın");
            ambiyans(1);
        }else
            System.out.println("otomatik pilot devre dışı");
            gosterge(7);
            uyari(3);
    }
    public void onuneBak(){
        //öndeki araç hareket ettiği halde araç hala duruyorsa bu uyarı devreye girer
        uyari(1);
        gosterge(3);
    }

}
