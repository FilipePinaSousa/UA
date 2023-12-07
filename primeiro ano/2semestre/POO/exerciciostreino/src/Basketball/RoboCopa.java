package Basketball;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class RoboCopa {
    public static void main(String[] args) {
        RoboCopa exam = new RoboCopa();
        //exam.parte1();
        exam.parte2();
    }

    private void parte1() {
        Bola bola = new Bola(CorDaBola.Amarela);
        showOMStatus(bola);

        Equipa e1 = new Equipa("BeiraMar", "JJ");
        Robo r[] = {
                new Robo("Ron", TipoJogador.Alas, 5, 0),
                new Robo("Mes", TipoJogador.Pivô, 2, 40),
                new Robo("Pau", TipoJogador.Alas, 7, 10),
                new Robo("Ema", TipoJogador.Pivô, 5, 25),
                new Robo("Tim", TipoJogador.Armador, 1, 20)
        };
        for (ObjetoMovel o : r)
            showOMStatus(o);

        e1.add(r[0]);
        e1.add(r[1]);
        e1.add(r[2]);
        e1.add(r[1]);
        e1.add(r[3]);
        e1.add(r[4]);
        e1.remove(r[3]);
        System.out.print("-- " + e1);

        Equipa e2 = new Equipa("PortoDAveiro", "Lopes");
        e2.add(new Robo("Liu", TipoJogador.Alas, 5, 80));
        e2.add(new Robo("Min", TipoJogador.Pivô, 3, 10));
        e2.add(new Robo("Hus", TipoJogador.Alas, 6, 70));
        e2.add(new Robo("Taw", TipoJogador.Pivô, 5, 65));
        e2.add(new Robo("Taw", TipoJogador.Armador, 5, 65));
        System.out.print("-- " + e2);

        if (Bola.getnBolas() == 0) {
            bola = new Bola(CorDaBola.Azul);
        } else {
            System.out.println("Já temos bola!");
        }

        Jogo tacoataco = new Jogo(e1, e2, bola, 20);
        System.out.println("--- " + tacoataco);

        // simulação simples de movimentos e golos de uma equipa
        Robo[] r2 = e2.getRobos();
        r2[1].marcaCesto();
        r2[1].move(40, 40);
        r2[1].move(60, 40);
        r2[1].move(70, 40);
        r2[1].marcaCesto();
        r2[2].move(55, 55, 20);
        r2[3].move(40, 20);
        r2[3].move(60, 20);
        r2[3].move(70, 20);
        r2[3].marcaCesto();
        for (Robo rob : r)
            showRoboStatus(rob);

        System.out.println("Score: " + e1.getCestosMarcados() + " - " + e2.getCestosMarcados());
    }

    private void showOMStatus(ObjetoMovel om) {
        System.out.printf("OM: %3d %3d %3d %5.1f\n", om.getX(), om.getY(), om.getVelocidade(), om.getDistancia());
    }

    private void showRoboStatus(Robo rob) {
        System.out.printf("%-10s %-15s %3d %3d %3d %5.1f %3d\n", rob.getId(), rob.getTipo(),
                rob.getX(), rob.getY(), rob.getVelocidade(), rob.getDistancia(), rob.getCestos());
    }

    private void parte2() {
        Comparator<Equipa> alfabeticamente = new Comparator<Equipa>() {
            @Override
            public int compare(Equipa o1, Equipa o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        };

        Scanner sfc = null;
        File input = new File("robos.txt");
        String linha;
        List<Robo> listagemRobos = new LinkedList<>();
        Set<Equipa> listaEquipas = new TreeSet<>(alfabeticamente);
        Set<String> nomes = new HashSet<>();
        String nomeEquipa;
        try {
            sfc = new Scanner(input);
            while (sfc.hasNext()) {
                linha = sfc.nextLine();
                String[] array = linha.split("\t"); //robo, equipa,posição robo

                if (!array[0].equals("Jogador")) {
                    String t = array[2];
                    TipoJogador tipo = TipoJogador.Pivô;
                    switch (t.trim()) {
                        case ("Alas"):
                            tipo = TipoJogador.Alas;
                            break;
                        case ("Armador"):
                            tipo = TipoJogador.Armador;
                            break;
                    }
                    Robo r = new Robo(array[0], tipo);
                    listagemRobos.add(r);
                    nomeEquipa = array[1];

                    if (nomes.contains(nomeEquipa)) {
                        for (Equipa e : listaEquipas) {
                            if (e.getNome().equals(nomeEquipa))
                                e.add(r);

                        }
                    } else {
                        Equipa e = new Equipa(nomeEquipa, "unknown");
                        e.add(r);
                        listaEquipas.add(e);
                        nomes.add(nomeEquipa);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Erro devido à exceção: " + e);
        }
        System.out.println("Lista de Equipas (" + listaEquipas.size() + " equipas)");
        for (Equipa e : listaEquipas)
            System.out.println(e);
        System.out.println("Lista de Robos (" + listagemRobos.size() + " robos)");
        System.out.println(listagemRobos);
    }
}
