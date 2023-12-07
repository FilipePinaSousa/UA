package Basketball;

public class Jogo {

    private Equipa equipaA, equipaB;
    private Bola bola;
    private double tempoTotal;
    private double tempoDecorrido;
    private static final double PARTES_DEFAULT = 4;
    private double partes;
    private double tempoDasPartes;

    public Jogo(Equipa equipaA, Equipa equipaB, Bola bola, double tempoTotal) {
        this.equipaA = equipaA;
        this.equipaB = equipaB;
        this.bola = bola;
        this.tempoTotal = tempoTotal;
        this.partes = partes;
        this.tempoDasPartes = tempoDasPartes;
    }

    public double getTempoTotal() {
        return tempoTotal;
    }

    public double getPartes() {
        return partes;
    }

    public double getTempoDasPartes() {
        return tempoDasPartes;
    }

    public void setTempoTotal(double tempoTotal) {
        this.tempoTotal = tempoTotal;
    }

    public double getTempoDecorrido() {
        return tempoDecorrido;
    }

    public void setTempoDecorrido(double tempoDecorrido) {
        this.tempoDecorrido = tempoDecorrido;
    }

    @Override
    public String toString() {
        return "Jogo entre " + equipaA.getNome() + " e " + equipaB.getNome();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bola == null) ? 0 : bola.hashCode());
        result = prime * result + ((equipaA == null) ? 0 : equipaA.hashCode());
        result = prime * result + ((equipaB == null) ? 0 : equipaB.hashCode());
        long temp;
        temp = Double.doubleToLongBits(tempoDecorrido);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(tempoTotal);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Jogo other = (Jogo) obj;
        if (bola == null) {
            if (other.bola != null)
                return false;
        } else if (!bola.equals(other.bola))
            return false;
        if (equipaA == null) {
            if (other.equipaA != null)
                return false;
        } else if (!equipaA.equals(other.equipaA))
            return false;
        if (equipaB == null) {
            if (other.equipaB != null)
                return false;
        } else if (!equipaB.equals(other.equipaB))
            return false;
        if (Double.doubleToLongBits(tempoDecorrido) != Double.doubleToLongBits(other.tempoDecorrido))
            return false;
        if (Double.doubleToLongBits(tempoTotal) != Double.doubleToLongBits(other.tempoTotal))
            return false;
        return true;
    }
}
