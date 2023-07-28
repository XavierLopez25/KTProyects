fun main(args: Array<String>) {

    //Task 1: Calculate average of a list of numbers
    val numberList = listOf(1,2,3,4,5,6,7,8,9,10)
    println("The average of the list is: ${numberAverage(numberList)} \n")

    //Task 2: Extract only odd numbers from a list
    val oddNumbers: List<Int> = numberList.filter { it % 2 == 1 }
    println("The odd numbers from the list are: $oddNumbers \n")

    

}

fun numberAverage(_numbersList: List<Int>): Double{
    val sumNumbers = _numbersList.reduce{ counter, num -> counter + num}
    return sumNumbers.toDouble()/_numbersList.size
}




