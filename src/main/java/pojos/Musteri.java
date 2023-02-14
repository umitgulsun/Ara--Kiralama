package pojos;

public class Musteri
{
    private int id; //TC no yerine şimdilik..
    private static int idPrimary;
    private String adi;
    private String soyAdi;
    private String kartNo;

    public Musteri(String adi, String soyAdi)
    {
        id = ++idPrimary;
        this.adi = adi;
        this.soyAdi = soyAdi;
    }

    public String getAdi()
    {
        return adi;
    }

    public int getId()
    {
        return id;
    }

    public String getKart()
    {
        return kartNo;
    }

    public void setKart(String kartNo)
    {
        this.kartNo = kartNo;
    }

    @Override
    public String toString()
    {
        return "Musteri{" +
                "adi='" + adi + '\'' +
                ", soyAdi='" + soyAdi + '\'' +
                '}';
    }
}