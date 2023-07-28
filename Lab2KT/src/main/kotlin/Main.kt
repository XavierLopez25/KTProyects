
fun main(args: Array<String>) {

    //Task 1: Calculate average of a list of numbers
    val numberList = listOf(1,2,3,4,5,6,7,8,9,10)
    println("The average of the list is: ${numberAverage(numberList)} \n")

    //Task 2: Extract only odd numbers from a list
    val oddNumbers: List<Int> = numberList.filter { it % 2 == 1 }
    println("The odd numbers from the list are: $oddNumbers \n")

    //Task 3: Check if a word is a palindrome
    val word = "radar"
    val word2 = "nothing"
    println((if (isPalindrome(word)) "\nThe word $word is a palindrome." else "\nThe word $word isn't a palindrome."))
    println((if (isPalindrome(word2)) "\nThe word $word is a palindrome." else "\nThe word $word isn't a palindrome."))

    //Task 4: Add a function that says "Hi, (name)!"
    var nameList: List<String> = listOf("Xavier", "Aroldo", "Javier", "James")
    nameList = nameList.map { name -> "\nHi $name!" }
    nameList.forEach{name -> println(name)}

    //Task 5: performOperation lambda
    println("\nThe result of the sum 7+8 is: ${lambdaOperation(7,8) { a, b -> a + b }}")
    println("\nThe result of the sum 1-6 is: ${lambdaOperation(7,8) { a, b -> a - b }}")

    //Task 6: Working with Data Class
    val person = Person("Xavier", 18, "Male")
    val person2 =  Person("Alex" , 22, "Female")
    val listStudent =  mutableListOf<Student>()

    val student = personToStudentMap(person, listStudent.size)
    val student1 = personToStudentMap(person2, listStudent.size)

    listStudent.add(student)
    listStudent.add(student1)
    listStudent.forEach{
        student_ -> println(student_.toString())
    }

}

fun numberAverage(numbersList: List<Int>): Double{
    val sumNumbers = numbersList.reduce{ counter, num -> counter + num}
    return sumNumbers.toDouble()/numbersList.size
}

fun isPalindrome(inputWord: String): Boolean = inputWord.reversed() == inputWord

fun lambdaOperation(num1: Int, num2: Int, operation: (Int, Int) -> Int): Int{
    return operation(num1, num2)
}

data class  Person(val name: String, val age: Int, val gender: String)

data class Student(val name: String, val age: Int, val gender: String, val studentId: Int){
    override fun toString(): String{
        return "\nThe student $name has $age y/o."
    }
}

fun personToStudentMap(person: Person, length: Int): Student{
    return Student(person.name, person.age, person.gender , length + 1)
}



