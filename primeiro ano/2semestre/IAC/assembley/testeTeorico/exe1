.data
msg: .asciiz "O nr de impares:"
nums: .word -2, 3, -19, 4, 8, 126, -131, 17

.text
main:
	la $a0, msg   # carrega o endereço de msg em $a0
	li $v0, 4     # chamada de sistema para imprimir string
	syscall       # executa a chamada de sistema

	li $t0, 0     # inicializa i = 0
	li $t1, 0     # inicializa imps = 0
	
for_loop:
	lw $t2, nums($t0)      # carrega o elemento no índice i do array nums
	andi $t2, $t2, 1       # realiza um AND bit a bit com 1 para verificar se é ímpar
	bnez $t2, inc_imps     # se o resultado for diferente de zero (ímpar), salta para inc_imps
	
	# continua para a próxima iteração
	addi $t0, $t0, 4       # incrementa i em 1 (assumindo que cada elemento em nums tem 4 bytes)
	bne $t0, $zero, for_loop  # salta para for_loop se i for diferente de zero

	# imprime o resultado
	li $v0, 4               # chamada de sistema para imprimir string
	la $a0, msg             # carrega o endereço de msg em $a0
	syscall                 # executa a chamada de sistema
	
	li $v0, 1               # chamada de sistema para imprimir inteiro
	move $a0, $t1           # move o valor de imps para $a0
	syscall                 # executa a chamada de sistema
	
	# encerra o programa
	li $v0, 10              # chamada de sistema para encerrar o programa
	syscall                 # executa a chamada de sistema

inc_imps:
	addi $t1, $t1, 1        # incrementa imps em 1
	bne $t0, $zero, for_loop  # salta para for_loop se i for diferente de zero
