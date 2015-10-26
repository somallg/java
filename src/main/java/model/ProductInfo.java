package java.model;

/**
 * Created by somallg on 9/2/14.
 */
public class ProductInfo {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProductInfo{" +
                "name='" + name + '\'' +
                '}';
    }
}
