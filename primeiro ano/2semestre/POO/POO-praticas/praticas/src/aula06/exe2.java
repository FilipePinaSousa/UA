package aula06;
import aula05.DateYMD;
import java.util.Scanner;


import java.util.ArrayList;

public class exe2 {
    
    private static ArrayList<contactos> contactos = new ArrayList<>();
    

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String numero;
        String email;
        int opt;
        

        do{
            System.out.println();
            System.out.println("1 - Inserir contacto");
            System.out.println("2 - Alterar contacto");
            System.out.println("3 - Apagar contacto");
            System.out.println("4 - Procurar contacto");
            System.out.println("5 - Listar contactos");
            System.out.println("0 - Sair");
            System.out.println();
            System.out.print("Operação: ");
            opt=sc.nextInt();
            

            switch(opt){
                case 0:{
                    System.out.println("Encerrando...");
                    break;
                } 
                case 1:
                Pessoa pessoa = createPessoa(sc);

                if (pessoa == null) continue;
                

                contactos contacto;
               
                do{
                    System.out.println("Insira o telemovel");
                    numero = sc.next();
                        
                    System.out.println("Insira o emeail");
                    email =sc.next();

                    if (!email.matches(".+@.+\\.(com|pt|org|net)")){
                        System.out.println("O email tem de ter @ digitos e acabar com .com ");        
                    }
                }while(!email.matches(".+@.+\\.(com|pt|org|net)") || !numero.matches("9\\d{8}"));
                    
                contacto = new contactos(pessoa, numero, email);
                contactos.add(contacto);
                break;
                case 2:
                contacto = searchContacto(sc);

                if (contacto == null) continue;  
                do{
                    
                    System.out.println("Insira o telemovel");
                    numero = sc.next();

                    if (!numero.matches("9\\d{8}")) {
                        System.out.println("O numero deve ter 9 algarismos e começar por 9 ");
                    }else{
                        contacto.setnumero(numero);
                    }
                                  
                    System.out.println("Insira o email");
                    email =sc.next();

                    if (!email.matches(".+@.+\\.(com|pt|org|net)")){
                        System.out.println("O email tem de ter @ digitos e acabar com .com ");
                    }else{
                        contacto.setEmail(email);
                    }

                }while(!email.matches(".+@.+\\.(com|pt|org|net)") || !numero.matches("9\\d{8}"));
                break;
                case 3:
                 contacto = searchContacto(sc);

                    if (contacto == null) continue;

                    contactos.remove(contacto);
                    break;
                case 4:
                 contacto = searchContacto(sc);

                if (contacto == null) continue;

                System.out.println(contacto);
                    break;
                case 5:{
                    
                    for (contactos a : contactos) {
                        System.out.println(a);
                    }
                    break;
                }
                default:
                    System.out.println("Escolha uma opção válida!");
                    break;
            }
        } while(opt!=0);

        sc.close();
    }

    private static Pessoa createPessoa(Scanner sc) {
        
        String nome = "";
        do{
            System.out.println("Insira o nome da pessoa: ");
            nome = sc.next();
        }while(nome.length()< 0);
        int cc;
        do{
            System.out.println("Insira o cartao de cidadão: ");
            cc = sc.nextInt();

            if(cc < 1){
                System.out.println("O cc tem de ser maior ou igual a 1: ");
            }

        }while(cc < 1);
        System.out.println("Insira o cartao de cidadao: ");
         
        

        for (contactos contacto : contactos) {
            if (contacto.getNome().getcc() == cc) {
                System.out.println("Já existe um contacto com esta pessoa");
                System.out.println(contacto);
                
                return null;
                
            }
        }

        int mes = 0;
        int dia = 0;
        int ano = 0;
        

        do{
            System.out.println("Escolha ano");
            ano = sc.nextInt();
            if (ano < 0){
                System.out.println("Escolha um ano valido");
            }
         }while(ano < 0);
       
        do{
            System.out.println("Escolha mes");
           mes = sc.nextInt();
           if(!DateYMD.validMonth(mes, ano)){
            System.out.println("Escolha um mes valido");
           }
        }while(!DateYMD.validMonth(mes, ano));
        do{
            System.out.println("Escolha dia");
            dia = sc.nextInt();
            if(!DateYMD.validDay(dia, mes, ano)){
                System.out.println("Escolha um dia valido");
            }
         }while(!DateYMD.validDay(dia, mes, ano));
         


         DateYMD dataNasc = new DateYMD(dia, mes, ano);
        
         
         return new Pessoa( nome, cc ,dataNasc );
             
    }
        
    private static contactos searchContacto(Scanner sc) {
       
        ArrayList<contactos> candidates = new ArrayList<>();
        int p;

        do{
            System.out.println();
            System.out.println("1 - Procurar por nome");
            System.out.println("2 - Procurar por número");
            System.out.println("0 - Abortar");
            System.out.println();
            System.out.print("Operação: ");
            p = sc.nextInt();
            
            

            switch (p) {
                case 0 : {
                    return null;
                }
                case 1 : {
                    System.out.print("Nome: ");
                    String searchNome = sc.next();
    
                    for (contactos contacto : contactos) {
                        if (contacto.getNome().getName().contains(searchNome)) {
                            candidates.add(contacto);
                        }
                    }
                }
                case 2 : {
                    System.out.print("Numero: ");
                    String searchNumber = sc.next();
    
                    for (contactos contacto : contactos) {
                        if (contacto.getNumero().startsWith(searchNumber)) {
                            candidates.add(contacto);
                        }
                    }
                }
                default : {
                    System.out.println("Escolha uma opção válida!");
                    break;
                }

            }
        }while(p <0);
    
        if (candidates.size() == 0) {
            System.out.println("Nenhum contacto encontrado");
            return null;
            
        } else if (candidates.size() == 1) {
            
            return candidates.get(0);
        } else {
            System.out.println("Multiple contacts found select one");
            int counter = 0;

            for (contactos candidate : candidates) {
                System.out.println(candidate);
                counter += 1;
            }

            while (true) {
                int idSelection = 0;
                do{
                    System.out.println("Escolha o id");
                    idSelection = sc.nextInt();
                    
                }while(idSelection < 0 || idSelection > counter );


                
                

                for (contactos candidate : candidates) {
                    if (candidate.getID() == idSelection) {
                        return candidate;
                    }
                }
                
                System.out.println("Invalid ID, please insert a valid ID");
            }

            
        }
        

        
    
    }
}
    

       

        
    


        

    