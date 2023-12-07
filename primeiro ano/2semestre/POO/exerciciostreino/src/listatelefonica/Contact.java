package listatelefonica;

import java.time.LocalDate;
import java.util.Objects;

public class Contact {
    private int ID;
    private String nome;
    private Integer numero;
    private String email;
    private LocalDate dataNascimento;
    private static int counter = 1;

    public Contact(String nome, Integer numero, String email, LocalDate dataNascimento) {
        if (nome == null)
            throw new IllegalArgumentException("O nome não pode ser nulo");

        if (numero == null && email == null)
            throw new IllegalArgumentException("O número de telefone e email não podem ser ambos nulos");

        if (numero != null && !validaNumero(numero))
            throw new IllegalArgumentException("O número de telefone deve conter 9 dígitos e começar com 9");

        if (email != null && !validaEmail(email))
            throw new IllegalArgumentException("O email deve conter um '@' e um domínio válido");

        this.ID = counter++;
        this.nome = nome;
        this.numero = numero;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public Contact() {
    }

    public Contact(int ID, String nome, Integer numero, String email, LocalDate dataNascimento) {
        this.ID = ID;
        this.nome = nome;
        this.numero = numero;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNumero() {
        return this.numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Contact ID(int ID) {
        setID(ID);
        return this;
    }

    public Contact nome(String nome) {
        setNome(nome);
        return this;
    }

    public Contact numero(Integer numero) {
        setNumero(numero);
        return this;
    }

    public Contact email(String email) {
        setEmail(email);
        return this;
    }

    public Contact dataNascimento(LocalDate dataNascimento) {
        setDataNascimento(dataNascimento);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Contact))
            return false;
        Contact contact = (Contact) o;
        return ID == contact.ID && Objects.equals(numero, contact.numero) && Objects.equals(nome, contact.nome)
                && Objects.equals(email, contact.email) && Objects.equals(dataNascimento, contact.dataNascimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, nome, numero, email, dataNascimento);
    }

    @Override
    public String toString() {
        return "{" +
                " ID='" + getID() + "'" +
                ", nome='" + getNome() + "'" +
                ", numero='" + getNumero() + "'" +
                ", email='" + getEmail() + "'" +
                ", dataNascimento='" + getDataNascimento() + "'" +
                "}";
    }

    private boolean validaNumero(Integer numero) {
        if (numero == null)
            return false;

        String numeroString = String.valueOf(numero);
        return numeroString.length() == 9 && numeroString.startsWith("9");
    }

    private boolean validaEmail(String email) {
        if (email == null)
            return false;

        return email.contains("@");
    }
}
