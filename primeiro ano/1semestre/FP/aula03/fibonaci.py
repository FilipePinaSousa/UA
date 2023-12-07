from tkinter import Y


n1=(int(input("introduza um numero")))
n2=(int(input("introduza um numero")))
def mdc(n1,n2):
    r = n1%n2
    if r==0:
        return n2
    else:
        y= mdc(n2,r)
        return y
print("mdc(a,b)=",mdc(n1,n2))