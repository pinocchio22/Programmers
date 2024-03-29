package com.example.programmers

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.lang.Integer.min
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.abs
import kotlin.math.exp
import kotlin.math.max
import kotlin.math.sqrt

@Suppress(
    "NAME_SHADOWING", "TYPE_INFERENCE_ONLY_INPUT_TYPES_WARNING", "CAST_NEVER_SUCCEEDS",
    "RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS",
    "NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS", "DEPRECATED_IDENTITY_EQUALS"
)
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 2
        solution("3141592", "271")
    }

    //크기가 작은 부분문자열
    fun solution(t: String, p: String): Int {
        var answer: Int = 0
        for (i in 0..t.length - p.length) if (p >= t.slice(i until i+p.length)) answer++
        return answer
    }


//        // 롤케이크 자르기
//        fun solution(topping: IntArray): Int {
//            var answer: Int = -1
//
//            //1 - 시간초과
//            for (i in topping.indices) if (topping.slice(0..i)
//                    .toSet().size == topping.slice(i + 1 until topping.size).toSet().size
//            ) answer++
//
//            //2 - 시간초과
//            var new = topping
//            var two = intArrayOf()
//            new.forEach {
//                two += it
//                new = new.drop(1).toIntArray()
//                if (two.toSet().size == new.toSet().size) answer++
//            }
//
//            //3 - 시간초과
//            val one = arrayListOf<Int>()
//            val two = arrayListOf<Int>()
//            topping.forEach { one.add(it) }
//            topping.forEach {
//                two += it
//                one.remove(it)
//                if (two.toSet().size == one.toSet().size) answer++
//            }
//
//            //4 - 시간초과(좀 적게)
//            val one = mutableMapOf<Int, Int>()
//            val two = mutableSetOf<Int>()
//            for (i in 1..topping.maxOrNull()!!) {
//                one[i] = 0
//            }
//            topping.forEach {
//                one[it] = one[it]!! + 1
//            }
//
//            topping.forEach {
//                two.add(it)
//                one[it] = one[it]!! - 1
//                if (two.size == one.filter { it.value != 0 }.size) answer++
//            }
//
//            return answer
//        }

//    // 택배상자
//    fun solution(order: IntArray): Int {
//        var answer: Int = 0
//        val stack = Stack<Int>()
//        var index = 0
//
//        for (i in 1..order.size) {
//            if (i == order[index]) {
//                answer++
//                index++
//            } else {
//                stack.push(i)
//            }
//            while (stack.isNotEmpty() && stack.peek() == order[index]) {
//                stack.pop()
//                index++
//                answer++
//            }
//        }
//        return answer
//    }

//    // 할인 행사
//    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
//        var answer: Int = 0
//
//        for (x in 0 until discount.size-9) {
//            val map = mutableMapOf<String, Int>()
//            for (i in want.indices) {
//                map[want[i]] = number[i]
//            }
//            for (y in x..9+x) {
//                if (map.contains(discount[y])) {
//                    map.replace(discount[y], map[discount[y]]!!-1)
//                }
//            }
//            if(map.all { it.value == 0 }) answer++
//        }
//        return answer
//    }

//    // 연속 부분 수열 합의 개수
//    fun solution(elements: IntArray): Int {
//        var answer: Int = 0
//        val new = elements + elements
//        val set = mutableSetOf<Int>()
//        for (x in elements.indices) {
//            for (y in 0..new.size-(x+1)) {
//                println(new.slice(y..y+x))
//                set += new.slice(y..y+x).sum()
//            }
//        }
//        answer += set.size
//        return answer
//    }

//    // 숫자 짝꿍
//    fun solution(X: String, Y: String): String {
//        var answer: String = ""
//        for (i in '9' downTo '0') {
//            if (X.contains(i) && Y.contains(i)) {
//                answer += i.toString().repeat(min((X.count { it == i }), (Y.count { it == i })))
//            }
//        }
//        if (answer.isBlank()) return "-1" else if (answer.all { it == '0' }) return "0"
//        return answer
//    }

//    // 콜라 문제
//    fun solution(a: Int, b: Int, n: Int): Int {
//        var answer: Int = 0
//        var result = 0
//        result = n
//        while (true) {
//            var temp = 0
//
//            temp += (result/a)*b + result%a
//            answer += (result/a)*b
//            if (temp < a) break
//            result = temp
//        }
//        return answer
//    }

//    // 삼총사
//    fun solution(number: IntArray): Int {
//        var answer: Int = 0
//        for (x in number.indices) {
//            for (y in x+1 until number.size) {
//                for (z in y+1 until number.size) {
//                    if (number[x]+number[y]+number[z] == 0) {
//                        answer++
//                    }
//                }
//            }
//        }
//        return answer
//    }

//    // 하샤드 수
//    fun solution(x: Int): Boolean {
//        var answer = true
//        var num = 0
//        var temp = x
//
//        while (temp != 0) {
//            num += temp%10
//            temp /= 10
//        }
//        return x%num == 0
//    }

//    // [카카오 인턴] 수식 최대화
//    fun solution(expression: String): Long {
//        var answer: Long = 0
//        val op = arrayOf("*+-","*-+","+*-","+-*","-*+","-+*")
//        var max = 0L
//
//        op.forEach {
//            val numlist = mutableListOf<Long>()
//            expression.split("*","-","+").forEach {
//                numlist.add(it.toLong())
//            }
//            val signlist = mutableListOf<String>()
//            "[-+*]".toRegex().findAll(expression).forEach {
//                signlist.add(it.value)
//            }
//
//            for (i in it.indices) {
//                var index = 0
//                while (signlist.contains(it[i].toString())) {
//                    if (it[i].toString() == signlist[index]) {
//                        when(signlist[index]) {
//                            "-" -> numlist[index] = numlist[index] - numlist[index+1]
//                            "+" -> numlist[index] = numlist[index] + numlist[index+1]
//                            "*" -> numlist[index] = numlist[index] * numlist[index+1]
//                        }
//                        numlist.removeAt(index+1)
//                        signlist.removeAt(index)
//                    } else {
//                        index++
//                    }
//                }
//            }
//            max = max(max, abs(numlist[0]))
//        }
//        answer += max
//        return answer
//    }

//    // k진수에서 소수 개수 구하기
//    fun solution(n: Int, k: Int): Int {
//        var answer: Int = -1
//        var arr = arrayOf<String>()
//
//        notation(n,k).split('0').map { if (it.isNotEmpty())  arr += it }
//        arr.forEach {
//            if (isPrime(it.toLong())) {
//                answer ++
//            }
//        }
//        return answer + 1
//    }
//
//    fun notation(n: Int, k: Int) : String {
//        var num = n
//        var trans = ""
//
//        while (num > k-1) {
//            trans += (num%k).toString()
//            num /= k
//        }
//        return (trans + num.toString()).reversed()
//    }
//
//    fun isPrime(n: Long) : Boolean {
//        val num = n
//        if (num <= 1) return false
//        return (2..sqrt(num.toDouble()).toInt()).none { num % it == 0L }
//    }

//    // 성격 유형 검사하기
//    fun solution(survey: Array<String>, choices: IntArray): String {
//        var answer: String = ""
//        val map =  mutableMapOf('R' to 0, 'T' to 0, 'C' to 0, 'F' to 0, 'J' to 0, 'M' to 0, 'A' to 0, 'N' to 0)
//
//        for (i in survey.indices) {
//            if (choices[i] < 4) map.replace(survey[i][0], map[survey[i][0]]!! + 4 - choices[i]) else map.replace(survey[i][1], map[survey[i][1]]!! + choices[i] - 4)
//        }
//
//        answer += if (map['R']!!.toInt() - map['T']!!.toInt() >= 0) "R" else "T"
//        answer += if (map['C']!!.toInt() - map['F']!!.toInt() >= 0) "C" else "F"
//        answer += if (map['J']!!.toInt() - map['M']!!.toInt() >= 0) "J" else "M"
//        answer += if (map['A']!!.toInt() - map['N']!!.toInt() >= 0) "A" else "N"
//
//        return answer
//    }

//    // 순위 검색
//    fun solution(info:Array<String>, query:Array<String>):IntArray {
//        val answer = IntArray(query.size) { 0 }
//        val wordMap:MutableMap<String, Int> = SettingWordMap()
//        val scoreList:MutableList<MutableList<Int>> = MutableList(4*3*3*3) { mutableListOf() }
//        val infoRegex = " ".toRegex()
//        val queryRegex = "( and )|( )".toRegex()
//
//        info.forEach {
//            val (infoList, score) = SplitInfo(it, infoRegex)
//            val arr:IntArray = intArrayOf(wordMap[infoList[0]]!! * 3 * 3 * 3, wordMap[infoList[1]]!! * 3 * 3, wordMap[infoList[2]]!! * 3, wordMap[infoList[3]]!!)
//            for(i in  0 until (1 shl 4)) {
//                var index = 0
//                for(j in 0 until 4) {
//                    if(i and (1 shl j) != 0) {
//                        index += arr[j]
//                    }
//                }
//                scoreList[index].add(score)
//            }
//        }
//        scoreList.forEach {
//            it.sort()
//        }
//        for(i in query.indices) {
//            val(queryInfo, score) = SplitInfo(query[i], queryRegex)
//            val index:Int = wordMap[queryInfo[0]]!! * 3 * 3 * 3 + wordMap[queryInfo[1]]!! * 3 * 3 + wordMap[queryInfo[2]]!! * 3 + wordMap[queryInfo[3]]!!
//            var ret:Int = scoreList[index].binarySearch(score)
//            if (ret < 0) {
//                ret = (ret + 1) * -1
//            } else if(ret > 0) {
//                for(j in ret downTo 0) {
//                    if(scoreList[index][j] == score) {
//                        ret = j
//                    } else {
//                        break
//                    }
//                }
//            }
//            answer[i] += (scoreList[index].size - ret)
//        }
//        return answer
//    }
//
//    fun SettingWordMap():MutableMap<String, Int> {
//        val wordMap:MutableMap<String, Int> = HashMap<String, Int>()
//        wordMap["-"] = 0
//        wordMap["cpp"] = 1
//        wordMap["java"] = 2
//        wordMap["python"] = 3
//        wordMap["backend"] = 1
//        wordMap["frontend"] = 2
//        wordMap["junior"] = 1
//        wordMap["senior"] = 2
//        wordMap["chicken"] = 1
//        wordMap["pizza"] = 2
//
//        return wordMap
//    }
//
//    fun SplitInfo(info:String, regex:Regex):Pair<List<String>, Int> {
//        val infoList:List<String> = info.split(regex)
//        val score = infoList[4].toInt()
//        return Pair(infoList.subList(0, 4), score)
//    }

//    // 문자열 압축
//    fun solution(s: String): Int {
//        var answer = 0
//        var length = arrayOf<Int>()
//        if (s.length == 1) return 1
//        for (num in 1..s.length/2) {
//            var str = ""
//            var cnt = 0
//            for (i in 0 until s.chunked(num).size) {
//                if ((s.chunked(num)+1)[i] == (s.chunked(num)+1)[i+1]) {
//                    cnt++
//                } else {
//                    if (cnt != 0) {
//                        str += (cnt+1).toString()+s.chunked(num)[i]
//                        cnt = 0
//                    } else {
//                        str += s.chunked(num)[i]
//                    }
//                }
//                if ((s.chunked(num)+1)[i] == 1) break
//            }
//            length += str.length
//        }
//        answer += length.minOrNull()!!
//        return answer
//    }

//    // 괄호 변환
//    fun solution(p: String): String {
//        var answer = ""
//        answer += cycle(p)
//        return answer
//    }
//
//    fun cycle(p : String) : String {
//        var str = ""
//        var u = ""
//        var v = ""
//        var RCnt = 0
//        var LCnt = 0
//
//        if (p.isBlank()) return ""
//        for (i in p.indices) {
//            u += p[i]
//            if (p[i] == '(') RCnt++ else if (p[i] == ')') LCnt++
//            if (RCnt == LCnt) {
//                v += p.drop(u.length)
//                break
//            }
//        }
//        if (isCorrect(u)) {
//            str += u
//            str += cycle(v)
//        } else {
//            var temp = "(${cycle(v)})"
//            var new = u.drop(1)
//            new.dropLast(1).forEach {
//                temp += if (it == '(') ')' else '('
//            }
//            str += temp
//        }
//        return str
//    }
//
//    fun isCorrect(u : String) : Boolean {
//        val stack = Stack<Char>()
//        stack.push(u[0])
//        for (i in 1 until u.length) {
//            if (stack.peek() == '(' && u[i] == ')') {
//                stack.pop()
//            }else {
//                stack.push(u[i])
//            }
//        }
//        return stack.isEmpty()
//    }

//    // 배달
//    data class Node(val idx: Int, val distance: Int):Comparable<Node>{
//        override fun compareTo(other: Node): Int {
//            return this.distance.compareTo(other.distance)
//        }
//    }
//    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
//        val town = IntArray(N){ 500001 }.apply { this[0] = 0 }
//        val pq = PriorityQueue<Node>().apply { offer(Node(0,0)) }
//
//        while (pq.isNotEmpty()) {
//            val now = pq.poll()
//            if (now.distance > town[now.idx]) continue
//            for (i in road.indices) {
//                if (road[i][0] == now.idx+1) {
//                    val cost = now.distance + road[i][2]
//                    val idx = road[i][1]-1
//                    if(cost < town[idx]){
//                        town[idx] = cost
//                        pq.offer(Node(idx, cost))
//                    }
//                }
//                else if (road[i][1] == now.idx+1){
//                    val cost = now.distance + road[i][2]
//                    val idx = road[i][0]-1
//                    if(cost < town[idx]){
//                        town[idx] = cost
//                        pq.offer(Node(idx, cost))
//                    }
//                }
//            }
//        }
//        return town.count{ it <= k }
//    }

//    // N-Queen
//    var answer = 0
//    lateinit var arr: IntArray
//
//    fun solution(n: Int): Int {
//        arr = IntArray(n){12}
//        queen(0, n)
//        return answer
//    }
//
//    fun queen(count : Int, n : Int) {
//        if(count==n){
//            answer++
//            return
//        }
//        for(i in 0 until n){
//            if(check(count,i)){
//                arr[count] = i
//                queen(count+1,n)
//                arr[count] = 12
//            }
//        }
//    }
//
//    fun check(sum: Int, i : Int) : Boolean {
//        for (j in 0 until sum){
//            if (arr[j] == i || abs(arr[j]-i) == abs(j-sum)) {
//                return false
//            }
//        }
//        return true
//    }


//    // 멀리 뛰기
//    fun solution(n: Int): Long {
//        var answer: Long = 0
//        var first = 1
//        var second = 2
//        var fibo : Int
//        if (n == 1) return 1 else if (n == 2) return 2
//        for(i in 3..n) {
//            fibo = (first+second)%1234567
//            first = second
//            second = fibo
//            if (i == n) answer += fibo
//        }
//        return answer
//    }

//    // 하노이의 탑
//    fun solution(n: Int): Array<IntArray> {
//        var answer = arrayOf<IntArray>()
//        hanoi(n,1,2,3)
//        answer = move
//        return answer
//    }
//    fun hanoi(num : Int, first : Int, second : Int, last : Int) {
//        if (num == 0) return
//        hanoi (num - 1, first, last, second)
//        move = move.plus(intArrayOf(first, last))
//        hanoi(num - 1, second, first, last)
//    }

//    // 멀쩡한 사각형
//    fun solution(w: Int, h: Int): Long {
//        var answer: Long = 0
//        val GCDw = w/gcd(w,h)
//        val GCDh = h/gcd(w,h)
//        answer += w.toLong()*h.toLong()-(GCDw+GCDh-1) * gcd(w,h)
//        println(answer)
//        return answer
//    }
//
//    fun gcd(w: Int, h: Int) : Int {
//        var num = 0
//        for (i in max(w,h) downTo 1) {
//            if (w%i == 0 && h%i == 0) {
//                num = i
//                break
//            }
//        }
//        return num
//    }

//    // 후보키
//    fun solution(relation: Array<Array<String>>): Int {
//        var answer = 0
//        val row = relation.size //6
//        val col = relation[0].size //4
//        val temp = ArrayList<Int>()
//
//        for (i in 1 until (1 shl col)) {
//            if (!Minimal(i, temp)) continue
//            if (!Unique(i, relation, row, col)) continue
//            temp.add(i)
//        }
//        answer += temp.size
//        return answer
//    }
//
//    fun Minimal(i: Int, temp: ArrayList<Int>): Boolean {
//        for (item in temp) if (i and item == item) return false
//        return true
//    }
//
//    fun Unique(arr: Int, relation: Array<Array<String>>, row: Int, col: Int): Boolean {
//        val set: HashSet<String> = HashSet()
//        for (i in 0 until row) {
//            val sb = StringBuilder()
//            for (j in binary(arr, col)) sb.append(relation[i][j])
//            set.add(sb.toString())
//        }
//        return set.size === row
//    }
//
//    fun binary(arr: Int, col: Int): ArrayList<Int> {
//        val list = ArrayList<Int>()
//        for (i in 0 until col) if (arr shr i and 1 == 1) list.add(i)
//        return list
//    }

//    // 튜플
//    fun solution(s: String): IntArray {
//        var answer = intArrayOf()
//        var arr = arrayOf<String>()
//
//        arr += s.substring(2..s.length-3).split("},{")
//        arr.sortBy { it.length }
//
//        val max = mutableSetOf<String>()
//        arr.forEach {
//            it.split(",").forEach {
//                max.add(it)
//            }
//        }
//        max.forEach {
//            answer += it.toInt()
//        }
//        return answer
//    }

//    // 오픈채팅방
//    fun solution(record: Array<String>): Array<String> {
//        var answer = arrayOf<String>()
//        val data = mutableMapOf<String, String>()
//
//        record.forEach {
//            val delimeter = it.split(' ')[0]
//            val uid = it.split(' ')[1]
//
//            when(delimeter) {
//                "Enter" -> data[uid] = it.split(' ')[2]
//                "Change" -> data[uid] = it.split(' ')[2]
//            }
//        }
//
//        record.forEach {
//            val delimeter = it.split(' ')[0]
//            val uid = it.split(' ')[1]
//            when(delimeter) {
//                "Enter" -> answer += "${data[uid]}" + "님이 들어왔습니다."
//                "Leave" -> answer += "${data[uid]}" + "님이 나갔습니다."
//            }
//        }
//        return answer
//    }

//    // 빛의 경로 사이클
//    val x = intArrayOf(0, 1, 0, -1)
//    val y = intArrayOf(-1, 0, 1, 0)
//
//    fun solution(grid: Array<String>): IntArray {
//        var answer: IntArray
//        val isvisited = Array(grid.size){ Array(grid[it].length){ BooleanArray(4) } }
//        val arr = ArrayList<Int>()
//
//        for (i in grid.indices) {
//            for (j in grid[i].indices) {
//                for (direction in 0 until 4) {
//                    if (!isvisited[i][j][direction]) {
//                        arr.add(cycle(grid, isvisited, j, i, direction))
//                    }
//                }
//            }
//        }
//        arr.sort()
//        answer = IntArray(arr.size)
//        for (i in answer.indices) answer[i] = arr[i]
//        return answer
//    }
//
//    fun cycle(grid: Array<String>, isvisited: Array<Array<BooleanArray>>, j: Int, i: Int, direction: Int) : Int {
//        var j = j
//        var i = i
//        var direction = direction
//        var count = 0
//
//        while (!isvisited[i][j][direction]) {
//            count++
//            isvisited[i][j][direction] = true
//            when(grid[i][j]) {
//                'L' -> direction = correct(direction - 1)
//                'R' -> direction = correct(direction + 1)
//            }
//            i = (i + y[direction] + grid.size) % grid.size
//            j = (j + x[direction] + grid[0].length) % grid[0].length
//        }
//        return count
//    }
//    fun correct(direction: Int) : Int {
//        return if (direction < 0) 3 else direction % 4
//    }

//    // 괄호 회전하기
//    fun solution(s: String): Int {
//        var answer: Int = -1
//        var arr = s
//
//        for (i in arr.indices) {
//            val stack = Stack<Char>()
//            arr.forEach {
//                if (stack.empty()) {
//                    stack.push(it)
//                } else if (it == '[' || it == '{' || it == '(') {
//                    stack.push(it)
//                } else {
//                    when {
//                        stack.peek() == '[' && it == ']' -> stack.pop()
//                        stack.peek() == '{' && it == '}' -> stack.pop()
//                        stack.peek() == '(' && it == ')' -> stack.pop()
//                    }
//                }
//            }
//            if (stack.empty()) answer++
//            arr += arr[0]
//            arr = arr.removeRange(0,1)
//        }
//        return answer + 1
//    }

//    // 교점에 별 만들기
//    fun solution(line: Array<IntArray>): Array<String> {
//        var answer: Array<String> = arrayOf<String>()
//        val coordinate : ArrayList<IntArray> = ArrayList()
//        val x = arrayListOf<Int>()
//        val y = arrayListOf<Int>()
//
//        for (i in line.indices) {
//            for (j in i+1 until line.size) {
//                val a = line[i]
//                val b = line[j]
//                val A = a[1].toLong()*b[2].toLong() - a[2].toLong()*b[1].toLong()
//                val B = b[0].toLong()*a[2].toLong() - a[0].toLong()*b[2].toLong()
//                val C = a[0].toLong()*b[1].toLong() - a[1].toLong()*b[0].toLong()
//
//                if (C.toInt() != 0)  if ((A%C).toInt() == 0 && (B%C).toInt() == 0) intArrayOf((A/C).toInt(), (B/C).toInt()).let { coordinate.add(it) }
//            }
//        }
//        coordinate.forEach{
//            x.add(it[0])
//            y.add(it[1])
//        }
//        val init = Array(y.maxOrNull()!! - y.minOrNull()!!+1) {Array(x.maxOrNull()!! - x.minOrNull()!!+1) {"."}}
//
//        coordinate.forEach{
//            init[y.maxOrNull()!! - it[1]][it[0] - x.minOrNull()!!] = "*"
//        }
//        init.forEach {
//            var temp = "\""
//            it.forEach { temp += it }
//            answer += "$temp\""
//        }
//        return answer
//    }

//    // 전력망을 둘로 나누기
//    lateinit var list: Array<ArrayList<Int>?>
//    fun solution(n: Int, wires: Array<IntArray>): Int {
//        var answer = Int.MAX_VALUE
//        list = arrayOfNulls(n + 1)
//        for (i in list.indices) list[i] = ArrayList() //초기화
//        for (i in wires.indices) {
//            list[wires[i][0]]!!.add(wires[i][1])
//            list[wires[i][1]]!!.add(wires[i][0])
//        }
//        for (i in wires.indices) {
//            answer = answer.coerceAtMost(abs(getNodeCount(wires[i][0], wires[i][1]) - getNodeCount(wires[i][1], wires[i][0])))
//        }
//        return answer
//    }
//
//    fun getNodeCount(target: Int, exceptNumber: Int): Int {
//        var result = 1
//        val targetList = list[target]
//        for (i in 0 until targetList!!.size) {
//            if (targetList[i] != exceptNumber) {
//                result += getNodeCount(targetList[i], target)
//            }
//        }
//        return result
//    }

//    // 예상 대진표
//    fun solution(n: Int, a: Int, b: Int): Int {
//        var answer = 0
//        var first = a.toDouble()
//        var second = b.toDouble()
//
//        while (true) {
//            if (first.toInt()%2 == 0) {
//                if (first-1 == second) break
//            }else {
//                if (first+1 == second) break
//            }
//            first = ceil((first/2))
//            second = ceil((second/2))
//            answer++
//        }
//        return answer+1
//    }

//    // 쿼드압축 후 개수 세기
//    val answer = IntArray(2){0}
//
//    fun dfs(r : Int, c : Int, size : Int, arr : Array<IntArray>){
//        var zero = true
//        var one = true
//        for(i in r until r+size){
//            for(j in c until c+size){
//                if(arr[i][j]==0) one = false
//                if(arr[i][j]==1) zero = false
//            }
//        }
//        if(zero){
//            answer[0]++
//            return
//        }
//        if(one){
//            answer[1]++
//            return
//        }
//        dfs(r,c,size/2,arr)
//        dfs(r,c+size/2,size/2,arr)
//        dfs(r+size/2,c,size/2,arr)
//        dfs(r+size/2,c+size/2,size/2,arr)
//
//    }
//
//    fun solution(arr: Array<IntArray>): IntArray {
//        dfs(0,0,arr.size,arr)
//        return answer
//    }

//    // 2개 이하로 다른 비트
//    fun solution(numbers: LongArray): LongArray {
//        var answer: LongArray = longArrayOf()
//        answer = numbers.map { n -> (n.inv() and n+1).let { n or it and (it shr 1).inv() } }.toLongArray()
//        return answer
//    }

//    fun solution(numbers: LongArray): LongArray {
//        var answer: LongArray = longArrayOf()
//
//        numbers.forEachIndexed { index, it ->
//            var i = 0
//            while (answer.size != 2) {
//                var count = 0
//                i++
//                for (j in it.toString(2).indices) {
//                    if (it.toString(2)[j] != (it+i).toString(2)[j]) {
//                        count++
//                    }
//                }
//                if (count <= 2) {
//                    answer += it+i.toLong()
//                    break
//                }
//            }
//        }
//        println(answer.contentToString())
//
//        return answer
//    }

//    // 이진 변환 반복하기
//    fun solution(s: String): IntArray {
//        var answer: IntArray = intArrayOf()
//        var count = 0
//        var zero = 0
//        var temp = s
//
//        while (temp != "1") {
//            count++
//            zero += temp.count { it == '0' }
//            temp = temp.replace("0","").length.toString(2)
//        }
//        answer += count
//        answer += zero
//        return answer
//    }

//    // n^2 배열 자르기
//    fun solution(n: Int, left: Long, right: Long): IntArray {
//        var answer: IntArray = intArrayOf()
//        for (i in left..right) answer += (i/n).toInt().coerceAtLeast((i%n).toInt()) + 1
//        return answer
//    }

//    // 모음 사전
//    fun solution(word: String): Int {
//        var answer = 0
//        word.forEachIndexed { index, it ->
//            if (it != 'A') {
//                when (index) {
//                    0 -> answer += alphabet(it)*781
//                    1 -> answer += alphabet(it)*156
//                    2 -> answer += alphabet(it)*31
//                    3 -> answer += alphabet(it)*6
//                    4 -> answer += alphabet(it)
//                }
//            }
//        }
//        answer += word.length
//        return answer
//    }
//    fun alphabet (it : Char): Int {
//        var num = 0
//        when (it) {
//            'E' -> num = 1
//            'I' -> num = 2
//            'O' -> num = 3
//            'U' -> num = 4
//        }
//        return num
//    }

//    // 피로도
//        lateinit var isVisit: BooleanArray
//        var answer: Int = -1
//        var count = 0
//
//        fun solution(k: Int, dungeons: Array<IntArray>): Int {
//            isVisit = BooleanArray(dungeons.size)
//            Counting(dungeons, k, 1)
//            answer = count
//            return answer
//        }
//
//        fun Counting(dungeons:Array<IntArray>, k:Int, Lv:Int) {
//            for (i in dungeons.indices) {
//                if (!isVisit[i]) {
//                    isVisit[i] = true
//                    if (k >= dungeons[i][0]) {
//                        count = count.coerceAtLeast(Lv)
//                        Counting(dungeons, k-dungeons[i][1], Lv+1)
//                    }
//                    isVisit[i] = false
//                }
//            }
//        }

//    // 삼각 달팽이
//    fun solution(n: Int): IntArray {
//        val size = (n*(n+1))/2
//        val answer = IntArray(size)
//        val arr = Array(n){IntArray(n)}
//        var direction = 0
//        var x = 0 //세로
//        var y = 0 //가로
//        var count = 1
//        var index = 0
//
//        for (i in n downTo 1) {
//            when (direction) {
//                0 -> { // 아래방향
//                    for (j in 1..i) {
//                        arr[x][y] = count
//                        x++
//                        count++
//                    }
//                    x -= 1
//                    y += 1
//                }
//                1 -> { // 오른쪽방향
//                    for (j in 1..i) {
//                        arr[x][y] = count
//                        y++
//                        count++
//                    }
//                    x -= 1
//                    y -= 2
//                }
//                else -> { // 위대각방향
//                    for (j in 1..i) {
//                        arr[x][y] = count
//                        x--
//                        y--
//                        count++
//                    }
//                    x += 2
//                    y += 1
//                }
//            }
//            direction++
//            if (direction == 3) direction = 0
//        }
//        arr.forEach {
//            it.forEach {
//                if (it != 0) {
//                    answer[index] = it
//                    index++
//                }
//            }
//        }
//        return answer
//    }

//    // 타겟 넘버
//    fun solution(numbers: IntArray, target: Int): Int {
//        var answer = 0
//        var temp = arrayListOf(0)
//
//        numbers.forEach { first ->
//            var node = arrayListOf<Int>()
//            temp.forEach{ second ->
//                node.add(second + first)
//                node.add(second - first)
//            }
//            temp = node
//        }
//        answer = temp.filter { it == target }.count()
//        return answer
//    }

//    // 조이스틱
//    fun solution(name: String): Int {
//        var answer = 0
//        var move = name.length-1
//
//        // 하나씩 왼쪽에서 오른쪽으로 이동하는 횟수(기본)
//        for(i in name.indices){
//            var next = i + 1
//            while(next<name.length && name[next] == 'A') next++
//            move = min(move,i+name.length-next +i)
//
//            // (i+name.length-next+i)이거는 해당 문자 기준에서 다시 뒤로 돌아가는 경우
//            if(name[i].equals('A').not()){
//                var temp = name[i].toInt()-65
//                if(temp>=13) temp = (26-temp)
//                answer +=temp
//            }
//        }
//        answer +=move
//        return answer
//    }

//    // 프린터
//    fun solution(priorities: IntArray, location: Int): Int {
//        var answer = 0
//        val print : Queue<Pair<Int,Int>> = LinkedList()
//        var complete = intArrayOf()
//
//        // Queue에 (index, priorities) 형태로 add
//        for (i in priorities.indices) print.add(Pair(i,priorities[i]))
//        while (print.isNotEmpty()) {
//            val max = (print.sortedByDescending { it.second }).first()
//            val start = print.poll()
//
//            // 대기목록에 중요도가 더 높은 작업이 있으면 맨뒤로 , 없으면 출력
//            if (start != max) print.add(start) else complete = complete.plus(start.first)
//        }
//        answer += (complete.indexOf(location) + 1)
//        return answer
//    }

//    // 기능개발 2
//    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
//        var answer = intArrayOf()
//        var during = LinkedList<Int>() as Queue<Int>
//
//        // 완성까지 걸리는 날짜
//        for (i in progresses.indices) {
//            for (j in 1..100) {
//                if (100 <= progresses[i] + speeds[i]*j) {
//                    during.add(j)
//                    break
//                }
//            }
//        }
//        while (during.isNotEmpty()) {
//            var time = 1
//            val start = during.poll()
//            while (during.isNotEmpty() && start >= during.peek()) {
//                time += 1
//                during.remove()
//            }
//            answer = answer.plus(time)
//        }
//        return answer
//    }

//    // 큰 수 만들기
//    fun solution(number: String, k: Int): String {
//        var answer = StringBuilder()
//        var temp = 0
//
//        // 각 자리수
//        for (i in 0 until number.length - k) {
//            // 각 자리마다 max 초기화
//            var max = '0'
//            // max 값이 바뀌면 max+1부터 다시 반복
//            for (j in temp..i + k) {
//                // 뒤에 더 작은 수가 나오면 max로
//                if (max < number[j]) {
//                    max = number[j]
//                    temp = j + 1
//                }
//            }
//            answer.append(max)
//        }
//        return answer.toString()
//    }

//    // 다리를 지나는 트럭
//    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
//        var answer = 0
//        var bridge = LinkedList<Int>() as Queue<Int>
//        var number = 0
//        var bridge_weight = 0
//
//        while (true) {
//            // 시간 1초 증가
//            answer += 1
//            // 다리위에 트럭이 다리 길이보다 클경우 즉, 다리위의 트럭을 빼야하는 경우
//            if (bridge.size >= bridge_length) {
//                var poll = bridge.poll()
//                // 다리위에서 트럭을 하나 뺀 경우
//                if (poll >= 0) {
//                    // 다리위의 무게에서 출발선의 첫번째 트럭 무게만큼 제거
//                    bridge_weight -= truck_weights[poll]
//                    if (poll == truck_weights.size - 1) {
//                        // 마지막으로 빠져나온 트럭의 크기가 마지막으로 출발한 트럭의 크기와 같을 경우 즉, 모든 트럭이 건너온경우
//                        break
//                    }
//                }
//            }
//            // 출발한 트럭의 수 < 전체 트럭수 && 다리위의 무게 + 방금 출발한 트럭의 무게 <= 다리가 견딜 수 있는 무게
//            if (number < truck_weights.size && bridge_weight + truck_weights[number] <= weight) {
//                // 다리에 트럭의 순서 추가
//                bridge.add(number)
//                // 다리위의 무게에 방금 출발한 트럭의 무게를 더함
//                bridge_weight += truck_weights[number]
//                // 현재 트럭번호 +1
//                number += 1
//            }
//            // 현재 트럭이 다리에 올라가지 못하는 경우
//            else {
//                bridge.add(-1)
//            }
//        }
//        return answer
//    }

//    // 카펫
//    fun solution(brown: Int, yellow: Int): IntArray {
//        var answer = intArrayOf()
//        for (i in 1..yellow) {
//             if(4 + i*2 + yellow/i*2 == brown) {
//                 if (i+2 >= yellow/i+2) {
//                     answer = answer.plus(i+2)
//                     answer = answer.plus(yellow/i+2)
//                     break
//                 }
//             }
//        }
//        return answer
//    }

//    // 위장
//    fun solution(clothes: Array<Array<String>>): Int {
//        var answer = 0
//        answer = clothes.groupBy { it[1] }.values.map { it.size + 1 }.reduce(Int::times) - 1
//        return answer
//    }

//    // 소수 찾기
//    lateinit var set: MutableSet<Int>
//    fun solution(numbers: String): Int {
//        var answer = 0
//        set = mutableSetOf()
//        getCombination(numbers,"")
//        set.forEach {
//            var temp = arrayOf<Int>()
//            for (i in 1..it) if (it%i == 0) { temp = temp.plus(i) }
//            if (temp.size == 2) { answer += 1 }
//        }
//        return answer
//    }
//    fun getCombination(numbers: String, result: String) {
//        if (result.isNotEmpty()) set.add(result.toInt())
//        if (numbers.isEmpty()) return
//        numbers.forEachIndexed { index, c ->
//            getCombination(numbers.removeRange(index..index), c.plus(result))
//        }
//    }

//    // H-Index
//    fun solution(citations: IntArray): Int {
//        var answer = 0
//        var new = citations.sortedDescending()
//
//        if (new[0] == 0) return 0
//        new.forEachIndexed { index, i ->
//            if (index + 1 > i) {
//                return (index)
//            }
//        }
//        answer = new.size
//        return answer
//    }

//    // 가장 큰 수
//    fun solution(numbers: IntArray): String {
//        var answer = ""
//        var new = arrayOf<String>()
//
//        numbers.forEach { new += it.toString() }
//        new.sortWith(Comparator { it1, it2 -> if (it1.length == it2.length) it2.compareTo(it1) else (it2 + it1).compareTo(it1 + it2)} )
//        if (new[0] == "0") return "0"
//        new.forEach { answer += it }
//        return answer
//    }

//    // 피보나치 수
//    fun solution(n: Int): Int {
//        var answer = 0
//        var one = 0
//        var two = 1
//        var temp = 0
//
//        if (n == 1) return 1
//        for (i in 1 until n) {
//            temp = (one + two) % 1234567
//            one = two
//            two = temp
//        }
//        answer = temp
//        return answer
//    }

//    // JadenCase 문자열 만들기
//    fun solution(s: String): String {
//        var answer = ""
//        s.split(" ").map {
//            answer += if (it.isNotBlank()) it.first().toUpperCase() + it.substring(1)
//                .toLowerCase() + " " else " "
//        }
//        answer = answer.dropLast(1)
//        return answer
//    }

//    // 최댓값과 최솟값
//    fun solution(s: String): String {
//        var answer = ""
//
//        answer = "${s.split(" ").map { it.toInt() }.min()} ${s.split(" ").map { it.toInt() }.max()}"
//
//        return answer
//    }

//    // N개의 최소공배수
//    fun solution(arr: IntArray): Int {
//        var answer = 0
//        answer = arr[0]
//        for (i in 0..arr.size-2) {
//            answer = answer*arr[i+1]/gcd(answer,arr[i+1])
//        }
//        return answer
//    }
//    fun gcd(a: Int, b:Int): Int = if(b != 0) gcd(b, a % b) else a

//    // 행렬의 곱셈
//    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
//        var answer = arrayOf<IntArray>()
//        var temp = 0
//        var new = intArrayOf()
//
//        for (i in arr1.indices) {
//            for (j in arr2[0].indices) {
//                for (k in arr1[0].indices) temp += arr1[i][k] * arr2[k][j]
//                new = new.plus(temp)
//                temp = 0
//            }
//            answer = answer.plus(new)
//            new = intArrayOf()
//        }
//        return answer
//    }

//    // 신고 결과 받기
//    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
//        var answer: IntArray = intArrayOf()
//        val reported = mutableMapOf<String, Int>()
//        val new = mutableMapOf<String, Int>()
//
//        report.distinct().forEach {
//            val a = it.split(" ")[1]
//            reported[a] = reported.getOrDefault(a, 0) +1
//        }
//        id_list.forEach {
//            new[it] = 0
//        }
//        val b = reported.filterValues { it >= k }
//        report.distinct().forEach {
//            val a = it.split(" ")[0]
//            if (b.contains(it.split(" ")[1])) new[a] = new.getOrDefault(a, 0) + 1
//        }
//        answer = new.values.toIntArray()
//        return answer
//    }

//    // 로또의 최고 순위와 최저 순위
//    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
//        var answer: IntArray = intArrayOf()
//        var best = 0
//        var worst = 0
//
//        for (i in lottos.indices) {
//            if (win_nums.contains(lottos[i])) {
//                best += 1
//                worst += 1
//            }
//            if (lottos[i] == 0) best += 1
//        }
//        answer = if (best > 1) answer.plus(7 - best) else answer.plus(6)
//        answer = if (worst > 1) answer.plus(7 - worst) else answer.plus(6)
//        return answer
//    }

//    // 신규 아이디 추천
//    fun solution(new_id: String): String {
//        var answer: String = ""
//        var temp = ""
//        answer = new_id
//
//        // 1. 대문자를 소문자로
//        answer = answer.toLowerCase()
//
//        // 2. 소문자,숫자,(-),(_),(.) 제외한 모든 문자를 제거
//        answer.forEach { if (it in 'a'..'z' || it in '0'..'9' || it == '-' || it == '_' || it == '.') temp = temp.plus(it) }
//        answer = temp
//
//        // 3. (.)가 2번 이상 연속된 부분 -> 하나로 치환
//        while (answer.contains("..")) answer = answer.replace("..",".")
//
//        // 4. (.)가 처음이나 끝 위치 제거
//        if (answer.first() == '.' ) answer = answer.substring(1,answer.length) else if (answer.last() == '.') answer = answer.substring(0,answer.length-1)
//
//        // 5. 빈 문자열이라면 "a"
//        if (answer.isEmpty()) answer += "a"
//
//        // 6. 길이가 16 이상이면,15개를 제외한 나머지 문자 제거 , 제거 후 (.)가 끝에 위치한다면 (.) 제거
//        if (answer.length > 15) answer = answer.substring(0,15)
//        if (answer.last() == '.') answer = answer.substring(0,answer.length-1)
//
//        // 7. new_id의 길이가 2이하면, 마지막 문자를 길이가 3이 될 때까지 반복해서 끝에 붙임
//        if (answer.length < 3) while (answer.length < 3) answer += answer.last()
//
//        return answer
//    }

//    //숫자 문자열과 영단어
//    fun solution(s: String): Int {
//        var answer: Int = 0
//        val numbers = mapOf("zero" to 0, "one" to 1, "two" to 2, "three" to 3, "four" to 4, "five" to 5, "six" to 6, "seven" to 7, "eight" to 8, "nine" to 9)
//        var temp = s
//        numbers.forEach { (K, V) -> if (K in temp) temp = temp.replace(K, V.toString())}
//        answer = temp.toInt()
//        return answer
//    }

//    // [카카오 인턴] 키패드 누르기
//    fun solution(numbers: IntArray, hand: String): String {
//        var answer = ""
//        var RH = 12
//        var LH = 10
//        for (item in numbers) {
//            if ((item - 1) % 3 == 0) { // Left
//                LH = item
//                answer += "L"
//            } else if ((item - 1) % 3 == 2) { // Right
//                RH = item
//                answer += "R"
//            } else {
//                var key = item
//                val RHD = abs(RH - key) % 3 + abs(RH - key) / 3
//                val LHD = abs(LH - key) % 3 + abs(LH - key) / 3
//                if (item == 0) key = 11 // Center
//                if (RHD < LHD) { // right hand close
//                    RH = key
//                    answer += "R"
//                } else if (LHD / 3 < RHD) { // left hand close
//                    LH = key
//                    answer += "L"
//                } else {// same hand
//                    if (hand == "right") { // right hand
//                        RH = key
//                        answer += "R"
//                    } else { //left hand
//                        LH = key
//                        answer += "L"
//                    }
//                }
//            }
//        }
//        return answer
//    }

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