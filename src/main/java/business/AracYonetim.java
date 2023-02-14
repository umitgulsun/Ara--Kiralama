package business;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pojos.Arac;
import pojos.Musteri;

public class AracYonetim
{
    static final Arac arac1 = new Arac("Mercedes", "E400", "Benzin", 1500f, false);
    static final Arac arac2 = new Arac("BMW", "X5", "Hibrit", 500f, false);
    static final Arac arac3 = new Arac("Tofaş", "Şahin", "Hibrit", 5500f, false);
    static final Arac arac4 = new Arac("Tofaş", "Murat124", "Su", 100f, false);
    static final Arac arac5 = new Arac("Volvo", "S40", "Dizel", 350f, false);
    static List<Arac> aracListesi = new ArrayList<>(Arrays.asList(arac1, arac2, arac3, arac4, arac5));

    public static void aracListele()
    {
        for(Arac w : aracListesi)
        {
            System.out.println(w);
        }
    }

    public static Arac aracSec(int aracId)
    {
        for(Arac w : aracListesi)
        {
            if(w.getId() == aracId)
                return w;
        }
        return null;
    }

    public static Arac aracSec(String marka, String model, String yakitTipi)
    {
        for(Arac w : aracListesi)
        {
            if(w.getMarka().equalsIgnoreCase(marka) && w.getModel().equalsIgnoreCase(model) && w.getYakitTipi().equalsIgnoreCase(yakitTipi))
                return w;
        }
        return null;
    }
}