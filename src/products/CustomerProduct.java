package products;

import databases.Searchable;

public class CustomerProduct implements Searchable {
    @Override
    public String getSearchKey() {
        return "";
    }
}
