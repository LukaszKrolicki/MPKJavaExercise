import java.time.LocalDate;

public class Bilet {
    String rodzaj_biletu;
    double cena_biletu;
    private final LocalDate data;
    Integer ilosc_biletow;

    double podane_pieniadze;

    double dochod;

    String czas_biletu;

    boolean status_biletu;

    String metoda_platnosci;


    public Bilet(String rodzaj_biletu, Integer ilosc_biletow, Double podane_pieniadze, String czas_biletu, String metoda_platnosci){
        this.rodzaj_biletu = rodzaj_biletu + " " + czas_biletu;
        this.ilosc_biletow=ilosc_biletow;
        this.data = java.time.LocalDate.now();
        this.podane_pieniadze=podane_pieniadze;
        this.cena_biletu = setCena_biletu(rodzaj_biletu,czas_biletu);
        this.metoda_platnosci=metoda_platnosci;
        if(podane_pieniadze>=cena_biletu*ilosc_biletow){
            this.dochod=cena_biletu*ilosc_biletow;
            status_biletu=true;
        }
        else{
            dochod=0;
            status_biletu=false;
        }
    }

    private double setCena_biletu(String rodzaj_biletu, String czas_biletu){
        if(rodzaj_biletu=="ulgowy"){
            Double cena = switch (czas_biletu){
                case "20min": yield 2.20;
                case "30min": yield 3.0;
                case "1h": yield 6.0;
                case "3h": yield 10.0;
                case "Dniowy": yield 12.0;
                case "miesieczny": yield 74.0;
                default: yield 0.0;
            };
            return cena;

        } else if (rodzaj_biletu=="normalny") {
            Double cena = switch (czas_biletu){
                case "20min": yield 2.3;
                case "30min": yield 3.1;
                case "1h": yield 6.1;
                case "3h": yield 10.1;
                case "Dniowy": yield 12.1;
                case "miesieczny": yield 74.1;
                default: yield 0.0;
            };
            return cena;
        }
        return 0.0;
    }

    @Override
    public String toString() {
        return "Data: "+ data + " | " + "Rodzaj: " + rodzaj_biletu + " | "+ "Ilosc bileow: "+ilosc_biletow + " | " + "Dochod: " + dochod;
    }

    public Double wydaj_reszte(){
        Double reszta = podane_pieniadze - dochod;

        if(this.metoda_platnosci=="karta"){
            System.out.println("Pieniadze pobrane z konta");
        }
        else if(this.metoda_platnosci=="monety"){
            System.out.println("Wydawanie reszty...");
            PolskiZloty x = new PolskiZloty();
            x.wydajResztewZlotych(reszta);
        }

        return reszta;
    }

    public LocalDate getData() {
        return data;
    }
}