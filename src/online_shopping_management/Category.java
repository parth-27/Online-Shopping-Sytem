package online_shopping_management;

import java.util.ArrayList;

public class Category {

    private static ArrayList<String> category = new ArrayList<String>();

    public static String getCategory(int i) {
        return category.get(i);
    }
    
    public static void setCategory(String cat) {
        category.add(cat);
    }
    
}