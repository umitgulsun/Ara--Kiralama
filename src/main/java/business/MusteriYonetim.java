package business;

import pojos.Musteri;
import pojos.Arac;

import java.util.ArrayList;
import java.util.List;

public class MusteriYonetim
{
    static List<Musteri> musteriler = new ArrayList<>();

    public static Musteri musteriBilgileriAl(String ad, String soyAd)
    {
        Musteri musteri = new Musteri(ad, soyAd);
        System.out.println(musteri);
        musteriler.add(musteri);
        return musteri;
    }

    public static void odemeBilgisi(Musteri musteri, Arac arac, String kartNo)
    {
        musteri.setKart(kartNo);
        System.out.println(musteri.getAdi() + " adlı müşterinin seçtiği araç : " + arac);
    }
}