package oose.dea.tobiascunnen.datasource.mapper;

public class SelectedAboMapper {

    private static int id;
    private static String aanbieder;
    private static String dienst;
    private static String prijs;
    private static String startDatum;
    private static String verdubbeling;
    private static boolean deelbaar;
    private static String status;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        SelectedAboMapper.id = id;
    }

    public static String getAanbieder() {
        return aanbieder;
    }

    public static void setAanbieder(String aanbieder) {
        SelectedAboMapper.aanbieder = aanbieder;
    }

    public static String getDienst() {
        return dienst;
    }

    public static void setDienst(String dienst) {
        SelectedAboMapper.dienst = dienst;
    }

    public static String getPrijs() {
        return prijs;
    }

    public static void setPrijs(String prijs) {
        SelectedAboMapper.prijs = prijs;
    }

    public static String getStartDatum() {
        return startDatum;
    }

    public static void setStartDatum(String startDatum) {
        SelectedAboMapper.startDatum = startDatum;
    }

    public static String getVerdubbeling() {
        return verdubbeling;
    }

    public static void setVerdubbeling(String verdubbeling) {
        SelectedAboMapper.verdubbeling = verdubbeling;
    }

    public static boolean isDeelbaar() {
        return deelbaar;
    }

    public static void setDeelbaar(boolean deelbaar) {
        SelectedAboMapper.deelbaar = deelbaar;
    }

    public static String getStatus() {
        return status;
    }

    public static void setStatus(String status) {
        SelectedAboMapper.status = status;
    }
}
