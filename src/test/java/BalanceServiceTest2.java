// обходимся без конструктора
// объект создаем в методе теста

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BalanceServiceTest2 {

    @Parameterized.Parameters
    public static Object[][] params() {
        return new Object[][]{
                {100, 100},
                {200, 200},
                {300, 400},
        };
    }

    // создаем поля для теста без конструктора
    // в этом случае поля не должны быть приватными
    @Parameterized.Parameter
    public int count;

    //в этом параметре надо указать индекс (1), т.к. в массиве несколько параметре
    @Parameterized.Parameter(1)
    public int expected;

    // можно заменить использование конструктора на аннотацию Parameter,
    // которую указываем в полях
    // тогда объект класса BalanceService создается в самом тесте
    @Test
    public void testAddBalance() {
        BalanceService balanceService = new BalanceService();
        balanceService.add(count);
        assertEquals(expected, balanceService.getBalance());
    }
}
