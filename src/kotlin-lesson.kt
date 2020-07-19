fun main(args: Array<String>) {
    //variable()
    //bool_ean()
    //string()
    //arr()
    //range()
    conditional()
}

fun conditional(){

}

fun range(){
    val oneTo10 = 1..10
    val alpha = "A".."Z"

    //Search in range
    println("R in Alpha : ${"R" in alpha}")

    //Range downward
    val tenTo1 = 10.downTo(1)
    val twoTo20 = 2.rangeTo(20)

    //Cross 3 steps like 1-4-7-...
    val rng3 = oneTo10.step(3)

    for(x in rng3) println("rng3 : $x")

    for(x in tenTo1.reversed()) println("Reverse : $x")
}

fun arr(){
    var myArray = arrayOf(2, 1.23, "Doug")
    println(myArray[2])

    myArray[1] = 3.14

    println("Array Length : ${myArray.size}")
    println("Doug is Array : ${myArray.contains("Doug")}")

    //Get part of array
    var partArray = myArray.copyOfRange(0, 1)

    //Get first element
    println("First : ${myArray.first()}")

    //Search where index that data store in array
    println("Doug Index : ${myArray.indexOf("Doug")}")


    //II. Collection
    var sqArray = Array(5, { x -> x * x})

    println("Index 2 : " + sqArray[2])

    var arr2: Array<Int> = arrayOf(1,2,3)
    println("Array 2 : " + arr2[2])
}

fun string(){
    //Not change
    //val myName = "Sothea Cheng"
    val longStr = """This is long string"""

    //
    var fName: String = "Doug"
    var lName: String = "Smith"

    fName = "Sally"

    var fullName = fName + " " + lName

    println("Name : $fullName")
    println("1 + 1 = ${1+2}")
    println("String Length : ${longStr.length}")

    var str1 = "A random string"
    var str2 = "a random string"

    println("Strings Equal : ${str1.equals(str2)}")

    println("Compare A to B : ${"A".compareTo("B")}")

    println("2nd Index:  ${str1[2]}")
    println("2nd Index:  ${str1.get(2)}")

    //print index m to n
    println("Index 2 - 7 : ${str1.subSequence(2, 8)}")

    //check if string contain of a string
    println("Index 2 - 7 : ${str1.contains("random")}")
}

fun bool_ean(){
    if(true is Boolean){
        println("True is boolean\n")
    }

    var letterGrade: Char = 'A'
    println("A is a  Char : ${letterGrade is Char}")

    println("3.14 to Int: "+(3.14.toInt()))
    println("A to Int : "+('A'.toInt()))
    println("65 to Character : "+ 65.toChar())
}

fun variable(){
    println("Hello, World!")

    //val name = "Soteah"
    //var myAge = 22

    //Int
    var bigInt: Int = Int.MAX_VALUE
    var smallInt: Int = Int.MIN_VALUE

    println("Biggest Int: "+ bigInt)
    println("Smallest Int: $smallInt")

    //Long

    var bigLong: Long = Long.MAX_VALUE
    var smallLong: Long = Long.MIN_VALUE

    println("Biggest Long: "+ bigLong)
    println("Smallest Long: $smallLong")

    //Double
    var bigDouble: Double = Double.MAX_VALUE
    var smallDouble: Double = Double.MIN_VALUE

    println("Biggest Double: "+ bigDouble)
    println("Smallest Double: $smallDouble")

    //Float
    var bigFloat: Float = Float.MAX_VALUE
    var smallFloat: Float = Float.MIN_VALUE

    println("Biggest Float: "+ bigFloat)
    println("Smallest Float: $smallFloat")

    //Boolean

    //Short
    var bigShort: Short = Short.MAX_VALUE
    var smallShort: Short = Short.MIN_VALUE

    println("Biggest Short: "+ bigShort)
    println("Smallest Short: $smallShort")

    //Byte
    var bigByte: Byte = Byte.MAX_VALUE
    var smallByte: Byte = Byte.MIN_VALUE

    println("Biggest Byte: "+ bigByte)
    println("Smallest Byte: $smallByte")

    //Char

    var dblNum1: Double = 1.111111111111111111
    var dblNum2: Double = 1.111111111111111111

    println("Sum: "+(dblNum1 + dblNum2)) //Sixteen digit

}
