.data 
	minus : .asciiz "textoeminusculas"
	maius: .space 20
	
	
.text
	

main:
	# i = 0
	addi $t0, $0, 0
	
while:
	la $t1,minus
	add $t2,$t1,$t0
	lb $t3,0($t2) #t3=minus (indice i)
	beq $t3 ,'\0', endwhile
	addi $t4,$t3,'A'
	subi $t4,$t4,'a' #t4 = minus[i] + 'A' -'a'
	la $t5,maius
	add $t6,$t5,$t0#t6 tem endereço de maius indice i
	sb $t4,0($t6)
	
	# i++
	addi $t0, $t0, 1
	j while
	
	
endwhile: 
	la $a0, maius
	li $v0, 4
	syscall 
	#Terminar o programa
	li $v0, 10
	syscall
	
