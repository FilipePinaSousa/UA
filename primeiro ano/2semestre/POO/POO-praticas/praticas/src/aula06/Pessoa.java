package aula06;

import aula05.DateYMD;

public class Pessoa {
        private String nome;
        private int cc;
        private DateYMD dataNasc;

    public Pessoa(String nome,int cc ,DateYMD dateYMD ) {
            this.nome = nome;
            this.cc = cc;
            this.dataNasc = dateYMD;
        }

        





        String getName(){
            return nome;
        }
        int getcc(){
            return cc;
        }

        DateYMD getDateNasc(){
            return dataNasc;
        }

        
        public static boolean validatecc(int cc){
            if (String.valueOf(cc).length() == 8){
                return true;
            }
            return false;
        }
    

        public String toString(){
            return "Nome" + getName() + ";CC" + getcc() + "Data de Nascimento"+ getDateNasc();

        }


}
