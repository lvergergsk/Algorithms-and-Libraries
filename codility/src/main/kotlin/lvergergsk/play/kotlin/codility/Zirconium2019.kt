package lvergergsk.play.kotlin.codility

import kotlin.math.abs
import kotlin.math.max

//A company has employed N developers (numbered from 0 to N−1) and wants to divide them into two teams. The first is a front-end team with F developers. The second is a back-end team with N−F developers. If the K-th developer is assigned to the front-end team then their contribution is A[K], and if they are assigned to the back-end team then their contribution is B[K]. What is the maximum sum of contributions the company can achieve?
//Write a function:
//class Solution { public int solution(int[] A, int[] B, int F); }
//that, given two arrays A, B (consisting of N integers each) and the integer F, returns the maximum sum of contributions the company can achieve.
//Examples:
//1. Given A = [4, 2, 1], B = [2, 5, 3] and F = 2, the function should return 10. There should be two front-end developers and one back-end developer. The 0th and 2nd developers should be assigned to the front-end team (with contributions 4 and 1) and the 1st developer should be assigned to the back-end team (with contribution 5).
//2. Given A = [7, 1, 4, 4], B = [5, 3, 4, 3] and F = 2, the function should return 18. The 0th and 3rd developers should be assigned to the front-end team and the 1st and 2nd developers should be assigned to the back-end team.
//3. Given A = [5, 5, 5], B = [5, 5, 5] and F = 1, the function should return 15. The 0th developer can be assigned to the front-end team and the 1st and 2nd developers can be assigned to the back-end team.
//Write an efficient algorithm for the following assumptions:
//N is an integer within the range [1..200,000];
//arrays A and B have equal lengths;
//each element of array A is an integer within the range [0..1,000];
//F is an integer within the range [0..N].

fun solution(A: IntArray, B: IntArray, F: Int): Int {
    // write your code in Kotlin
    return maxTotalContribution(A, B, F)
}

fun maxTotalContribution(
    frontendContribution: IntArray,
    backendContribution: IntArray,
    frontendCount: Int
): Int {
    assert(frontendContribution.size == backendContribution.size)
    assert(backendContribution.size > frontendCount)
    assert(frontendCount >= 0)

    val difference = (0 until frontendContribution.size).map { frontendContribution[it] - backendContribution[it] }
    val precedence = (0 until frontendContribution.size).sortedBy { -abs(difference[it]) }

    println("difference: ${difference}")
    println("precedence: ${precedence}")

    var frontendCountRemain = frontendCount
    var backendCountRemain = frontendContribution.size - frontendCount
    var res = 0
    for (i in precedence) {
        when {
            frontendCountRemain == 0 -> {
                println("res == ${res}, res += ${backendContribution[i]}")
                res += backendContribution[i]
                backendCountRemain--
            }
            backendCountRemain == 0 -> {
                println("res == ${res}, res += ${frontendContribution[i]}")
                res += frontendContribution[i]
                frontendCountRemain--
            }
            else -> {
                if (frontendContribution[i]>backendContribution[i]){
                    res+=frontendContribution[i]
                    frontendCountRemain--
                }else{
                    res+=backendContribution[i]
                    backendCountRemain--
                }
            }
        }
        println("backendCountRemain == ${backendCountRemain}")
        println("frontendCountRemain == ${frontendCountRemain}")
    }
    return res
}

