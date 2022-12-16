// для параметризированного теста импортируем раннер
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
// для сравнения ОР (expected) и ФР (actual) импортируем assertEquals
import static org.junit.Assert.assertEquals;

// по api при приеме заказов в магазине меняются их статусы
// надо проверить по одному сценарию, что вся статусная модель работает
// при ранее известном разном наборе данных
// необходимо написать 4 отдельных теста, т.е. 4 метода в рамках одного класса

// создаем класс с раннером
// в параметризованном классе запускаются ВСЕ тесты,
// непараметризованные тесты создаются в другом классе
// тесты запускаем отсюда
@RunWith(Parameterized.class)
public class BalanceServiceTest {

    // ПЕРВЫЙ И ВТОРОЙ ВАРИАНТ
    // двумерный массив, куда заносим тестовые данные
    @Parameterized.Parameters
    public static Object[][] params() {
        return new Object[][] {
                {100, 100},
                {200, 200},
                {300, 400},
        };
    }

    // ТРЕТИЙ ВАРИАНТ
    // создаем массив для одного параметра
    @Parameterized.Parameters
    public static Object[] singleParam() {
        return new Object[] {100, 200, 300, 400};
    }



    // ПЕРВЫЙ ВАРИАНТ
    // объявляем поля класса
    // чтобы BalanceService был уникальынм для каждого запуска теста,
    // выносим его в поля класса и будем работать с ним уже в конструкторе
    // поле класса (BalanceService), который тестируем, создается в полях тестового класса
//    private final BalanceService balanceService;
//    private final int count;
//    private final int expected;

       // конструктор класса
    // принимает 2 параметра, которые будут переданы из провайдера (массива)
    // важно следить за порядком параметров в конструкторе
//    public BalanceServiceTest(int count, int expected) {
//        // объект класса (BalanceService), который тестируем, создается в конструкторе
//        this.balanceService = new BalanceService();
//        this.count = count;
//        this.expected = expected;
//    }

   // пишем тесты
//    @Test
//    public void testAddBalance() {
//        // обращаемся к полям класса
//        balanceService.add(count);
//        // первый аргумент - ОР
//        // второй аргумент - вызов getBalance, из которого получаем balance
//        assertEquals(expected, balanceService.getBalance());
//    }

//    @Test
//    public void testWithdrawBalance() {
//        balanceService.withdraw(count);
//        assertEquals(expected, balanceService.getBalance());
//    }


    // ВТОРОЙ И ТРЕТИЙ ВАРИАНТ
    // создаем поля для теста без конструктора
    // в этом случае поля не должны быть приватными
    @Parameterized.Parameter
    public int count;

    //ВТОРОЙ ВАРИАНТ
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
