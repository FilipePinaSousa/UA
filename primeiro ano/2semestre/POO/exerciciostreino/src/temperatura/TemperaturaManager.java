package temperatura;

import java.util.List;

public class TemperaturaManager {

    private List<Temperatura> temperaturas;
    private List<Localidade> localidades;

    public TemperaturaManager(List<Temperatura> temperaturas, List<Localidade> localidades) {
        this.temperaturas = temperaturas;
        this.localidades = localidades;
    }

    public void addTemperatura(Temperatura temperatura) {
        temperaturas.add(temperatura);
    }

    public void addLocalidade(Localidade localidade) {
        localidades.add(localidade);
    }

    public void removeTemperatura(Temperatura temperatura) {
        temperaturas.remove(temperatura);
    }

    public void showAllTemperaturas() {
        for (Temperatura temperatura : temperaturas) {
            System.out.println(temperatura);
        }
    }

    public void showAllLocalidades() {
        for (Localidade localidade : localidades) {
            System.out.println(localidade);
        }
    }

    public double temperaturaMediaLocalidade(Localidade localidade) {
        double soma = 0;
        int count = 0;
        for (Temperatura temperatura : temperaturas) {
            if (temperatura.getLocalidade().equals(localidade)) {
                soma += temperatura.getTemperatura();
                count++;
            }
        }
        return count > 0 ? soma / count : 0;
    }
    public double menorTemperatura(Localidade localidade) {
        double menor = 0;
        for (Temperatura temperatura : temperaturas) {
            if (temperatura.getLocalidade().equals(localidade)) {
                if (temperatura.getTemperatura() < menor) {
                    menor = temperatura.getTemperatura();
                }
            }
        }
        return menor;
    }
    public double maiorTemperatura(Localidade localidade) {
        double maior = 0;
        for (Temperatura temperatura : temperaturas) {
            if (temperatura.getLocalidade().equals(localidade)) {
                if (temperatura.getTemperatura() > maior) {
                    maior = temperatura.getTemperatura();
                }
            }
        }
        return maior;
    }
    public double temperaturaMediaTodasLocalidades() {
        double soma = 0;
        int count = 0;
        for (Temperatura temperatura : temperaturas) {
            soma += temperatura.getTemperatura();
            count++;
        }
        return count > 0 ? soma / count : 0;
    }
    
    public List<Temperatura> getTemperaturas() {
        return temperaturas;
    }

    public List<Localidade> getLocalidades() {
        return localidades;
    }

    public void setTemperaturas(List<Temperatura> temperaturas) {
        this.temperaturas = temperaturas;
    }

    public void setLocalidades(List<Localidade> localidades) {
        this.localidades = localidades;
    }
}
