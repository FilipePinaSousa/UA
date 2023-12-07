package jogodavelha;

import jogodavelha.cell.CellType;

public class Tabuleiro {
    private CellType[][] tabuleiro = new CellType[3][3];

    public Tabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = CellType.VAZIA;
            }
        }
    }

    public CellType[][] getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(CellType[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

   

    public boolean jaContem(CellType cellType) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == cellType) {
                    return true;
                }
            }
        }
        return false;
    }
}
