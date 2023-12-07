n=(int(input("introduza um numero ")))
def isPrime(n):
    
    for n in range(0,100):
        if n%n == 0:
            return True
        else:
            return False
value = isPrime(n)

print(f'{n} is prime: {value}')
