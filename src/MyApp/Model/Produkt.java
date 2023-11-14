package MyApp.Model;

public class Produkt {

    private int id;
    private String produkt_name;
    private double Preis;
    private String beschreibung;


    public Produkt(String produkt_name, double preis, String beschreibung) {
        this.produkt_name = produkt_name;
        Preis = preis;
        this.beschreibung = beschreibung;
    }

    public Produkt(int id, String produkt_name, double preis, String beschreibung) {
        this.id = id;
        this.produkt_name = produkt_name;
        Preis = preis;
        this.beschreibung = beschreibung;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProdukt_name() {
        return produkt_name;
    }

    public void setProdukt_name(String produkt_name) {
        this.produkt_name = produkt_name;
    }

    public double getPreis() {
        return Preis;
    }

    public void setPreis(double preis) {
        Preis = preis;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }
}
