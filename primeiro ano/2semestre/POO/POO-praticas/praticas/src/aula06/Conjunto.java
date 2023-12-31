package aula06;

    import java.util.Arrays;

public class Conjunto {
    private int[] elementos;
    private int tamanho;

    public Conjunto() {
        elementos = new int[10];
        tamanho = 0;
    }

    public void insert(int n) {
        if (!contains(n)) {
            if (tamanho == elementos.length) {
                elementos = Arrays.copyOf(elementos, tamanho * 2);
            }
            elementos[tamanho++] = n;
        }
    }

    public boolean contains(int n) {
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i] == n) {
                return true;
            }
        }
        return false;
    }

    public void remove(int n) {
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i] == n) {
                elementos[i] = elementos[tamanho - 1];
                tamanho--;
                return;
            }
        }
    }

    public void empty() {
        tamanho = 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < tamanho; i++) {
            sb.append(elementos[i]);
            if (i != tamanho - 1) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public int size() {
        return tamanho;
    }

    public Conjunto unir(Conjunto add) {
        Conjunto uniao = new Conjunto();
        for (int i = 0; i < tamanho; i++) {
            uniao.insert(elementos[i]);
        }
        for (int i = 0; i < add.tamanho; i++) {
            uniao.insert(add.elementos[i]);
        }
        return uniao;
    }

    public Conjunto subtrair(Conjunto dif) {
        Conjunto diferenca = new Conjunto();
        for (int i = 0; i < tamanho; i++) {
            if (!dif.contains(elementos[i])) {
                diferenca.insert(elementos[i]);
            }
        }
        return diferenca;
    }

    public Conjunto interset(Conjunto inter) {
        Conjunto intersecao = new Conjunto();
        for (int i = 0; i < tamanho; i++) {
            if (inter.contains(elementos[i])) {
                intersecao.insert(elementos[i]);
            }
        }
        return intersecao;
    }
}
