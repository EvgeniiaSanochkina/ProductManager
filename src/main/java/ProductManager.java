public class ProductManager {
    private ProductRepository repo;
    Product[] products = new Product[0];

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        repo.save(product);
    }

    public Product[] remove(int id) {
        return repo.removeById(id);
    }


    public Product[] searchBy(String search) {
        Product[] result = new Product[0];
        for (Product product : repo.getProducts()) {
            if (product.matches(search)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        } return result;
    }

}
