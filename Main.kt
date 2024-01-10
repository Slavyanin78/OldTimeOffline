package ru.netology


fun main() {
    val agoTimeOffline = 1000000
    val text = agoTimeText(agoTimeOffline)
    println(text)
}

fun agoTimeText(agoTimeOffline: Int): String {
    val x = agoTimeOffline
    return when {
        x > -1 && x < 61 -> "Был(а) только что"
        x > 60 && x < 3601 -> "Был(а) " + (x / 60).toInt() + minute(x) + " назад"
        x > 3600 && x < 86401 -> "Был(а) " + (x / 3600).toInt() + hour(x) + " назад"
        x > 86400 && x < 172800 -> "Был(а) вчера"
        x > 172800 && x < 259200 -> "Был(а) позавчера"
        else -> "Был(а) давно"

    }
}

fun minute(agoTimeOffline: Int): String {
    val x = agoTimeOffline
    return when {
        (x / 60) % 100 === 11 -> " минут"
        (x / 60) % 10 === 1 -> " минуту"
        ((x / 60) > 1 && (x / 60) < 5) -> " минуты"
        ((x / 60) % 10 > 1 && (x / 60) % 100 < 21) -> " минут"
        ((x / 60) % 10 === 2 && (x / 60) % 100 > 20) || ((x / 60) % 10 === 3 && (x / 60) % 100 > 20) ||
                ((x / 60) % 10 === 4 && (x / 60) % 100 > 20) -> " минуты"

        ((x / 60) % 10 === 5 && (x / 60) % 100 > 20) || ((x / 60) % 10 === 6 && (x / 60) % 100 > 20) ||
                ((x / 60) % 10 === 7 && (x / 60) % 100 > 20) || ((x / 60) % 10 === 8 && (x / 60) % 100 > 20) ||
                ((x / 60) % 10 === 9 && (x / 60) % 100 > 20) -> " минут"

        else -> " минут"
    }
}

fun hour(agoTimeOffline: Int): String {
    val x = agoTimeOffline
    return when {
        (x / 3600) %100 === 11 -> " часов"
        (x / 3600) %10 === 1  -> " час"
        ((x / 3600) >= 2 && (x / 3600) < 5) || ((x / 3600) > 21 && (x / 3600) < 25) -> " часа"
        else -> " часов"

    }
}