package hotel;

import java.util.Objects;


public class Customer {
   


    public Customer(int numerodeclientes, daysdisponiveis datareserva, float dinheiro) {
        this.numerodeclientes = numerodeclientes;
        this.datareserva = datareserva;
        this.dinheiro = dinheiro;
    }

    public int getNumerodeclientes() {
        return this.numerodeclientes;
    }

    public void setNumerodeclientes(int numerodeclientes) {
        this.numerodeclientes = numerodeclientes;
    }

    public daysdisponiveis getDatareserva() {
        return this.datareserva;
    }

    public void setDatareserva(daysdisponiveis datareserva) {
        this.datareserva = datareserva;
    }

    public float getDinheiro() {
        return this.dinheiro;
    }

    public void setDinheiro(float dinheiro) {
        this.dinheiro = dinheiro;
    }

    public Customer numerodeclientes(int numerodeclientes) {
        setNumerodeclientes(numerodeclientes);
        return this;
    }

    public Customer datareserva(daysdisponiveis datareserva) {
        setDatareserva(datareserva);
        return this;
    }

    public Customer dinheiro(float dinheiro) {
        setDinheiro(dinheiro);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Customer)) {
            return false;
        }
        Customer customer = (Customer) o;
        return numerodeclientes == customer.numerodeclientes && Objects.equals(datareserva, customer.datareserva) && dinheiro == customer.dinheiro;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerodeclientes, datareserva, dinheiro);
    }

    @Override
    public String toString() {
        return "{" +
            " numerodeclientes='" + getNumerodeclientes() + "'" +
            ", datareserva='" + getDatareserva() + "'" +
            ", dinheiro='" + getDinheiro() + "'" +
            "}";
    }
    private int numerodeclientes;
    private daysdisponiveis datareserva;
    private float dinheiro;

}