import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReconhecimentoFacialLoad {

    public static void main(String[] args) {
        String nomeArquivo = "pessoas.txt";

        try {
            File arquivo = new File(nomeArquivo);
            Scanner scanner = new Scanner(arquivo);

            Pessoa pessoa = null;

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();

                if (linha.startsWith("Nome:")) {
                    // Iniciar uma nova pessoa
                    pessoa = new Pessoa();
                    pessoa.setNome(linha.substring(linha.indexOf(":") + 1).trim());
                } else if (linha.startsWith("Gênero:")) {
                    pessoa.setGenero(linha.substring(linha.indexOf(":") + 1).trim());
                } else if (linha.startsWith("Nariz:")) {
                    pessoa.setNariz(linha.substring(linha.indexOf(":") + 1).trim());
                } else if (linha.startsWith("Boca:")) {
                    pessoa.setBoca(linha.substring(linha.indexOf(":") + 1).trim());
                } else if (linha.startsWith("Cor dos olhos:")) {
                    pessoa.setCorOlhos(linha.substring(linha.indexOf(":") + 1).trim());
                } else if (linha.startsWith("Cor do cabelo:")) {
                    pessoa.setCorCabelo(linha.substring(linha.indexOf(":") + 1).trim());
                } else if (linha.startsWith("Formato do rosto:")) {
                    pessoa.setFormatoRosto(linha.substring(linha.indexOf(":") + 1).trim());
                } else if (linha.startsWith("Idade:")) {
                    pessoa.setIdade(Integer.parseInt(linha.substring(linha.indexOf(":") + 1).trim()));

                    // Processar a pessoa completa
                    System.out.println("Nome: " + pessoa.getNome());
                    System.out.println("Gênero: " + pessoa.getGenero());
                    System.out.println("Nariz: " + pessoa.getNariz());
                    System.out.println("Boca: " + pessoa.getBoca());
                    System.out.println("Cor dos olhos: " + pessoa.getCorOlhos());
                    System.out.println("Cor do cabelo: " + pessoa.getCorCabelo());
                    System.out.println("Formato do rosto: " + pessoa.getFormatoRosto());
                    System.out.println("Idade: " + pessoa.getIdade());
                    System.out.println();

                    // Reiniciar a variável pessoa para a próxima iteração
                    pessoa = null;
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + nomeArquivo);
        }
    }
}