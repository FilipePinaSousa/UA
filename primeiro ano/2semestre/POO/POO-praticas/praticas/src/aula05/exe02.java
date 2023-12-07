package aula05;
import java.util.Scanner;

public class exe02 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            calendario calendar = null;
            int year;
            int month;
            int firstDayOfWeek = 0;

            while (true) {
                System.out.println();
                System.out.println("Escolha uma opção:");
                System.out.println("1 - Criar um novo calendário");
                System.out.println("2 - Adicionar evento");
                System.out.println("3 - Remover evento");
                System.out.println("4 - Imprimir um mês do calendário");
                System.out.println("5 - Imprimir calendário completo");
                System.out.println("6 - Sair");
                System.out.println();
                System.out.print("Opção: ");

                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        System.out.print("Digite o ano do calendárdaeio: ");
                        year = scanner.nextInt();
                        System.out.printf("Digite o primeiro dia da semana do mês (1 a 7):\n");
                        System.out.printf("%9s | %9s | %9s | %9s | %9s | %9s | %9s \n", "1=Domingo", "2=Segunda", "3=Terça",
                                "4=Quarta", "5=Quinta", "6=Sexta", "7=Sábado");
                        firstDayOfWeek = scanner.nextInt();
                        if (firstDayOfWeek >= 1 && firstDayOfWeek <= 7) {
                            calendar = new calendario(year, firstDayOfWeek);
                            System.out.println("Calendário criado com sucesso.");
                        } else {
                            System.out.println("Digite um dia da semana válido!");
                        }
                        break;

                    case 2:
                        if (calendar == null) {
                            System.out.println("Crie um novo calendário primeiro!");
                        } else {
                            System.out.println("Digite a data do evento (formato: yyyy-mm-dd):");
                            String dateStr = scanner.next();
                            DateYMD date = DateYMD.fromString(dateStr);
                            calendar.addEvent(date);
                            System.out.println("Evento adicionado com sucesso.");
                        }
                        break;

                    case 3:
                        if (calendar == null) {
                            System.out.println("Crie um novo calendário primeiro!");
                        } else {
                            System.out.println("Digite a data do evento a ser removido (formato: yyyy-mm-dd):");
                            String dateStr = scanner.next();
                            DateYMD date = DateYMD.fromString(dateStr);
                            calendar.removeEvent(date);
                            System.out.println("Evento removido com sucesso.");
                        }
                        break;

                    case 4:
                        if (calendar == null) {
                            System.out.println("Crie um novo calendário primeiro!");
                        } else {
                            System.out.print("Digite o mês a ser impresso: ");
                            month = scanner.nextInt();
                            String monthName = calendario.getMonthName(month);
                            if (monthName != null) {
                                calendar.printMonth(month);
                            } else {
                                System.out.println("Digite um mês válido!");
                            }
                        }
                        break;

                    case 5:
                        if (calendar == null) {
                            System.out.println("Crie um novo calendário primeiro!");
                        } else {
                            System.out.println(calendar.toString());
                        }
                        break;

                    case 6:
                        System.out.println("Encerrando...");
                        return;

                    default:
                        System.out.println("Digite uma opção válida!");
                        break;
                }
            }
        }
    }
}
