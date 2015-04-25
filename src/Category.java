import java.util.ArrayList;

/**
 * Created by INTEL on 10/4/2015.
 */
public class Category {
    public int id;
    public String name;
    public ArrayList<String> key = new ArrayList<>();

    //kontruktor
    public Category ( int id, String name ) {
        this.id = id;
        this.name = name;
    }
    //fungsi untuk menambahkan keyword kedalam kategori
    public void addKey ( String s ) {
        key.add(s);
    }
}
