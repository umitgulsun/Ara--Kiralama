package UI;

import business.AracYonetim;
import business.MusteriYonetim;
import pojos.Musteri;
import pojos.Arac;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Helper
{
    Musteri musteri;
    Arac arac;
    LocalDate kiralamaTarihi;
    LocalDate teslimTarihi;
    int toplamUcet;
    Scanner input;

    public void aracSecme()
    {
        input = new Scanner(System.in);
        AracYonetim.aracListele();

        Arac arac = aracSecmeIslemi();
        if(arac != null)
        {
            tarihAlUcretGoster(arac);
            System.out.println("Seçtiğiniz aracı kiralamak istiyor musunuz? (e, h) : " + arac);
            String devamMi = input.next();
            if(devamMi.equalsIgnoreCase("e"))
                islemeDevam(arac);
            else
            {
                System.out.println("İyi günler");
                return;
            }
        }
        else
        {
            System.out.println("Yanlış id girildi veya bu özellikleri tamamlayan araç yok..");
            aracSecme();
        }
    }

    private Arac aracSecmeIslemi()
    {
        input = new Scanner(System.in);
        System.out.println("Aklınızda bir araç var mı");
        String secim = input.nextLine();
        if(secim.equalsIgnoreCase("h"))
        {
            System.out.print("Araç numarasını seç : ");
            int aracId = input.nextInt();
            return AracYonetim.aracSec(aracId);
        }
        else
        {
            System.out.print("Marka : ");
            String marka = input.next();
            System.out.print("Model : ");
            String model = input.next();
            System.out.print("Yakıt Tipi : ");
            String yakit = input.next();
            return AracYonetim.aracSec(marka, model, yakit);
        }
    }

    private void tarihAlUcretGoster(Arac arac)
    {
        System.out.println("Alış Tarihi Girin");
        kiralamaTarihi = tarihAl();
        System.out.println("Teslim Tarihi Girin");
        teslimTarihi = tarihAl();
        ucretGoster(arac, Period.between(kiralamaTarihi, teslimTarihi).getDays());
    }

    private LocalDate tarihAl()
    {
        input = new Scanner(System.in);
        System.out.print("Gün : ");
        int gun = input.nextInt();
        System.out.print("Ay : ");
        int ay = input.nextInt();
        System.out.print("Yıl : ");
        int yil = input.nextInt();
        return LocalDate.of(yil, ay, gun);
    }

    private void ucretGoster(Arac arac, int kiralamaGunu)
    {
        if(kiralamaGunu > 0)
            System.out.println(kiralamaGunu + " günlük kiralama ücreti : " + arac.getGunlukUcret() * kiralamaGunu);
        else
        {
            System.out.println("Teslim tarihi kiralama tarihinden önce olamaz!");
            tarihAlUcretGoster(arac);
        }
    }

    private void islemeDevam(Arac arac)
    {
        input = new Scanner(System.in);
        System.out.print("İsim : ");
        String mAdi = input.nextLine();
        System.out.print("Soyadi : ");
        String mSoyad = input.nextLine();
        Musteri musteri = MusteriYonetim.musteriBilgileriAl(mAdi, mSoyad);
        kartBilgisiAl(musteri, arac);
    }

    private void kartBilgisiAl(Musteri musteri, Arac arac)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("16 Haneli kart no'su giriniz : ");
        String kartNo = input.nextLine();
        if(kartNo.length() == 16 && kartNo.replaceAll("[0-9]", "").length() == 0)
        {
            MusteriYonetim.odemeBilgisi(musteri, arac, kartNo);
            System.out.println("Ücretiniz çekilmiştir, iyi günler..");
        }
        else
        {
            System.out.println("Kart no'su 16 haneli olmalıdır. Sadece rakam içermelidir.");
            kartBilgisiAl(musteri, arac);
        }
    }
}