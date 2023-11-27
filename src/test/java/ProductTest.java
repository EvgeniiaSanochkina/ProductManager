import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {

    Book item1 = new Book(1, "12 rules", 500, "Peterson");
    Book item5 = new Book(5, "more rules", 500, "Peterson");
    Book item2 = new Book(2, "Cocoon", 400, "Zhang Yueran");
    Smartphone item3 = new Smartphone(3, "Iphone", 100000, "apple");
    Smartphone item4 = new Smartphone(4, "Samsung", 100000, "Samsung");

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    @Test
    public void shouldAdd() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        Product[] actual = repo.getProducts();
        Product[] expected = {item1, item2, item3, item4, item5};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        Product[] actual = manager.remove(5);
        Product[] expected = {item1, item2, item3, item4};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGenerateExceptionIfIdDoesNotExist() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(9);
        });
    }

    @Test
    public void shouldSearchByTextMult() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        Product[] actual = manager.searchBy("rules");
        Product[] expected = {item1, item5};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByTextOnce() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        Product[] actual = manager.searchBy("Iphone");
        Product[] expected = {item3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearchByText() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        Product[] actual = manager.searchBy("rakamakafo");
        Product[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindById() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        String actual = repo.findById(8);
        String expected = null;
        Assertions.assertEquals(expected, actual);
    }

}
