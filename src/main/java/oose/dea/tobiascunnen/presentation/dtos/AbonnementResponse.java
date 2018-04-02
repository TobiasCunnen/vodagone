package oose.dea.tobiascunnen.presentation.dtos;

import oose.dea.tobiascunnen.domain.POJO.AbonnementenPOJO;

import java.util.List;

public class AbonnementResponse {

    private List<AbonnementenPOJO> abonnementen;
    private double totalPrice;

    public List<AbonnementenPOJO> getAbonnementen() {
        return abonnementen;
    }

    public void setAbonnementen(List<AbonnementenPOJO> abonnementen) {
        this.abonnementen = abonnementen;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
