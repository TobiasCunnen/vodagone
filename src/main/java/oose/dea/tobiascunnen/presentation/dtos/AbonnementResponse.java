package oose.dea.tobiascunnen.presentation.dtos;

import java.util.List;

public class AbonnementResponse {

    private List<SimpelAbonnement> abonnementen;
    private double totalPrice;

    public List<SimpelAbonnement> getAbonnementen() {
        return abonnementen;
    }

    public void setAbonnementen(List<SimpelAbonnement> abonnementen) {
        this.abonnementen = abonnementen;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
