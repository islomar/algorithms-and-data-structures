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