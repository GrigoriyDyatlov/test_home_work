import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SimpleAccountTest {

    public static Stream<Arguments> testAddWithParameters() {
        return Stream.of(
                Arguments.of(109999678, 109999678),
                Arguments.of(-100000678, 0),
                Arguments.of(0, 0));

    }

    public static Stream<Arguments> testTransferWithParameters() {
        return Stream.of(
                Arguments.of(2000, 2025, 25, 25, 2025),
                Arguments.of(3005, 3005, 10, 0, 3015));
    }

    @Test
    public void testPay() {
        //arrege
        Account sut = new SinpleAccount();
        sut.add(20000);
        long expected = 5000;

        //act
        boolean result = sut.pay(15000);
        long actualBalance = sut.getBalance();
        //assert
        Assertions.assertEquals(expected, actualBalance);
        Assertions.assertTrue(result);
    }

    @MethodSource
    @ParameterizedTest
    public void testAddWithParameters(long amount, long expected) {
        //arrange
        Account sut = new SinpleAccount();

        //act
        sut.add(amount);

        //assert
        long result = sut.getBalance();
        Assertions.assertEquals(expected, result);
    }

    @MethodSource
    @ParameterizedTest
    public void testTransferWithParameters(long amount, long balanceSut1, long balanceSut2, long executeBalanceSut1, long executeBalanceSut2) {
        //arrange
        Account sut1 = new SinpleAccount();
        sut1.add(balanceSut1);
        Account sut2 = new SinpleAccount();
        sut2.add(balanceSut2);

        //act
        boolean result = sut1.transfer(sut1, sut2, amount);
        long currentBalance1 = sut1.getBalance();
        long currentBalance2 = sut2.getBalance();
        //assert
        Assertions.assertTrue(result);
        Assertions.assertEquals(executeBalanceSut1, currentBalance1);
        Assertions.assertEquals(executeBalanceSut2, currentBalance2);
    }

}
