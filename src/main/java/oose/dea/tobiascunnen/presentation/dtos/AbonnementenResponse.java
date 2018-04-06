package oose.dea.tobiascunnen.presentation.dtos;

import java.util.List;

public class AbonnementenResponse {

    private List<AbonnementResponse> abonnementen;
    private double totalPrice;

    public List<AbonnementResponse> getAbonnementen() {
        return abonnementen;
    }

    public void setAbonnementen(List<AbonnementResponse> abonnementen) {
        this.abonnementen = abonnementen;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
