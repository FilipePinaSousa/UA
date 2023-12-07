package aula03;

public class Ex04 {

    
        public static void main(String[] args) {

            double[][] pauta = new double[16][3];

            System.out.printf("%10s %10s %10s\n", "NotaT", "NotaP", "Pauta");

            for (double[] n : pauta) {
                n[0] = randomNota();
                n[1] = randomNota();

                if (n[0] < 7 || n[1] < 7) {
                    n[2] = 66;
                } else {
                    n[2] = (0.4 * n[0]) + (0.6 * n[1]);
                }

                System.out.printf("%10.1f %10.1f %10.0f\n", n[0], n[1], n[2]);
            }
        }

        public static double randomNota() {
            double random, numero;

            random = (Math.random() * 21);
            numero = (double) (Math.round(random * 10)) / 10;

            return numero;
        }
    

}
