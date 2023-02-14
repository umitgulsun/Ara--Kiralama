package pojos;

public class Arac
{
    private int id; // Araç plakası olabilir.
    private static int idPrimary;
    private String marka;
    private String model;
    private String yakitTipi;
    private float gunlukUcret;
    private boolean kiradaMi;

    public Arac(String marka, String model, String yakitTipi, float gunlukUcret, boolean kiradaMi)
    {
        this.id = ++idPrimary;
        this.marka = marka;
        this.model = model;
        this.yakitTipi = yakitTipi;
        this.gunlukUcret = gunlukUcret;
        this.kiradaMi = kiradaMi;
    }

    public int getId()
    {
        return id;
    }

    public String getMarka()
    {
        return marka;
    }

    public String getModel()
    {
        return model;
    }

    public String getYakitTipi()
    {
        return yakitTipi;
    }

    public float getGunlukUcret()
    {
        return gunlukUcret;
    }

    @Override
    public String toString()
    {
        return "id = " + id + ", marka = " + marka + ", model = " + model + " yakitTipi = " + yakitTipi + ", gunlukUcret = " + gunlukUcret + ", kiradaMi = " + kiradaMi;
    }
}