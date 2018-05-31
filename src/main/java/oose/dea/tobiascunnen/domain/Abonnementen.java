package oose.dea.tobiascunnen.domain;

import java.util.List;

public class Abonnementen {

    private List<Abonnement> abonnementen;
    private double totalPrice;

    public List<Abonnement> getAbonnementen() {
        return abonnementen;
    }

    public void setAbonnementen(List<Abonnement> abonnementen) {
        this.abonnementen = abonnementen;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
