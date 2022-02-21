package com.example.programmers

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.abs

@Suppress("NAME_SHADOWING")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        solution(intArrayOf(7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2), "left")
    }

    // [카카오 인턴] 키패드 누르기
    fun solution(numbers: IntArray, hand: String): String {
        var answer = ""
        var RH = 12
        var LH = 10
        for (item in numbers) {
            if ((item-1)%3 == 0) {
                // Left
                LH = item
                answer += "L"
            }else if ((item-1)%3 == 2) {
                // Right
                RH = item
                answer += "R"
            }else {
                var key = item
                if (item == 0) key = 11
                // Center
                if (abs(RH - key) % 3 + abs(RH - key) / 3 < abs(LH - key) % 3 + abs(LH - key) / 3) {
                    // right hand close
                    RH = key
                    answer += "R"
                } else if (abs(LH - key) % 3 + abs(LH - key) / 3 < abs(RH - key) % 3 + abs(RH - key) / 3) {
                    // left hand close
                    LH = key
                    answer += "L"
                } else {// same hand
                    if (hand == "right") {
                        // right hand
                        RH = key
                        answer += "R"
                    } else {
                        //left hand
                        LH = key
                        answer += "L"
                    }
                }
            }
        }
        return answer
    }


//    //크레인 인형뽑기 게임
//    fun solution(board: Array<IntArray>, moves: IntArray): Int {
//        var answer = 0
//        var new = arrayOf<IntArray>()
//        var temp = arrayOf<Int>()
//        var pick = arrayListOf<Int>()
//
//        for (i in board.indices) {
//            temp = temp.plus(0)
//        }
//        // 세로줄을 기준으로 새로운 배열 생성
//        for (i in board.indices) {
//            for (j in board[i].indices) {
//                temp[j] = board[j][i]
//            }
//            new = new.plus(temp.toIntArray())
//            for (i in board.indices) {
//                temp[i] = 0
//            }
//        }
//        // moves 대로 뽑아서
//        for (i in moves.indices) {
//            for (j in board[0].indices) {
//                if (new[moves[i] - 1][j] != 0) {
//                    // 두개가 만나면 터짐
//                    if (pick.size != 0 && pick.last() == new[moves[i]-1][j]) {
//                        pick.removeAt(pick.size-1)
//                        new[moves[i] - 1][j] = 0
//                        answer += 2
//                    }else {
//                        // 새로운 배열에 저장하고 기존은 삭제
//                        pick.add(new[moves[i] - 1][j])
//                        new[moves[i] - 1][j] = 0
//                    }
//                    break
//                }
//            }
//        }
//        return answer
//    }

//    //실패율
//    fun solution(N: Int, stages: IntArray): IntArray {
//        var answer = intArrayOf()
//        val fail: MutableMap<Int, Double> = mutableMapOf()
//        val lose : MutableMap<Int, Int> = mutableMapOf()
//        var user = 0
//        var length = stages.size
//
//        for (i in 1..N) {
//            stages.forEach {
//                if (i == it) user++
//            }
//            lose[i-1] = user
//            user = 0
//        }
//        for (i in 0 until N) {
//            if ((lose[i]?.toDouble()!! /length.toDouble()).isNaN())  fail[i] = 0.0 else  fail[i] = lose[i]?.toDouble()!! /length.toDouble()
//            length -= lose[i]!!
//        }
//        val new = (fail.toList().sortedByDescending { (_, it) -> it })
//        for (item in new) answer = answer.plus(item.first+1)
//
//        return answer
//    }

//    //소수 만들기
//    fun solution(nums: IntArray): Int {
//        var answer = 0
//        var arr = arrayOf<Int>()
//
//        for (i in 0 until nums.size - 2) {
//            for (j in i + 1 until nums.size - 1) {
//                for (k in j + 1 until nums.size) {
//                    val sum = nums[i] + nums[j] + nums[k]
//                    Log.d("넘버i", i.toString())
//                    Log.d("넘버j", j.toString())
//                    Log.d("넘버k", k.toString())
//                    for (i in 1..sum) if (sum % i == 0) arr = arr.plus(i)
//                    if (arr.size == 2) answer++
//                    arr = arrayOf()
//                }
//            }
//        }
//        return answer
//    }


//    //없는 숫자 더하기
//    fun solution(numbers: IntArray): Int {
//        var answer: Int = -1
//        val num = arrayOf(1,2,3,4,5,6,7,8,9)
//        for (i in num.indices) if (!numbers.contains(num[i]))  answer += num[i]
//        answer += 1
//        return answer
//    }

//    //음양 더하기
//    fun solution(absolutes: IntArray, signs: BooleanArray): Int {
//        var answer: Int = 0
//        for (i in absolutes.indices) if (signs[i]) answer += absolutes[i] else answer -= absolutes[i]
//        return answer
//    }

//    //약수의 개수와 덧셈
//    fun solution(left: Int, right: Int): Int {
//        var answer: Int = 0
//        var cnt = 0
//        for (i in left..right) {
//            for (j in 1..i) if (i % j == 0) cnt += 1
//            if (cnt % 2 == 0) answer += i
//            else {
//                answer -= i
//                cnt = 0
//            }
//        }
//        return answer
//    }

//
//    //내적
//    fun solution(a: IntArray, b: IntArray): Int {
//        var answer: Int = 0
//        for (i in a.indices) answer += a[i]*b[i]
//        return answer
//    }

//    //3진법 뒤집기
//    fun solution(n: Int): Int {
//        var answer: Int = 0
//        var a = arrayOf<Int>()
//        var b = n
//        while (b > 0) {
//            a = a.plus(b%3)
//            b /= 3
//            if (b == 1) a.plus(1)
//        }
//        a.reverse()
//        a.forEachIndexed {index, it -> answer += it*3.0.pow(index).toInt() }
//        return answer
//    }


//    //모의고사
//    fun solution(answers: IntArray): IntArray {
//        var answer = intArrayOf()
//
//        val count = intArrayOf(0,0,0)
//
//        val one = arrayOf(1,2,3,4,5)
//        val two = arrayOf(2,1,2,3,2,4,2,5)
//        val thr = arrayOf(3,3,1,1,2,2,4,4,5,5)
//
//        for (i in answers.indices) {
//            if (one[i%5] == answers[i]) count[0] += 1
//            if (two[i%8] == answers[i]) count[1] += 1
//            if (thr[i%10] == answers[i]) count[2] += 1
//        }
//
//        var max = count.max()
//
//        for (i in 0 until 3) if (max == count[i]) answer = answer.plus(i+1)
//
//        return answer
//    }

//    //최소직사각형
//    fun solution(sizes: Array<IntArray>): Int {
//        var answer: Int = 0
//        val long = MutableList(sizes.size) { i -> i }
//        val short = MutableList(sizes.size) { i -> i }
//        sizes.forEachIndexed { index, it ->
//            if (it[0] > it[1]) {
//                long[index] = it[0]
//                short[index] = it[1]
//            } else {
//                long[index] = it[1]
//                short[index] = it[0]
//            }
//        }
//        answer = long.max()!! * short.max()!!
//        return answer
//    }

//    //부족한 금액 계산하기
//    fun solution(price: Int, money: Int, count: Int): Long {
//        var answer: Long = -1
//        var total : Long = 0
//        for (i in 1..count) total += price.toLong()*i
//        answer = if (total - money < 0) 0 else (total - money)
//        return answer
//    }

//    //체육복
//    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
//        var answer = 0
//        lost.sort()
//        reserve.sort()
//        val lostSet = lost.toMutableSet()
//        val reserveSet = reserve.toMutableSet()
//        // 여벌이 있는데 잃어버린 않은 사람들은 도난, 여벌 목록에서 제거
//        reserve.filter {
//            lostSet.contains(it)
//        }.forEach {
//            reserveSet.remove(it)
//            lostSet.remove(it)
//        }
//        println(lostSet)
//        println(reserveSet)
//        reserveSet.forEach {
//            when {
//                lostSet.contains(it - 1) ->
//                    lostSet.remove(it - 1)
//                lostSet.contains(it + 1) ->
//                    lostSet.remove(it + 1)
//            }
//        }
//        answer = n - lostSet.count()
//        return answer
//    }

//    //두 개 뽑아서 더하기
//    fun solution(numbers: IntArray): IntArray {
//        var answer: IntArray = intArrayOf()
//        for ((index, item) in numbers.withIndex()) for (i in index+1 until numbers.size)  answer += item + numbers[i]
//        answer = answer.distinct().toIntArray()
//        answer.sort()
//        return answer
//    }

//    //문자열 내 마음대로 정렬하기
//    fun solution(strings: Array<String>, n: Int): Array<String> {
//        var answer = arrayOf<String>()
//        answer += strings.sortedWith( compareBy ({it[n]} , {it}))
//        return answer
//    }

//    //시저 암호
//    fun solution(s: String, n: Int): String {
//        var answer = ""
//        for (i in s.indices) {
//            answer += when {
//                s.toCharArray()[i].toInt() + n in 91..96 || s.toCharArray()[i].toInt() + n > 122 -> s.toCharArray()[i] + n - 26
//                s.toCharArray()[i] == ' ' -> ' '
//                s.toCharArray()[i].toInt() in 65..90 && s.toCharArray()[i].toInt() + n > 90 -> s.toCharArray()[i] + n - 26
//                else -> s.toCharArray()[i] + n
//            }
//        }
//        return answer
//    }

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