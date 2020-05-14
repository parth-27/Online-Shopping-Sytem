package online_shopping_management;

public class customer {

    private static String name;
    private static String pass;
    private static String email;
    private static String phoneno;
    private static String address;

    public static void setName(String name) {
        customer.name = name;
    }

    public static String getPhoneno() {
        return phoneno;
    }

    public static void setPhoneno(String phoneno) {
        customer.phoneno = phoneno;
    }

    public static String getName() {
        return name;
    }

    public static String getAddress() {
        return address;
    }

    public static void setAddress(String address) {
        customer.address = address;
    }

    public static String getPass() {
        return pass;
    }

    public static void setPass(String pass) {
        customer.pass = pass;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        customer.email = email;
    }
}
