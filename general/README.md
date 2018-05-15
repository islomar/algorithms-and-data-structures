# General

`%`: remainder operator
* **floating-point arithmetic**
    * https://www.youtube.com/watch?v=PZRI1IfStY0
    * IEEE 754 32-bit: https://www.youtube.com/watch?v=8afbTaA-gOQ
        * 1 bit for the sign
        * 8 bits for the exponent: 127 +/- the real exponent (2^x)
        * 23 bits for the mantissa (number after the 1.)
    * it's scientific notation
    * speed and efficiency (store)
    * significand * base ^ exponent
        * e.g. 1.2345 = 12345 * 10^(-4)
    * The radix point "floats"
    * Trade-off between range and precision
    * 32-bit computers: 23 for the significand
    * Computers don't understand recurring (e.g. 1/3 = 0.333...), hence the round floating-point error
    * E.g. 1/3 + 1/3 + 1/3 = 0.9999999
    * E.g. 0.1 + 0.2 = 0.30000000000001
    * Usually, that is not problem. BUT it is for Currency, so don't use float there.
* **one's complement**
    * Swap 1<---->0
    * E.g: `01110010` -> `10001101`
* **two's complement**
    * It helps to represent negative values
    * The most significative represents the sign (the one most to the left). 1 = negative
    * Two ways
        * one's complement + 1
            * E.g. for -10:
                * 10 = `00001010`
                * 1's complement = `11110101`
                *  + 1 = `11110110`
        * From right to left: find the first 1, keep it, and from there to the left swap 1-> 0 and 0 -> 1
            * E.g. -10
                * +10   = `00001010`
                * Swap  = `11110110`

## Fibonacci
* https://stackoverflow.com/questions/494594/how-to-write-the-fibonacci-sequence
* Without memoization: O(2^n)

## Java types
https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html

### Array
After creation, the size is fixed

### Primitive data types
* byte: 8-bit signed two's complement integer
* short: 16-bit signed two's complement integer
* int: 32-bit signed
* long: 64-bit signed
* float: single-precision 32-bit IEEE 754 floating point
* double: double-precision 64-bit IEEE 754 floating point
* boolean: the size is not precisely defined
* char: single 16-bit Unicode character