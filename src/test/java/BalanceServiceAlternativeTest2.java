// библиотека поддерживает написание датапровайдеров отдельными методами -
// по сути ссылаются на них

//РАЗОБРАТЬСЯ ПОЧЕМУ КОД НЕ РАБОТАЕТ

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class BalanceServiceAlternativeTest2 {

    // создаем датапровайдер для нашего теста, который будет проверять в объекте
    // метод, который будет подставлять нам данные
    @Test
    @Parameters
    public void withdrawBalance(int count, int expected) {
        BalanceService balanceService = new BalanceService();
        balanceService.withdraw(count);
        assertEquals(expected, balanceService.getBalance());
    }

    public Object[][] balanceServiceWithdrawData() {
        return new Object[][]{
                {100, -100},
                {200, -200},
                {300, -400},
        };
    }
}