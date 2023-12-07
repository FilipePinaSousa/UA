
# This program generates 20 terms of a sequence by a recurrence relation.
Un = 100
n = 0      
     # Set Un to the next term of the sequence
while Un > 0:
    n+=1
    Un = 1.01*Un - 1.01 
    print(Un) 
    print("numeros mostrados",n)