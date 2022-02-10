import kotlin.math.roundToInt

val cardType = "Maestro"
val transferSum = 75020_00
val amount = 2010_00
var sum: Double = 0.0

fun main() {
    println("Размер комиссии: ${transferCalc(cardType, transferSum, amount)}")
}

fun transferCalc(
    cardType: String = "VK Pay",
    transferSum: Int = 0,
    amount: Int = 1000_00,
): String = when(cardType) {
    "Mastercard", "Maestro" -> masterCom(transferSum, amount)
    "Visa", "Мир" -> visaCom(transferSum, amount)
    "VK Pay" -> vkPay(transferSum, amount)
    else -> "некорректная операция"
}

fun masterCom(transferSum: Int = 0, amount: Int = 0): String = when {
    transferSum <= 75000_00 -> formatResult(sum)
    transferSum in 75000_00..600000_00 -> {
        sum = ((amount * 0.006).roundToInt() + 20_00).toDouble()
        formatResult(sum)
    }
    else -> "Лимит по карте превышен"
}

fun visaCom(transferSum: Int = 0, amount: Int = 0) = when {
    transferSum <= 600000_00 && amount * 0.0075 <= 35_00 -> formatResult(3500.0)
    transferSum <= 600000_00 && amount * 0.0075 > 35_00 -> {
        sum = (amount * 0.0075)
        formatResult(sum)
    }
    else -> "Лимит по карте превышен"
}

fun vkPay(transferSum: Int = 0, amount: Int = 0) = when {
    transferSum <= 40000_00 && amount <= 15000_00 -> formatResult(sum)
    else -> "Лимит по карте превышен"
}

fun formatResult(sum: Double): String = when {
    sum.toInt() % 100 != 0 -> "${sum.toInt() / 100} руб. ${(sum % 100).toInt()} коп."
    else -> "${sum.toInt() / 100} руб. 00 коп."
}