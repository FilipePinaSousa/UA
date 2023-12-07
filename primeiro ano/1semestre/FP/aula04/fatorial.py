def factorial(x,y,z):
    
    while x>0 : 
     x=(int(input("selecione um numero")))
     
    x = x-1
    y = x-1
    z = y*x

    z= factorial(z)
    print(z) 
    