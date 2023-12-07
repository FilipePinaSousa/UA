package aula03;

import java.util.Scanner;

    public class Ex05 {
    
        public static void main(String[] args) {
            
            Scanner sc = new Scanner(System.in);
            int mes, ano, diaSemana;
            do {
                System.out.print("Digite o mês (mm): ");
                mes = sc.nextInt();
            } while (mes < 1 || mes > 12);
            do {
                System.out.print("Digite o ano (yyyy): ");
                ano = sc.nextInt();
            } while (ano < 1);
            do {
                System.out.print("Digite o dia da semana (1 = Segunda, 2 = Terça,...): ");
                diaSemana = sc.nextInt();
            } while (diaSemana < 1 || diaSemana > 7);
            sc.close();

            
            String[] nomesMeses = {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
            String nomeMes = nomesMeses[mes] + " " + ano;
            System.out.println(nomeMes);

            int diasNoMes = calcularDiasNoMes(mes, ano);
            int diaAtual = 1;
            for (int i = 1; i <= 5; i++) {
                for (int j = 1; j <= 7; j++) {
                    if (i == 1 && j < diaSemana) {
                        System.out.print("   ");
                    } else {
                        if (diaAtual <= diasNoMes) {
                            System.out.printf("%2d ", diaAtual);
                            diaAtual++;
                        } else {
                            System.out.print("   ");
                        }
                    }
                }
                System.out.println();
            }
        }

        public static int calcularDiasNoMes(int mes, int ano) {
            switch (mes) {
                case 2:
                    if (ehBissexto(ano)) {
                        return 29;
                    } else {
                        return 28;
                    }
                case 4:
                case 6:
                case 9:
                case 11:
                    return 30;
                default:
                    return 31;
            }
        }

        public static boolean ehBissexto(int ano) {
            if (ano % 400 == 0) {
                return true;
            } else if (ano % 100 == 0) {
                return false;
            } else if (ano % 4 == 0) {
                return true;
            } else {
                return false;
            }
        }
    
    }