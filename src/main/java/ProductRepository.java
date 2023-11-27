public class ProductRepository {
    Product[] products = new Product[0];

    public void save(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public Product[] getProducts() {
        return products;
    }

    public String findById(int id) {
        Product[] tmp = new Product[1];
        String result = null;
        for (Product product : products) {
            if (product.getId() == id) {
                tmp[0] = product;
                result = tmp[0].getName();
            }
        }
        return result;
    }

    public Product[] removeById(int id) {
        if(findById(id) == null) {
            throw new NotFoundException("Нету такого айди");
        }
        Product[] tmp = new Product[products.length - 1];
        int index = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[index] = product;
                index ++;
            }
        }
        return tmp;
    }
}
