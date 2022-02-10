import org.junit.Test

import org.junit.Assert.*
import org.junit.Ignore

class Task_1KtTest {

    @Test
    @Ignore
    fun formatResult() {
    }

    @Test
    fun transferCalc() {
        //arrange
        val cardType = "VK Pay"
        val transferSum = 0
        val amount = 1000_00
        val expected = "0 руб. 00 коп."

        //act
        val result = transferCalc(
            cardType = cardType,
            transferSum = transferSum,
            amount = amount
        )

        //assert
        assertEquals(expected, result)
    }

    @Test
//    @Ignore
    fun transferCalc_shouldCalcMaestroMore75000() {
        //arrange
        val cardType = "Maestro"
        val transferSum = 75020_00
        val amount = 2010_00
        val expected = "32 руб. 6 коп."

        //act
        val result = transferCalc(
            cardType = cardType,
            transferSum = transferSum,
            amount = amount
        )

        //assert
        assertEquals(expected, result)
    }

    @Test
    fun transferCalc_shouldCalcMaestroLess75000() {
        //arrange
        val cardType = "Maestro"
        val transferSum = 74020_00
        val amount = 2010_00
        val expected = "0 руб. 00 коп."

        //act
        val result = transferCalc(
            cardType = cardType,
            transferSum = transferSum,
            amount = amount
        )

        //assert
        assertEquals(expected, result)
    }

    @Test
    fun vkPay_default() {
        //arrange
        val expectedTax = "Лимит по карте превышен"

        //act
        val result = vkPay(transferSum = transferSum, amount = amount)

        //assert
        assertEquals(expectedTax, result)
    }

    @Test
    fun masterCom_shouldTestLess75000() {
        //arrange
        val transferSum = 74020_00
        val amount = 2010_00
        val expected = "0 руб. 00 коп."

        //act
        val result = masterCom(transferSum = transferSum, amount = amount)

        //assert
        assertEquals(expected, result)
    }

    @Test
    fun masterCom_shouldTestMore75000() {
        //arrange
        val transferSum = 75020_00
        val amount = 2010_00
        val expected = "32 руб. 6 коп."

        //act
        val result = masterCom(transferSum = transferSum, amount = amount)

        //assert
        assertEquals(expected, result)
    }

    @Test
    fun masterCom_shouldTestMore600000() {
        //arrange
        val transferSum = 750020_00
        val amount = 2010_00
        val expected = "Лимит по карте превышен"

        //act
        val result = masterCom(transferSum = transferSum, amount = amount)

        //assert
        assertEquals(expected, result)
    }

    @Test
    fun visaCom_shouldTestMore600000() {
        //arrange
        val transferSum = 750020_00
        val amount = 2010_00
        val expectedTax = "Лимит по карте превышен"

        //act
        val result = visaCom(transferSum = transferSum, amount = amount)

        //assert
        assertEquals(expectedTax, result)
    }

    @Test
    fun visaCom_shouldTestLess35() {
        //arrange
        val transferSum = 75020_00
        val amount = 2010_00
        val expectedTax = "35 руб. 00 коп."

        //act
        val result = visaCom(transferSum = transferSum, amount = amount)

        //assert
        assertEquals(expectedTax, result)
    }

    @Test
    fun visaCom_shouldTestMore35() {
        //arrange
        val transferSum = 75020_00
        val amount = 20100_00
        val expectedTax = "150 руб. 75 коп."

        //act
        val result = visaCom(transferSum = transferSum, amount = amount)

        //assert
        assertEquals(expectedTax, result)
    }

    @Test
    fun vkPay_shouldTestLess40000() {
        //arrange
        val transferSum = 7502_00
        val amount = 2010_00
        val expectedTax = "32 руб. 6 коп."

        //act
        val result = vkPay(transferSum = transferSum, amount = amount)

        //assert
        assertEquals(expectedTax, result)
    }

    @Test
    fun vkPay_shouldTestMore40000() {
        //arrange
        val transferSum = 75020_00
        val amount = 20100_00
        val expectedTax = "Лимит по карте превышен"

        //act
        val result = vkPay(transferSum = transferSum, amount = amount)

        //assert
        assertEquals(expectedTax, result)
    }


}