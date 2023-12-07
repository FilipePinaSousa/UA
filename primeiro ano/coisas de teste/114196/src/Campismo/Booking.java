package Campismo;
import java.io.File;
import java.util.*;
import java.util.Objects;

public class Booking {
    private int  aluger;
    private Date  datainicio;
    private Date  datafim;  

    

    public Booking(int aluger, Date datainicio, Date datafim) {
        this.aluger = aluger;
        this.datainicio = datainicio;
        this.datafim = datafim;
    }

    public int getAluger() {
        return this.aluger;
    }

    public void setAluger(int aluger) {
        this.aluger = aluger;
    }

    public Date getDatainicio() {
        return this.datainicio;
    }

    public void setDatainicio(Date datainicio) {
        this.datainicio = datainicio;
    }

    public Date getDatafim() {
        return this.datafim;
    }

    public void setDatafim(Date datafim) {
        this.datafim = datafim;
    }

    public Booking aluger(int aluger) {
        setAluger(aluger);
        return this;
    }

    public Booking datainicio(Date datainicio) {
        setDatainicio(datainicio);
        return this;
    }

    public Booking datafim(Date datafim) {
        setDatafim(datafim);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Booking)) {
            return false;
        }
        Booking booking = (Booking) o;
        return aluger == booking.aluger && Objects.equals(datainicio, booking.datainicio) && Objects.equals(datafim, booking.datafim);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aluger, datainicio, datafim);
    }

    @Override
    public String toString() {
        return "{" +
            " aluger='" + getAluger() + "'" +
            ", datainicio='" + getDatainicio() + "'" +
            ", datafim='" + getDatafim() + "'" +
            "}";
    }
   

    
}
