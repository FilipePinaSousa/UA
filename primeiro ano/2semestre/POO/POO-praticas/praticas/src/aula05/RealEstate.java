package aula05;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class RealEstate {
    public static class Imovel {
        private static int proximoId = 1000;
        private int id;
        private int quartos;
        private String localidade;
        private int preco;
        private boolean disponivel;
        private LocalDate inicioLeilao;
        private LocalDate fimLeilao;
        
        public Imovel(int quartos, String localidade, int preco, boolean disponivel) {
            this.id = proximoId++;
            this.quartos = quartos;
            this.localidade = localidade;
            this.preco = preco;
            this.disponivel = disponivel;
        }
        
        public int getId() {
            return id;
        }
        
        public int getQuartos() {
            return quartos;
        }
        
        public String getLocalidade() {
            return localidade;
        }
        
        public int getPreco() {
            return preco;
        }
        
        public boolean isDisponivel() {
            return disponivel;
        }
        
        public LocalDate getInicioLeilao() {
            return inicioLeilao;
        }
        
        public LocalDate getFimLeilao() {
            return fimLeilao;
        }
        
        public void setDisponivel(boolean disponivel) {
            this.disponivel = disponivel;
        }
        
        public void setLeilao(LocalDate inicioLeilao, LocalDate fimLeilao) {
            this.inicioLeilao = inicioLeilao;
            this.fimLeilao = fimLeilao;
        }
        public String toString() {
            String leilaoString = "";
            if (inicioLeilao != null && fimLeilao != null) {
                leilaoString = String.format("; leilão %s : %s", inicioLeilao, fimLeilao);
            }
            return String.format("Imóvel: %d; quartos: %d; localidade: %s; preço: %d; disponível: %s%s", 
                                 id, quartos, localidade, preco, disponivel ? "sim" : "não", leilaoString);
        }
    }

    public static class AgenciaLeilao {
        private List<Imovel> imoveis;
        
        public AgenciaLeilao() {
            this.imoveis = new ArrayList<>();
        }
        
        public void adicionarImovel(Imovel imovel) {
            imoveis.add(imovel);
        }
        
        public void removerImovel(int id) {
            Imovel imovel = procurarImovel(id);
            if (imovel != null) {
                imoveis.remove(imovel);
            } else {
                System.out.printf("Imóvel %d não existe.%n", id);
            }
        }
        
        public void venderImovel(int id) {
            Imovel imovel = procurarImovel(id);
            if (imovel != null) {
                if (imovel.isDisponivel()) {
                    System.out.printf("Imóvel %d vendido.%n", id);
                    imovel.setDisponivel(false);
                } else {
                    System.out.printf("Imóvel %d não está disponível.%n", id);
                }
            } else {
                System.out.printf("Imóvel %d não existe.%n", id);
            }
        }
        
        public void listarImoveis() {
            System.out.println("Propriedades: ");
            for (Imovel imovel : imoveis) {
                System.out.println(imovel);
            }
        }
        private Imovel procurarImovel(int id) {
            for (Imovel imovel : imoveis) {
                if (imovel.getId() == id) {
                    return imovel;
                }
            }
            return null;
        }

        

       
        }
        public static class Main {
            public static void main(String[] args) {
                AgenciaLeilao agencia = new AgenciaLeilao();
                
                Imovel imovel1 = new Imovel(2, "Glória", 30000, true);
                Imovel imovel2 = new Imovel(1, "Vera Cruz", 25000, true);
                Imovel imovel3 = new Imovel(3, "Santa Joana", 32000, true);
                imovel3.setLeilao(LocalDate.of(2023, 3, 24), LocalDate.of(2023, 3, 24));
                Imovel imovel4 = new Imovel(2, "Aradas", 24000, true);
                imovel4.setLeilao(LocalDate.of(2023, 4, 3), LocalDate.of(2023, 4, 3));
                Imovel imovel5 = new Imovel(2, "São Bernardo", 20000, true);
                
                agencia.adicionarImovel(imovel1);
                agencia.adicionarImovel(imovel2);
                agencia.adicionarImovel(imovel3);
                agencia.adicionarImovel(imovel4);
                agencia.adicionarImovel(imovel5);
                
                agencia.venderImovel(1001);
                agencia.venderImovel(1001);
                agencia.venderImovel(1010);
                
                agencia.listarImoveis();
            }
        }
    }