package com.example.programmers

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        solution("Z", 10)
    }

    //시저 암호
    fun solution(s: String, n: Int): String {
        var answer = ""
        for (i in s.indices) {
            answer += when {
                s.toCharArray()[i].toInt() + n in 91..96 || s.toCharArray()[i].toInt() + n > 122 -> s.toCharArray()[i] + n - 26
                s.toCharArray()[i] == ' ' -> ' '
                s.toCharArray()[i].toInt() in 65..90 && s.toCharArray()[i].toInt() + n > 90 -> s.toCharArray()[i] + n - 26
                else -> s.toCharArray()[i] + n
            }
        }
        return answer
    }

//    //K번째수
//    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
//        var answer = intArrayOf()
//        for (item in commands) answer += array.slice(item[0]-1 until item[1]).sorted()[item[2]-1]
//        return answer
//    }

//    //2016년
//    fun solution(a: Int, b: Int): String {
//        var answer = ""
//        var calendar = Calendar.getInstance()
//        calendar.set(2016,a-1,b)
//        answer = SimpleDateFormat("EEE", Locale.ENGLISH).format(calendar.timeInMillis).toUpperCase()
//        return answer
//    }

//    //나누어 떨어지는 숫자 배열
//    fun solution(arr: IntArray, divisor: Int): IntArray {
//        var answer = intArrayOf()
//        for (element in arr) if (element%divisor == 0) answer += element
//        if (answer.isEmpty()) answer += -1 else answer = answer.sorted().toIntArray()
//        return answer
//    }

//    //두 정수 사이의 합
//    fun solution(a: Int, b: Int): Long {
//        var answer: Long = 0
//        if (a > b) for (i in b..a) answer +=i else for (i in a..b) answer += i
//        return answer
//    }

//    //문자열 내림차순으로 배치하기
//    fun solution(s: String): String {
//        var answer = ""
//        for (item in s.toCharArray().sortedDescending()) answer += item
//        return answer
//    }

//
//    //서울에서 김서방 찾기
//    fun solution(seoul: Array<String>): String {
//        var answer = ""
//        for ((count, item) in seoul.withIndex()) if (item == "Kim") answer = "김서방은 " + count + "에 있다"
//        return answer
//    }

//    //수박수박수박수박수박수?
//    fun solution(n: Int): String {
//        var answer = ""
//        val str = "수박"
//        for (i in 1..n/2) answer += str
//        if (n%2 != 0) answer += '수'
//        return answer
//    }

//    //약수의 합
//    fun solution(n: Int): Int {
//        var answer = 0
//        for(i in 1..n) if (n%i == 0) answer += i
//        return answer
//    }

//    //이상한 문자 만들기
//    fun solution(s: String): String {
//        var answer = ""
//        var cnt = 0
//        for (i in s.indices) {
//            if (s[i] == ' ') cnt = -1
//            answer += if (cnt%2 == 0) s[i].toUpperCase() else s[i].toLowerCase()
//            cnt++
//        }
//        return answer
//    }

    //자연수 뒤집어 배열로 만들기
//    fun solution(n: Long): IntArray {
//        var answer = intArrayOf()
//        n.toString().map { answer += it.toInt() - 48 }
//        return answer.reversedArray()
//    }

//    //정수 내림차순으로 배치하기
//    fun solution(n: Long): Long {
//        var answer: Long = 0
//        answer = String(n.toString().toCharArray().sortedArrayDescending()).toLong()
//        return answer
//    }

//    //정수의 제곱근 찾기
//    fun solution(n: Long): Long {
//        var answer: Long = 0
//        for (x in 1.. n ) {
//            if (n/x == x && n%x == 0L) {
//                answer = (x+1)*(x+1)
//                break
//            } else answer = -1
//        }
//        println(answer)
//        return answer
//    }

//    fun solution(s: String): Boolean {
//        var answer = true
//        if (s.length == 4 || s.length == 6) {
//            for (item in s) if (item.isDigit()) answer = true else { answer = false
//                    break }
//        } else answer = false
//        return answer
//    }

//    fun solution(n: Int): Int {
//        var answer = 0
//        var count = n
//        while (count > 0) {
//            answer += count % 10
//            count /= 10
//        }
//        return answer
//    }

//    fun solution(s: String): String {
//        var answer = ""
//        val size = s.length
//        answer = if (size%2 == 0) s.substring(size/2-1..size/2) else s[size/2].toString()
//        return answer
//    }

//    fun solution(arr: IntArray): IntArray {
//        var answer = intArrayOf()
//        answer = if (arr.size == 1) intArrayOf(-1) else arr.filter { it != arr.min() }.toIntArray()
//        return answer
//    }

    //    fun solution(n: Int, m: Int): IntArray {
//        val answer = intArrayOf((gcd(n,m)),(n*m/gcd(n,m)))
//        return answer
//    }
//    fun gcd(n: Int, m: Int): Int = if (min(n, m) == 0) max(n, m)
//    else gcd(min(n, m), max(n, m) % min(n, m))

//    fun solution(num: Int): Int {
//        var answer = 0
//        var result = num.toLong()
//
//        while (result != 1L) {
//            if (result%2 == 0L) result /= 2
//            else result = (result*3) + 1
//            answer ++
//            if (answer == 500) {
//                answer = -1
//                break
//            }
//        }
//        return answer
//    }
}
