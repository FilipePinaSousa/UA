package listatelefonica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Listatelefonicamain {
    private static List<Contact> contactos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String numero;
        String email;
        int opt;

        do {
            System.out.println();
            System.out.println("1 - Inserir contacto");
            System.out.println("2 - Alterar contacto");
            System.out.println("3 - Apagar contacto");
            System.out.println("4 - Procurar contacto");
            System.out.println("5 - Listar contactos");
            System.out.println("6 - Listar contactos ordenados por nome");
            System.out.println("7 - Listar contactos ordenados por email");
            System.out.println("8 - Listar contactos ordenados por numero");
            System.out.println("9 - Listar contactos ordenados por data de nascimento");
            System.out.println("0 - Sair");
            System.out.println();
            System.out.print("Operação: ");
            opt = sc.nextInt();

            switch (opt) {
                case 0: {
                    System.out.println("Encerrando...");
                    break;
                }
                case 1: {
                    Contact contacto = createContact(sc);

                    if (contacto == null) continue;

                    contactos.add(contacto);
                    break;
                }
                case 2: {
                    Contact contacto = searchContact(sc);

                    if (contacto == null) continue;

                    do {
                        System.out.println("Insira o telemovel");
                        numero = sc.next();

                        if (!numero.matches("9\\d{8}")) {
                            System.out.println("O numero deve ter 9 algarismos e começar por 9 ");
                        } else {
                            contacto.setNumero(Integer.parseInt(numero));
                        }

                        System.out.println("Insira o email");
                        email = sc.next();

                        if (!email.matches(".+@.+\\.(com|pt|org|net)")) {
                            System.out.println("O email deve ter @ e terminar com .com ");
                        } else {
                            contacto.setEmail(email);
                        }

                    } while (!email.matches(".+@.+\\.(com|pt|org|net)") || !numero.matches("9\\d{8}"));
                    break;
                }
                case 3: {
                    Contact contacto = searchContact(sc);

                    if (contacto == null) continue;

                    contactos.remove(contacto);
                    break;
                }
                case 4: {
                    Contact contacto = searchContact(sc);

                    if (contacto == null) continue;

                    System.out.println(contacto);
                    break;
                }
                case 5: {
                    for (Contact contacto : contactos) {
                        System.out.println(contacto);
                    }
                    break;
                }
                default:
                    System.out.println("Escolha uma opção válida!");
                    break;
            }
        } while (opt != 0);

        sc.close();
    }

    private static Contact createContact(Scanner sc) {
        System.out.println("Insira o nome:");
        String nome = sc.next();

        System.out.println("Insira a data de nascimento (AAAA-MM-DD):");
        String dataNascimentoString = sc.next();
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoString);

        System.out.println("Insira o telemovel:");
        String numero = sc.next();

        System.out.println("Insira o email:");
        String email = sc.next();

        if (!email.matches(".+@.+\\.(com|pt|org|net)")) {
            System.out.println("O email deve ter @ e terminar com .com");
            return null;
        }

        if (!numero.matches("9\\d{8}")) {
            System.out.println("O número de telefone deve ter 9 dígitos e começar com 9");
            return null;
        }

        return new Contact(nome, Integer.parseInt(numero), email, dataNascimento);
    }

    private static Contact searchContact(Scanner sc) {
        List<Contact> candidates = new ArrayList<>();
        int opt;

        do {
            System.out.println();
            System.out.println("4 - Procurar contacto por nome");
            System.out.println("5 - Procurar contacto por numero");
            System.out.println("6 - Procurar contacto por email");
            System.out.println("0 - Abortar");
            System.out.println();
            System.out.print("Operação: ");
            opt = sc.nextInt();

            switch (opt) {
                case 0: {
                    return null;
                }
                case 4: {
                    System.out.print("Nome: ");
                    String searchNome = sc.next();

                    for (Contact contacto : contactos) {
                        if (contacto.getNome().equals(searchNome)) {
                            candidates.add(contacto);
                        }
                    }
                    break;
                }
                case 5: {
                    System.out.print("Numero: ");
                    String searchNumero = sc.next();

                    for (Contact contacto : contactos) {
                        if (contacto.getNumero().toString().equals(searchNumero)) {
                            candidates.add(contacto);
                        }
                    }
                    break;
                }
                case 6: {
                    System.out.print("Email: ");
                    String searchEmail = sc.next();

                    for (Contact contacto : contactos) {
                        if (contacto.getEmail().equals(searchEmail)) {
                            candidates.add(contacto);
                        }
                    }
                    break;
                }
                default:
                    System.out.println("Escolha uma opção válida!");
                    break;
            }
        } while (opt != 0);

        if (candidates.isEmpty()) {
            System.out.println("Nenhum contacto encontrado");
            return null;
        } else if (candidates.size() == 1) {
            return candidates.get(0);
        } else {
            System.out.println("Mais de um contacto encontrado. Escolha um:");
            for (int i = 0; i < candidates.size(); i++) {
                System.out.println((i + 1) + ". " + candidates.get(i));
            }
            System.out.print("Opção: ");
            int option = sc.nextInt();
            return candidates.get(option - 1);
        }
    }
}
