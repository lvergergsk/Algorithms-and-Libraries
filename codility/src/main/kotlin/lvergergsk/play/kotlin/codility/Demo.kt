package lvergergsk.play.kotlin.codility

//This is a demo task.
//Write a function:
//fun solution(A: IntArray): Int
//that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
//For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
//Given A = [1, 2, 3], the function should return 4.
//Given A = [−1, −3], the function should return 1.
//Write an efficient algorithm for the following assumptions:
//N is an integer within the range [1..100,000];
//each element of array A is an integer within the range [−1,000,000..1,000,000].

fun solution(A: IntArray): Int {
    // write your code in Kotlin
    return minimumUnexisted(A)
}

fun minimumUnexisted(existed: IntArray): Int {
    // plwrite your code in Kotlin
    val set = existed.toSet()
    for (i in 1..100001){
        if (!set.contains(i)) return i
    }
    return -1
}
