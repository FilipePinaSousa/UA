package jogodavelha;
import java.util.Scanner;

import jogodavelha.cell.CellType;

public class Jogo {
    private boolean vencedor;
    private int rodada = 1;
    private Jogador jogador1;
    private Jogador jogador2;
    private Tabuleiro tabuleiro;
    
    public void iniciarJogadores() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Quem vai ser o Jogador 1 ?");
        String nomeJogador1 = scanner.nextLine();
        this.jogador1 = new Jogador(nomeJogador1);
    
        System.out.println("----------------------");
        System.out.println("Quem vai ser o Jogador 2 ?");
        String nomeJogador2 = scanner.nextLine();
        this.jogador2 = new Jogador(nomeJogador2);
        scanner.close();
    }
    

    public void iniciarTabuleiro() {
        this.tabuleiro = new Tabuleiro();
    }

    public void jogar() {
        Scanner scanner = new Scanner(System.in);

        while (!vencedor && rodada <= 9) {
            Jogador jogadorAtual = (rodada % 2 == 1) ? jogador1 : jogador2;
            System.out.println("Rodada: " + rodada);
            System.out.println("Vez do jogador: " + jogadorAtual.getNome());

            int linha, coluna;
            do {
                System.out.print("Digite a linha (0-2): ");
                linha = scanner.nextInt();

                System.out.print("Digite a coluna (0-2): ");
                coluna = scanner.nextInt();
            } while (!validarJogada(linha, coluna));

            CellType cellType = (rodada % 2 == 1) ? CellType.X : CellType.O;
            tabuleiro.getTabuleiro()[linha][coluna] = cellType;
            rodada++;

            // Exibir o tabuleiro
            exibirTabuleiro();

            // Verificar se houve um vencedor
            if (verificarVencedor(cellType)) {
                vencedor = true;
                System.out.println("O jogador " + jogadorAtual.getNome() + " venceu!");
            }
        }

        if (!vencedor) {
            System.out.println("O jogo terminou em empate!");
        }

        scanner.close();
    }

    private void exibirTabuleiro() {
        CellType[][] estadoTabuleiro = tabuleiro.getTabuleiro();

        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(estadoTabuleiro[i][j].toString() + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private boolean validarJogada(int linha, int coluna) {
        CellType[][] estadoTabuleiro = tabuleiro.getTabuleiro();
        if (linha < 0 || linha > 2 || coluna < 0 || coluna > 2) {
            System.out.println("Jogada inválida. Digite valores entre 0 e 2.");
            return false;
        }
        if (estadoTabuleiro[linha][coluna] != CellType.VAZIA) {
            System.out.println("Posição já ocupada. Escolha outra posição.");
            return false;
        }
        return true;
    }

    private boolean verificarVencedor(CellType cellType) {
        CellType[][] estadoTabuleiro = tabuleiro.getTabuleiro();

        // Verificar linhas
        for (int i = 0; i < 3; i++) {
            if (estadoTabuleiro[i][0] == cellType &&
                estadoTabuleiro[i][1] == cellType &&
                estadoTabuleiro[i][2] == cellType) {
                return true;
            }
        }

        // Verificar colunas
        for (int j = 0; j < 3; j++) {
            if (estadoTabuleiro[0][j] == cellType &&
                estadoTabuleiro[1][j] == cellType &&
                estadoTabuleiro[2][j] == cellType) {
                return true;
            }
        }

        // Verificar diagonais
        if (estadoTabuleiro[0][0] == cellType &&
            estadoTabuleiro[1][1] == cellType &&
            estadoTabuleiro[2][2] == cellType) {
            return true;
        }

        if (estadoTabuleiro[0][2] == cellType &&
            estadoTabuleiro[1][1] == cellType &&
            estadoTabuleiro[2][0] == cellType) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Jogo jogo = new Jogo();
        jogo.iniciarJogadores();
        jogo.iniciarTabuleiro();
        jogo.jogar();
    }
}
