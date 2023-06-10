import praktikum.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.runner.RunWith;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Ingredient sauceIngredient;
    @Mock
    private Ingredient fillingIngredient;
    @Mock
    private Bun bun;

    private Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void checkSetBuns() {
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(sauceIngredient);
        int expectedSize = 1;
        Assert.assertEquals(expectedSize, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(sauceIngredient);
        burger.removeIngredient(0);
        int expectedSize = 0;
        Assert.assertEquals(expectedSize, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(sauceIngredient);
        burger.addIngredient(fillingIngredient);
        burger.moveIngredient(1, 0);
        Assert.assertEquals( fillingIngredient, burger.ingredients.get(0));
    }

    @Test
    public void getPriceBurgerTest() {
        burger.setBuns(bun);
        burger.addIngredient(sauceIngredient);
        burger.addIngredient(fillingIngredient);
        Mockito.doReturn(100F).when(bun).getPrice();
        Mockito.doReturn(100F).when(sauceIngredient).getPrice();
        Mockito.doReturn(100F).when(fillingIngredient).getPrice();
        float actualResult = burger.getPrice();
        float expectedResult = 400;
        Assert.assertEquals(expectedResult, actualResult, 0);
    }

    @Test
    public void getReceiptTest() {
        burger.addIngredient(sauceIngredient);
        burger.setBuns(bun);
        Mockito.doReturn("white bun").when(bun).getName();
        Mockito.doReturn(100F).when(bun).getPrice();
        Mockito.doReturn(IngredientType.FILLING).when(sauceIngredient).getType();
        Mockito.doReturn("cutlet").when(sauceIngredient).getName();
        Mockito.doReturn(100F).when(sauceIngredient).getPrice();
        String actualResult = burger.getReceipt();
        String expectedResult = "(==== white bun ====)\r\n= filling cutlet =\r\n(==== white bun ====)\r\n\r\nPrice: 300,000000\r\n";
        Assert.assertEquals(expectedResult, actualResult);
    }
}