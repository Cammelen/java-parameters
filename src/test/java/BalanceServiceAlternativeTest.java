// класс с зависимостью JUnitParams

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

// JUnitParamsRunner.class является другим классом, который выступает расширением
// для нашего класса
// эта библиотека удобно заворачивает параметризацию
// с помощью аннотации @Parameters (из JUnitParams)
@RunWith(JUnitParamsRunner.class)
public class BalanceServiceAlternativeTest {

    @Test
    // внутри аннотации инициализируем массив из строк,
    // внутри которых перечисляем все параметры
    @Parameters({"100, 100", "200, 200", "300, 400"})
    // есть еще один вариант написания параметров
    // @Parameters{"AAA|1", "BBB|2"}

    // помечаем аргументы тестового метода count и expected
    public void addBalance(int count, int expected) {
        BalanceService balanceService = new BalanceService();
        balanceService.add(count);
        assertEquals(expected, balanceService.getBalance());
    }
}
