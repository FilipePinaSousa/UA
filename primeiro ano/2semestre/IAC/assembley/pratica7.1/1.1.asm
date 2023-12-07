.data
prompt1: .asciiz "Introduza um numero\n"
par: .asciiz "O numero e par\n"
impar: .asciiz "O numero e impar\n"

.text
main:
	li $v0, 4
	la $a0, prompt1 #Apresenta o prompt 
	syscall
	
	li $v0, 5
	syscall
	move $t0, $v0	#Pede um numero ao utilizador
	
	andi $t1, $t0, 1
	bne $t1, $0, imparloop #Compara os numeros a ver se nao sao iguais a zero
	
	li $v0, 4
	la $a0, par
	syscall
	j end
	
imparloop:	li $v0, 4
	la $a0, impar
	syscall
end:
	li $v0,10
	syscall
	
