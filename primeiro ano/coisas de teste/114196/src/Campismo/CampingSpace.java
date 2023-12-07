package Campismo;

import java.util.HashMap;
import java.util.Objects;

public abstract class CampingSpace {
    private String localização;
    private HashMap<Integer,Integer> dimensões;
    protected int preçopordia;
    protected int maximoaluger;

    public CampingSpace() {
    }

    public CampingSpace(String localização, HashMap<Integer,Integer> dimensões, int preçopordia, int maximoaluger) {
        this.localização = localização;
        this.dimensões = dimensões;
        this.preçopordia = preçopordia;
        this.maximoaluger = maximoaluger;
    }

    public String getLocalização() {
        return this.localização;
    }

    public void setLocalização(String localização) {
        this.localização = localização;
    }

    public HashMap<Integer,Integer> getDimensões() {
        return this.dimensões;
    }

    public void setDimensões(HashMap<Integer,Integer> dimensões) {
        this.dimensões = dimensões;
    }

    public int getPreçopordia() {
        return this.preçopordia;
    }

    public void setPreçopordia(int preçopordia) {
        this.preçopordia = preçopordia;
    }

    public int getMaximoaluger() {
        return this.maximoaluger;
    }

    public void setMaximoaluger(int maximoaluger) {
        this.maximoaluger = maximoaluger;
    }

    public CampingSpace localização(String localização) {
        setLocalização(localização);
        return this;
    }

    public CampingSpace dimensões(HashMap<Integer,Integer> dimensões) {
        setDimensões(dimensões);
        return this;
    }

    public CampingSpace preçopordia(int preçopordia) {
        setPreçopordia(preçopordia);
        return this;
    }

    public CampingSpace maximoaluger(int maximoaluger) {
        setMaximoaluger(maximoaluger);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CampingSpace)) {
            return false;
        }
        CampingSpace campingSpace = (CampingSpace) o;
        return Objects.equals(localização, campingSpace.localização) && Objects.equals(dimensões, campingSpace.dimensões) && preçopordia == campingSpace.preçopordia && maximoaluger == campingSpace.maximoaluger;
    }

    @Override
    public int hashCode() {
        return Objects.hash(localização, dimensões, preçopordia, maximoaluger);
    }

    @Override
    public String toString() {
        return "{" +
            " localização='" + getLocalização() + "'" +
            ", dimensões='" + getDimensões() + "'" +
            ", preçopordia='" + getPreçopordia() + "'" +
            ", maximoaluger='" + getMaximoaluger() + "'" +
            "}";
    }

    public SpaceType getSpaceType() {
        return null;
    }
    
}