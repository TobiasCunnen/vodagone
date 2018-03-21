package oose.dea.tobiascunnen.rest.dtos;

public class SimpelAbonnement {

    private int id;
    private String aanbieder;
    private String dienst;

    public SimpelAbonnement(int id, String aanbieder, String dienst){

        this.id = id;
        this.aanbieder = aanbieder;
        this.dienst = dienst;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAanbieder() {
        return aanbieder;
    }

    public void setAanbieder(String aanbieder) {
        this.aanbieder = aanbieder;
    }

    public String getDienst() {
        return dienst;
    }

    public void setDienst(String dienst) {
        this.dienst = dienst;
    }
}
