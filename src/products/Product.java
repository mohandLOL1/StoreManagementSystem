package products;

import databases.Searchable;

public class Product implements Searchable {
    @Override
    public String getSearchKey() {
        return "";
    }
}
