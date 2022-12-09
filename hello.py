# A simple Chocopy program
# print() is a built-in function implemented in the interpreter

def sum_10() -> int:
    s = 0
    a = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    for i in a:
        s = s + i

    return s

def fib(n: int) -> int:
    if n == 0:
        return 0
    elif n == 1:
        return 1
    else:
        return fib(n-1) + fib(n-2)

def foo():
    a = 10
    print("Inside foo a =", a)

def ret():
    return 10

def main():
    # Lexical scoping
    a = 0
    print("Before foo a =", a)
    foo()
    print("After foo a =", a)

    # Recursion
    print("fib(8) = ", fib(8))

    # For loop
    print("sum_10() = ", sum_10())

    # While loop
    i = 0
    while i < 10:
        i = i + 2
        print("i =", i)

main()
