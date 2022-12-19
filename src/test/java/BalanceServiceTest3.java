// массив с одним параметром

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BalanceServiceTest3 {

    // создаем массив для одного параметра
    @Parameterized.Parameters
    public static Object[] singleParam() {
        return new Object[]{100, 200, 300, 900};
    }

    @Parameterized.Parameter
    public int count;

    @Test
    public void testAddBalance() {
        BalanceService balanceService = new BalanceService();
        balanceService.add(count);
        assertEquals(count, balanceService.getBalance());
    }
}
