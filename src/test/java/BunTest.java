import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    private Bun bun;
    private final String TEST_NAME = "Булка";
    private final float TEST_PRICE = 220;

    @Before
    public void setUp() {
        bun = new Bun(TEST_NAME, TEST_PRICE);
    }

    @Test
    public void getNameReturnCorrectValueTest() {
        String actualResult = bun.getName();
        Assert.assertEquals("Неверное имя", TEST_NAME, actualResult);
    }

    @Test
    public void getPriceReturnCorrectValueTest() {
        float actualResult = bun.getPrice();
        Assert.assertEquals("Неверная цена", TEST_PRICE, actualResult, 0);
    }
}