package aula06;
import java.time.LocalDate;
import aula05.DateYMD;


    public class aluno extends Pessoa {
      


        private static int contador = 100;
        private int  nMec;
        private DateYMD iDataInsc;
        private int IBI = super.getcc();


        public aluno(String iName, int nMec, DateYMD iDataNasc)
        {  
            super(iName, nMec, iDataNasc);
            this.nMec = contador++;
            LocalDate today = LocalDate.now();
        
                int day = today.getDayOfMonth();
                int month = today.getMonthValue();
                int year = today.getYear();
                this.iDataInsc = new DateYMD(year, month, day);

        }

        public aluno(String iName, int nMec, DateYMD iDataNasc, DateYMD iDataInsc){
        super(iName, nMec, iDataNasc);
        this.nMec = contador++;
        this.iDataInsc = iDataInsc;
        }



        public void setNmec(int nMec){
            this.nMec = nMec;
        }

        public int getNmec(){
            return nMec;
        }
        public void setIDataInsc(DateYMD iDataInsc){
            this.iDataInsc = iDataInsc;
        }
        public DateYMD getIDataInsc(){
            return iDataInsc;
        }

  
        public void setIBI(int IBI){
            this.IBI = IBI;
        }
        public int getIBI(){
            return IBI;
        }
        public String toString(){
            return "Nome" + super.getName() + ";CC" + super.getcc() + "Data de Nascimento"+ super.getDateNasc() + "Data de Inscrição" + getIDataInsc();

        }

    }