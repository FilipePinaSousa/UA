def compareFiles(file1,file2):
    file1 = open(file1, "rb")
    file2 = open(file2, "rb")
    bloco1 = file1.read(1024)
    bloco2 = file2.read(1024)
    
    while bloco1 or bloco2:
        if bloco1 != bloco2:
            file1.close()
            file2.close()
            return "Não são iguais."
            
        bloco1 = file1.read(1024)
        bloco2 = file2.read(1024)
        
        file1.close()
        file2.close()
        return "São iguais"
        
    print(compareFiles("nums.txt", "nums-copy.txt"))
    print(compareFiles("nums.txt", "drawing.txt"))