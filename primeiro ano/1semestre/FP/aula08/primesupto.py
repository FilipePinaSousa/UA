def primesUpTo(n):
    primes = {x for x in range(2, n+1)}
    for p in range(2, int(n**0.5)+1):
        primes -= {x for x in range(p**2, n+1, p)}
    return primes
    
s = primesUpTo(1000)
print(s)
print(len(s))

assert primesUpTo(30) == {2,3,5,7,11,13,17,19,23,29}
assert len(primesUpTo(1000)) == 168
assert len(primesUpTo(7918)) == 999
assert len(primesUpTo(7919)) == 1000
print("All tests passed!")




