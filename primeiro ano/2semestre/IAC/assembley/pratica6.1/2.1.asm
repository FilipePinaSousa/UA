.data
numero: .asciiz "Introduza um numero: "
soma: .asciiz "A soma dos numeros positivos e: "
cena: .asciiz "oi"

.text
main:
addi $t0, $0, 0 # i
addi $t1, $s0, 0 # total

for:
bge $t0, 5, exit #if

#Print numero
li $v0, 4
la $a0, numero
syscall

#Pedir numero
li $v0, 5
syscall
move $t2, $v0

#Se o numero for positivo somar ao total
blez $t2, else
add $t1, $t1, $t2

else:
addi $t0, $t0, 1
j for

exit:
#Print dos resultados
li $v0, 4
la $a0, soma
syscall

li $v0, 1
move $a0, $t1
syscall

#Fim do programa
li $v0, 10
syscall
