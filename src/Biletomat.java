import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Biletomat {
    private Integer liczba_sprzedanych_ulgowych;
    private Integer liczba_sprzedanych_normalnych;
    private String lokalizaclja;


    List<Bilet> bilety = new ArrayList<Bilet>();

    public Biletomat(String lokalizacja){
        this.liczba_sprzedanych_normalnych = 0;
        this.liczba_sprzedanych_ulgowych = 0;
        this.lokalizaclja=lokalizacja;
    }

    public void kup_ulgowy(Integer ilosc,Double podane_pieniadze, String czas_biletu,String metoda_platnosci){
        Bilet a1 = new Bilet("ulgowy", ilosc, podane_pieniadze,czas_biletu, metoda_platnosci);
        if(a1.status_biletu==true){
            System.out.println("Zakup udany");
            bilety.add(a1);
            a1.wydaj_reszte();
            liczba_sprzedanych_normalnych+=a1.ilosc_biletow;
        }
        else{
            System.out.println("Cos poszlo nie tak, za malo srodkow");
        }
    }

    public void kup_normalny(Integer ilosc,Double podane_pieniadze, String czas_biletu, String metoda_platnosci){
        Bilet b1 = new Bilet("normalny", ilosc, podane_pieniadze,czas_biletu, metoda_platnosci);
        if(b1.status_biletu==true){
            System.out.println("Zakup udany");
            bilety.add(b1);
            b1.wydaj_reszte();
            liczba_sprzedanych_ulgowych+=b1.ilosc_biletow;
        }
        else{
            System.out.println("Cos poszlo nie tak, za malo srodkow");
        }
    }

    public void wszystkie_bilety(){
        for(Bilet i : bilety){
            System.out.println(i.toString());
        }
    }

    public void wszystkie_bilety_danej_daty(LocalDate x){
        for(Bilet i : bilety){
            if(i.getData()==x){
                System.out.println(i.toString());
            }
        }
    }


    public static void main(String[] args) {
        Biletomat a1 = new Biletomat("Lecka 44");
        Biletomat a2 = new Biletomat("Lupinki 2");

        a1.kup_ulgowy(1,40.0, "miesieczny", "karta");
        System.out.println();
        a1.kup_normalny(2,50.0, "20min", "monety");
        System.out.println();
        a1.kup_ulgowy(1,83.0, "miesieczny", "monety");
        System.out.println();
        a1.kup_normalny(1,40.0, "miesieczny", "monety");
        System.out.println();
        a1.kup_normalny(2,45.2, "20min", "monety");
        a1.wszystkie_bilety();

    }
}