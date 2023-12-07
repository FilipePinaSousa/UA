# Complete the code to make the HiLo game...

import random

def main():
    # Pick a random number between 1 and 100, inclusive
    secret = random.randrange(1, 101)
    print("Can you guess my secret?")
    # put your code here
    numero=int(input("introduza um numero"))
    while numero != secret:
        if numero > secret:
            print("o numero e mais baixo")
            numero=int(input("introduza um numero"))        
        elif numero < secret:
            print("o numero e mais alto")
            numero=int(input("introduza um numero"))   
        else:
            print("acertou miseraveu ")
            numero=int(input("introduza um numero"))   



main()
