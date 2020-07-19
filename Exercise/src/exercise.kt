import java.math.RoundingMode
import java.nio.file.Paths
import java.text.DecimalFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.*
import java.util.concurrent.TimeUnit
import java.util.Calendar
import kotlin.experimental.and

fun main(args: Array<String>){
    //Var is general variable, assigned multiple times, mutable variable.
    //exercise1() //How to Print an Integer entered by an user in Kotlin using Scanner
    //exercise2() //How to Print an Integer without using Scanner
    //exercise3() //Kotlin Program to Add Two Integers
    //exercise4() //Kotlin Program to Multiply two Floating Point Numbers
    //exercise5() //Kotlin Program to Find ASCII value of a character
    //exercise6() //Compute Quotient and Remainder
    //exercise7() //Swap two numbers
    //exercise8() //Check whether a number is even or odd
    //exercise9() //Find Frequency of Character
    //exercise10() //Program to Remove All Whitespaces
    //exercise11() //Round a Number
    //exercise12() //Convert String to Date
    //exercise13() //Get Current date and time
    //exercise14() //Convert Milliseconds to Minutes and Seconds
    //exercise15() //Add Two Dates
    //exercise16() //Get Current Working Directory
    exercise17() //Convert Byte Array to Hexadecimal
}
fun exercise17(){
    //Convert Byte Array to Hex value
    val byte = byteArrayOf(16,12,3,14)
    for(b in byte){
        val st = String.format("%02X", b) //%02X to print two places (02) of Hexadecimal (X)
        print(st)
    }

    //Convert Byte Array to Hex value using byte operations
    val hexArray = "0123456789ABCDEF".toCharArray()
    fun bytesToHex(byte: ByteArray): CharArray {
        val hexChar = CharArray(byte.size * 2)
        for(j in byte.indices){
            val v = (byte[j] and 0xFF.toByte()).toInt()

            hexChar[j * 2] = hexArray[v ushr 4]
            hexChar[j * 2 + 1] = hexArray[v and 0x0F]
        }
        return hexChar
    }
    val s = bytesToHex(byte)
    println("")
    println(s)

}
fun exercise16(){
    //Get current working directory
    var path = System.getProperty("user.dir")
    println("Working directory is $path")

    //Get current working directory using Path
    path = Paths.get("").toAbsolutePath().toString()
    println("Working directory is $path")
}

fun exercise15(){
    val cal1 = Calendar.getInstance()
    val cal2 = Calendar.getInstance()
    val addCal = cal1.clone() as Calendar

    addCal.add(Calendar.YEAR, cal2.get(Calendar.YEAR))
    addCal.add(Calendar.MONTH, cal2.get(Calendar.MONTH))
    addCal.add(Calendar.DATE, cal2.get(Calendar.DATE))
    addCal.add(Calendar.HOUR_OF_DAY, cal2.get(Calendar.HOUR_OF_DAY))
    addCal.add(Calendar.MINUTE, cal2.get(Calendar.MINUTE))
    addCal.add(Calendar.SECOND, cal2.get(Calendar.SECOND))
    addCal.add(Calendar.MILLISECOND, cal2.get(Calendar.MILLISECOND))

    println("Result of sum(2 dates) is ${addCal.time}")
}

fun exercise14(){
    //Convert milliseconds to minutes and seconds individually
    val milliseconds: Long = 1000000
    var minute = TimeUnit.MILLISECONDS.toMinutes(milliseconds)
    var second = TimeUnit.MILLISECONDS.toSeconds(milliseconds)
    println("${milliseconds}ms = ${minute}mn = ${second}s")

    //Convert Milliseconds to Minutes and Seconds
    minute = milliseconds/1000/60
    second = milliseconds/1000%60
    println("${milliseconds}ms = ${minute}mn${second}s")
}

fun exercise13(){
    var currentDate = LocalDateTime.now()
    //Get Current date and time in default format
    println("Date and Time now are $currentDate")

    //Get Current date and time with pattern
    var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    var formatted = currentDate.format(formatter)
    println("Date and Time now are $formatted")

    //Get Current Date time using predefined constants
    formatter = DateTimeFormatter.ISO_DATE  //or BASIC_ISO_DATE
    formatted = currentDate.format(formatter)
    println("Date and Time now are $formatted")

    //Get Current Date time in localized style
    formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
    formatted = currentDate.format(formatter)
    println("Date and Time now are $formatted")
}

fun exercise12(){
    //using predefined formatter
    val string = "2017-04-25" // Format y-M-d or yyyy-MM-d
    val date = LocalDate.parse(string, DateTimeFormatter.ISO_DATE)
    println(date)

    //using pattern formatter
    val string2 = "July 25, 2017" // Format y-M-d or yyyy-MM-d
    val formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH)
    val date2 = LocalDate.parse(string2, formatter)
    println(date2)
}

fun exercise11(){
    //using format
    val num = 1.234567
    println("$num to %.4f".format(num))

    //using decimal format
    val df = DecimalFormat("#.####")
    df.roundingMode = RoundingMode.CEILING
    println("$num to " + df.format(num))
}

fun exercise10(){
    var str: String = "S    T    U   D  E   N   T"
    str = str.replace("\\s".toRegex(),"")
    println("Final result : $str")
}

fun exercise9(){
    val str: String = "I am Sothea, I am from Cambodia"
    val check: Char = 'a'
    var frequency = 0;
    //for(i in 0..str.length - 1){
    for(element in str){
        if(check == element) ++frequency
    }
    println("Frequency of '$check' in String is : $frequency")
}

fun exercise8(){
    var input = Scanner(System.`in`)
    print("Enter a number : ")
    var integer = input.nextInt()

    //using if...else statement
    if(integer % 2 == 0) println("It is even number")
    else println("It is odd number")

    //using if...else expression
    var evenOdd = if(integer % 2 == 0) "even" else "odd"
    println("$integer is a $evenOdd number!")
}

fun exercise7(){
    fun swap(numb1: Int, numb2: Int): Pair<Int, Int>{
        return Pair(numb2, numb1)
    }
    //Method 1
    var num1 = 2
    var num2 = 5
    num1 = num2.also { num2 = num1 }
    println("Number 1: $num1, Number 2: $num2")

    //Method 2
    num1 = 2
    num2 = 5
    num1 -= num2
    num2 += num1
    num1 = num2 - num1
    println("Number 1: $num1, Number 2: $num2")

    //Method 3
    var numb1 = 2
    var numb2 = 5
    var p = swap(numb1, numb2)
    println("Number 1: ${p.first}, Number 2: ${p.second}")
}

fun exercise6(){
    var dividend = 25
    var divisor = 4
    println("Quotient is ${dividend/divisor}")
    println("Reminder is ${dividend%divisor}")
}

fun exercise5(){
    val character: Char = 'A'
    val ascii = character.toInt()
    println("ASCII of 'A' is $ascii")
}

fun exercise4(){
    val first = 2.5f
    val sec = 3.5f
    println("Multiply is ${first*sec}")
}

fun exercise3(){
    print("Enter first number : ")
    val int1 = readLine()!!
    print("Enter second number : ")
    val int2 = readLine()!!
    var integer = int1.toInt() + int2.toInt()
    println("Result is : $integer")
}

fun exercise2(){
    print("Enter a number : ")
    val stringInput = readLine()!!
    var toInt: Int = stringInput.toInt()
    println("You entered $toInt")
}

fun exercise1(){
    val reader = Scanner(System.`in`)
    print("Enter a number : ")
    var integer: Int = reader.nextInt()
    println("You entered $integer")
}