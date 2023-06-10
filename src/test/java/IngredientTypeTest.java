import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final IngredientType ingredientType;
    private final String stringIngredientType;

    public IngredientTypeTest(IngredientType ingredientType, String stringIngredientType) {
        this.ingredientType = ingredientType;
        this.stringIngredientType = stringIngredientType;
    }

    @Parameterized.Parameters(name = "Тип ингридиента. Тестовые данные: Тип ингридиента: {1}")
    public static Object[][] getParameters() {
        return new Object[][] {
                {IngredientType.SAUCE, "SAUCE"},
                {IngredientType.FILLING, "FILLING"}
        };
    }
    @Test
    public void checkIngredientTypeTest() {
        Assert.assertEquals(ingredientType, IngredientType.valueOf(stringIngredientType));
    }
}