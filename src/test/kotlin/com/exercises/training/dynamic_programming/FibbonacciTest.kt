package com.exercises.training.dynamic_programming

import org.junit.jupiter.api.Test

class FibbonacciTest {

    private fun nthFibonacci(n: Long): Long =
        if(n < 0L) 0L
        else if(n <= 1L) n
        else {
            println("Calculando valor de fib($n)")
            (nthFibonacci(n-1) + nthFibonacci(n-2))
        }

    private fun nthFibonacciWithMemoization(n: Long, memo: Array<Long> = Array(n.toInt()+1) {0}): Long {
        if(n < 0L)
            return 0L
        else if(n <= 1L) {
            if(memo[n.toInt()] != n)
                memo[n.toInt()] = n
        }
        else if(memo[n.toInt()] == 0L) {
            println("Calculando valor de fib($n)")
            memo[n.toInt()] = nthFibonacciWithMemoization(n-1, memo) +
                nthFibonacciWithMemoization(n-2, memo)
        }

        return memo[n.toInt()]
    }

    private fun fibonacciAsArray(n: Long): Array<Long> =
        if(n < 0L) arrayOf()
        else if(n == 0L) arrayOf(0)
        else if(n == 1L) arrayOf(0, 1)
        else
            with (fibonacciAsArray(n-1)) {
                println("Calculando valor de fib($n)")
                this + (get(size-1) + get(size-2))
            }

    private fun fibonacciAsArrayWithMemo(n: Long, memoArray: Array<Long> = Array((n+1).toInt()) {0}): Array<Long> {
        if (n < 0L)
            return arrayOf()
        else if (n == 1L) {
            if (memoArray[1] == 0L)
                memoArray[1] = 1L
        }
        else if (n != 0L) {
            if (memoArray[n.toInt()] == 0L) {
                println("Calculando valor de fib($n)")
                memoArray[n.toInt()] =
                    fibonacciAsArrayWithMemo(n - 1, memoArray)[(n - 1).toInt()] +
                            fibonacciAsArrayWithMemo(n - 2, memoArray)[(n - 2).toInt()]
            }
        }

        return memoArray
    }

    @Test
    fun test1() {
        for (i in 0L..20L) {
            System.err.println("fib($i) = ${nthFibonacci(i)}")
        }
    }

    @Test
    fun test2() {
        for (i in 0L..20L) {
            System.err.println("fib($i) = ${nthFibonacciWithMemoization(i)}")
        }
    }

    @Test
    fun test3() {
        for (i in 0L..20L) {
            System.err.println("fib($i): ${fibonacciAsArray(i).contentToString()}")
        }
    }

    @Test
    fun test4() {
        for (i in 0L..20L) {
            System.err.println("fib($i): ${fibonacciAsArrayWithMemo(i).contentToString()}")
        }
    }

}
