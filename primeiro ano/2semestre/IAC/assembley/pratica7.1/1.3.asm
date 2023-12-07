.data
	prompt1: .asciiz "Introduza um numero \n"
	result: .asciiz "O fatorial do numero inserido e: "
.text
main:	
	li $v0, 4
	la $a0, prompt1
	syscall
	
	li $v0, 5
	syscall
	move $t0, $v0
	
	addi $t1, $zero, 1
	
	for:
		ble $t0, 0, exit
		
		mult $t1, $t0
		mflo $t1
	
		subi $t0, $t0, 1
		
		j for
	exit:
		li $v0, 4
		la $a0, prompt1
		syscall
		
		li $v0, 1
		move $a0, $t1
		syscall