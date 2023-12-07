organização=input(str("introduza uma organização:"))
def sigla(str):
    
    abrevi =""
    for caracter  in  str:
        if caracter.isupper():
            abrevi = abrevi + caracter
    
    return abrevi





print(sigla(organização))


