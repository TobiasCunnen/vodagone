package oose.dea.tobiascunnen.datasource.mapper;

public class LoginMapper {

    private static int id;
    private static String name;
    private static String email;
    private static String password;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        LoginMapper.id = id;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        LoginMapper.name = name;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        LoginMapper.email = email;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        LoginMapper.password = password;
    }
}
