.data
lista: .space 24 # espa�o para armazenar 6 inteiros de 4 bytes cada

msg: .asciiz "Insira 6 numeros: "

.text
main:
    # Inicializa o contador i com 0
    li $t0, 0

    #prime a mensagem para inserir os n�meros
    la $a0, msg
    li $v0, 4
    syscall

loop:
    # Verifica se i � menor que 6
    slti $t1 $t0, 6
    beq $t1, $zero, exit # Se i >=6, sai do loop

    #L� um n�mero inteiro e armazena na lista
    li $v0, 5
    syscall
    sw $v0, ($t0, lista) # Calcula o endere�o correto

    # Incrementa o contador i
    addi $t0, $t0, 1

    j loop # Salta de volta o in�cio do loop

exit:
    # Termina o programa
 li $v0, 10
    syscall
.end
