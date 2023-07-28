fun main(args: Array<String>) {

    //Task 1: Calculate average of a list of numbers
    val numberList = listOf(1,2,3,4,5,6,7,8,9,10)
    println("The average of the list is: ${numberAverage(numberList)}")


}

fun numberAverage(_numbersList: List<Int>): Double{
    val sum_numbers = _numbersList.reduce{counter, num -> counter + num}
    return sum_numbers.toDouble()/_numbersList.size
}

