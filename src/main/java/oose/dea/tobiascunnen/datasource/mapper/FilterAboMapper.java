package oose.dea.tobiascunnen.datasource.mapper;

import java.math.BigDecimal;

public class FilterAboMapper {
    private static int id;
    private static String aanbieder;
    private static String dienst;
    private static BigDecimal prijs;
    private static String startDatum;
    private static String verdubbeling;
    private static boolean deelbaar;
    private static String status;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        FilterAboMapper.id = id;
    }

    public static String getAanbieder() {
        return aanbieder;
    }

    public static void setAanbieder(String aanbieder) {
        FilterAboMapper.aanbieder = aanbieder;
    }

    public static String getDienst() {
        return dienst;
    }

    public static void setDienst(String dienst) {
        FilterAboMapper.dienst = dienst;
    }

    public static BigDecimal getPrijs() {
        return prijs;
    }

    public static void setPrijs(BigDecimal prijs) {
        FilterAboMapper.prijs = prijs;
    }

    public static String getStartDatum() {
        return startDatum;
    }

    public static void setStartDatum(String startDatum) {
        FilterAboMapper.startDatum = startDatum;
    }

    public static String getVerdubbeling() {
        return verdubbeling;
    }

    public static void setVerdubbeling(String verdubbeling) {
        FilterAboMapper.verdubbeling = verdubbeling;
    }

    public static boolean isDeelbaar() {
        return deelbaar;
    }

    public static void setDeelbaar(boolean deelbaar) {
        FilterAboMapper.deelbaar = deelbaar;
    }

    public static String getStatus() {
        return status;
    }

    public static void setStatus(String status) {
        FilterAboMapper.status = status;
    }
}
