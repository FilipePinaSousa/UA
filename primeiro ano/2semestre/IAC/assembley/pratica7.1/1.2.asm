.data
	prompt1: .asciiz "Introduza um numero: "
	dash: .asciiz "-"
.text
main:
	li $v0, 4
	la $a0, prompt1
	syscall
	
	li $v0, 5
	syscall
	move $t0, $v0
	
	addi $s0, $0, 0
	
	for:
		bgt $s0, $t0, exit
		
		li $v0, 4
		la $a0, dash
		syscall
		
		addi $s0, $s0, 1
		
		j for
	
	exit:
	
