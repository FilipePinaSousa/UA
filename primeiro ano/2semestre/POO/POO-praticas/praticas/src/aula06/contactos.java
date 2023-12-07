package aula06;

public class contactos{
    private int ID;
    private Pessoa nome;
    private String numero;
    private String email;


    private static int counter = 1;

    public contactos(Pessoa nome, String numero, String email) {
        if (nome == null)
            throw new IllegalArgumentException("A pessoa não pode ser nula");

        if (numero == null && email == null)
            throw new IllegalArgumentException("O email e número do telemóvel não podem ser os dois nulos");

        if (numero != null && !validnumero(numero))
            throw new IllegalArgumentException("O número de telemóvel deve conter 9 digitos e começar por 9");

        if (email != null && !validEmail(email))
            throw new IllegalArgumentException("O email tem que conter um @ e o domínio");

        this.ID = counter++;
        this.nome = nome;
        this.numero = numero;
        this.email = email;
    }



    

    private static boolean validnumero(String numero) {
        return numero.matches("^9[0-9]{8}$");
    }

    private static boolean validEmail(String email) {
        return email.matches("^.+@[^@]+\\.[^@]+$");
    }

    public Pessoa getNome(){
        return nome;
    }
    public int getID(){
        return ID;
    }

    public String getemail(){
        return email;
    }
    public String getNumero(){
        return numero;
    }

    public void setnumero(String numero) {
        if (numero == null && this.email == null)
            throw new IllegalArgumentException("O email e número do telemóvel não podem ser os dois nulos");

        if (!validnumero(numero))
            throw new IllegalArgumentException("O número de telemóvel deve conter 9 digitos e começar por 9");

        this.numero = numero;
    }

    public void setEmail(String email) {
        if (this.numero == null && email == null)
            throw new IllegalArgumentException("O email e número do telemóvel não podem ser os dois nulos");

        if (!validEmail(email))
            throw new IllegalArgumentException("O número de telemóvel deve conter 9 digitos e começar por 9");

        this.email = email;
    }



    


 
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        contactos contacto = (contactos) obj;

        return this.ID == contacto.ID;
    }


    public String toString() {
        String accum = "ID: " + this.getID() + "; Nome: " + this.nome.getName();

        if (this.numero != null)
            accum += "; telemóvel: " + this.numero;

        if (this.email != null)
            accum += "; email: " + this.email;

        return accum;
    }
}