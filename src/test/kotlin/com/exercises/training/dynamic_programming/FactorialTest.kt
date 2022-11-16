package com.exercises.training.dynamic_programming

import org.junit.jupiter.api.Test
import java.math.BigInteger

class FactorialTest {

    private var memo: Array<BigInteger> = Array(1000) { BigInteger.ONE }

    private fun nthFactorial(n: Int): BigInteger {
        if(n < 0) return BigInteger.ZERO
        else if(n > 1) {
            if(memo[n] == BigInteger.ONE) {
                println("Calculando valor de fact($n)")
                memo[n] = n.toBigInteger() * nthFactorial(n-1)
            }
        }

        return memo[n]
    }

    @Test
    fun test1() {
        for (i in 0..30) {
            System.err.println(
                nthFactorial(i).let {
                    "fact($i) = $it"
                }
            )
        }
    }

}
