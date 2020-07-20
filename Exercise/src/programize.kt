//import kotlin.io.print as print

fun main(args: Array<String>){
    //datatype()
    //operator()
    //conversion()
    //expressionStatementAndBlock()

}
fun expressionStatementAndBlock(){
    //Expression
    val score: Int = 90 + 25 // if we return score then its value is Integer
    println(score)
    val a = 12 // if Expression
    val b = 13
    val max: Int
    max = if (a > b) a else b
    println("$max")

    //Statements - everything that make up a complete unit of execution - here is example
    val score2 = 90 + 25
    /* while 90 + 25 is an expression, also Expressions are part of statements. */

    //Blocks
    val flag = true
    if (flag) {      // start of if block
        println("Hey ")
        println("jude!")
    }               // end of if block
}
fun conversion(){
    //Convert from int to long
    val number1: Int = 55
    val number2: Long = number1.toLong()
    println("number2 = $number2")
    /* toByte() toShort() toInt() toLong() toFloat() toDouble() toChar() */

    //Conversion from Larger to Smaller Type
    val numb1: Int = 545344
    val numb2: Byte = number1.toByte()
    println("number2 = $numb2")
}

fun operator(){ /*
    Arithmetic Operators:
    + Addition (also used for string concatenation)
    - Subtraction
    * Multiplication
    / Division
    % Modulus */

    // String concatenation example
    println("String concatenation example:")
    val start = "Talk is cheap. "
    val middle = "Show me the code. "
    val end = "- Linus Torvalds"
    val result = start + middle + end
    println(result)

    // Operator Overloading
    println("Operator Overloading:")
    var a = 7
    var b = 4
    println(a.plus(b))
    println(a.minus(b))
    println(a.times(b)) // *
    println(a.rem(b))

    // Comparison and Equality Operators
    println("Comparison and Equality:")
    println(a.compareTo(b)) // operator > < >= <=
    println(a?.equals(b)?:(b===null)) // operator ==
    println(!a?.equals(b)?:(b==null)) // operator !=

    // Logical operator
    println("Logical operator:")
    // two type are || and &&
    println(a > b || a != b)
    println(a > b && a != b)

    // in Operator
    val numbers = intArrayOf(1, 4, 42, -3)
    if (4 in numbers) {
        println("numbers array contains 4.")
    }

    // Index access Operator
    print(numbers[0]) // numbers.get(0)

    // Invoke Operator
    //print(numbers(0))

    // Bitwise Operation

}

fun datatype(){ /*
    - val (Immutable reference) - The variable declared using val keyword cannot be changed once
    the value is assigned. It is similar to final variable in Java.
    - var (Mutable reference) - The variable declared using var keyword can be changed later in
    the program. It corresponds to regular Java variable.

    Built-in types categorized as:
    - Numbers
    - Characters
    - Booleans //flag
    - Arrays

    To represent number:
    - Byte : -128 to 127 (8-bit signed two's complement integer).
    - Short : -32768 to 32767 (16-bit signed two's complement integer).
    - Int : -2^31 to 2^31-1 (32-bit signed two's complement integer).
    - Long : -2^63 to 2^63-1 (64-bit signed two's complement integer).
    - Float : single-precision 32-bit floating point.
    - Double : double-precision 64-bit floating point. */
}