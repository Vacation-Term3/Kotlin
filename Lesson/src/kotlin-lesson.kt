import java.util.*

fun main(args: Array<String>) {
    //variable()
    //bool_ean()
    //string()
    //arr()
    //range()
    //conditional()
    //looping()
    //functionL()
    //higherOrder()
    //collection()
    //exception() //use to handle error
    //lists()
    //maps()
    //classNinheritance()
    //interFace()
    //nULL()
}
/*fun nULL(){
    var nulVal: String? = null
    fun returnNull(): String?{
        return null
    }
    var nullVal2 = returnNull()
    if(nullVal2 != null){
        println("nullVal2.lenght")
    }
    var nulVal3 = nullVal2!!.length
    var nullVal4 : String = returnNull()?: "No Name"
}*/

fun interFace(){
    class Bird constructor(val name: String, override var flies: Boolean = true) : Flyable{
        override fun fly(distMile: Double): Unit{
            if(flies){
                println("$name flies $distMile miles")
            }
        }
    }
    val tweety = Bird("Tweety", true)
    tweety.fly(10.0)
}

interface Flyable{
    var flies: Boolean
    fun fly(distMile: Double): Unit
}

fun classNinheritance(){
    //Class
    open class Animal(val name: String, var height: Double, var weight: Double){
        init{
            val regex = Regex(".*\\d+.*")
            require(!name.matches(regex)){"Animal name Can't Contain Number"}
            require(height > 0){"Height must be Greater than 0"}
            require(weight > 0){"Weight mush be Greater than 0"}
        }
        open fun getInfo(): Unit{
            println("$name is $height tall and weight $weight")
        }
    }
    val bowser = Animal("Bowser", 20.0, 13.5)
    bowser.getInfo()

    //Inheritance
    class Dog(name: String, height: Double, weight: Double,
              var owner: String) : Animal(name, height, weight){
        override fun getInfo() : Unit{
            println("$name is $height tall and weight $weight and is owned by $owner")
        }
    }
    val spot = Dog("Spot", 20.0, 14.5, "Paul Smith")
    spot.getInfo()
}

fun maps(){
    val map = mutableMapOf<Int, Any?>()
    //val map2 = mutableMapOf(1 to "Doug", 2 to 25)

    map[1] = "Derek"
    map[2] = 42
    println("Map size : ${map.size}")
    map[3] = "Pittsburgh"
    //map.put(3, "Pittsburgh")
    map.remove(2)

    for((x,y) in map){
        println("Key : $x Value : $y")
    }
}

fun lists(){
    var list1: MutableList<Int> = mutableListOf(1,2,3,4,5) //Changeable list
    //val list2: List<Int> = listOf(1,2,3,4,5) //Unchangeable list

    list1.add(6)
    println("1st : ${list1.first()}")
    println("Last : ${list1.last()}")

    println("2nd : ${list1[2]}")
    var list3 = list1.subList(0, 3)
    println("Length : ${list1.size}")
    list3.clear()
    list1.remove(1)
    list1.removeAt(1)
    //list1[2] = 20
    list1.forEach{n -> println("Mutable List : $n")}
}

fun exception(){
    val divisor = 2
    try {
        if(divisor == 0){
            throw IllegalArgumentException("Can't Divide by Zero")
        } else {
            println("5 / $divisor = ${5/divisor}")
        }
    } catch (e: IllegalArgumentException){
        println("${e.message}")
    }
}

fun collection(){
    val numList2 = 1..20
    val listSum = numList2.reduce{x, y -> x + y}
    println("Reduce Sum : $listSum")  //Sum of the list

    val listSum2 = numList2.fold(5){x, y -> x + y}
    println("Fold Sum : $listSum2")   //Sum of the list but add more 5

    println("Evens : ${numList2.any { it % 2 == 0}}")
    println("Evens : ${numList2.all { it % 2 == 0}}")

    val big3 = numList2.filter { it > 3 }
    big3.forEach{n -> println("3 < $n")}

    val times7 = numList2.map { it * 7 }
    times7.forEach{n -> println("* 7 = $n")}
}

fun higherOrder(){
    val numList = 1..20
    val evenList = numList.filter { it % 2 == 0 }
    evenList.forEach{n -> println(n)}

    ////////////
    fun makeMath(num1: Int): (Int) -> Int = {num2 -> num2 * num1}
    val malt3 = makeMath(3)
    println("5 * 3 = ${malt3(5)}")

    ////////////
    fun mathOnList(numList: Array<Int>, myFunc: (num: Int) -> Int){
        for(num in numList){
            println("MathOnList ${myFunc(num)}")
        }
    }

    val multiply2 = {num1: Int -> num1*2}
    val numList2 = arrayOf(1,2,3,4,5)
    mathOnList(numList2, multiply2)

}

fun functionL(){
    fun add(num1: Int, num2: Int) : Int = num1 + num2
    fun sub(num1: Int = 1, num2: Int = 1) : Int = num1 - num2   //1 is default value
    //Call function add(), sub()
    println("5 + 4 = ${add(5,4)}")
    println("4 - 5 = ${sub(4,5)}")
    println("4 - 5 = ${sub(num2 = 5, num1 = 4)}")

    fun sayHello(name: String) : Unit = println("Hello $name")
    sayHello("Paul")

    //Function sum of list like an array
    fun getSum(vararg nums: Int): Int{
        var sum = 0
        nums.forEach { n -> sum += n}
        return sum
    }
    println("Sum = ${getSum(1,2,3,4,5)}")

    //Literal function
    val multiply = {num1: Int, num2: Int -> num1 * num2}
    println("5 * 3 = ${multiply(5,3)}")

    //Function return 2 value
    fun nextTwo(num: Int): Pair<Int, Int>{
        return Pair(num+1, num+2)
    }
    val (two, three) = nextTwo(1)
    println("Return 2 value function : 1 $two $three")

    //Factor
    fun fact(x: Int): Int{
        tailrec fun factTail(y: Int, z: Int): Int{
            return if(y == 0) z
            else factTail(y-1, y*z)
        }
        return factTail(x, 1)
    }
    println("5! = ${fact(5)}")
}

fun looping(){
    for(x in 1..10){
        println("Loop : $x")
    }

    val rand = Random()
    val magic = rand.nextInt(50) + 1

    var guess = 0

    while(magic != guess){
        guess += 1
    }

    println("Magic Number was $guess")

    //Continue and Break
    for(x in 1..20){
        if(x % 2 == 0){
            continue
        }
        println("Odd : $x")

        if(x == 15) break
    }

    var arr3: Array<Int> = arrayOf(3, 6, 9)

    for(i in arr3.indices){
        println("Mult 3 : ${arr3[i]}")
    }

    //Print value with index
    for((index, value) in arr3.withIndex()){
        println("Index : $index Value : $value")
    }
}

fun conditional(){
    // > < >= <= == !=
    // &&  || ! (logical)

    var age = 8
    if(age < 5){
        println("Go to Preschool")
    } else if(age == 5) {
        println("Go to Kindergarten")
    } else if((age > 5) && (age <= 17)){
        val grade = age - 5
        println("Go to Grade $grade")
    } else {
        println("Go to college!")
    }

    when(age){
        0, 1, 2, 3, 4 -> println("Go to Preschool!")
        5 -> println("Go to Kindergarten")

        in 6..17 -> {
            val grade = age - 5
            println("Go to Grade $grade")
        }
        else -> println("Go to college")
    }
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
    var partArray = myArray.copyOfRange(0, 2)
    println("Part of array: "+partArray[1])

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
