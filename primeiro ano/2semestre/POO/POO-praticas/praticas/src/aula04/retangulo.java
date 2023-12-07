package aula04;

public class retangulo {
        private double comprimento;
        private double altura;

        public retangulo(double comprimento, double altura) {
            if (comprimento <= 0 || altura <= 0)
                throw new IllegalArgumentException("Comprimento e altura devem ser valores positivos");
            this.comprimento = comprimento;
            this.altura = altura;
        }

        public double getComprimento() {
            return comprimento;
        }

        public void setComprimento(double comprimento) {
            if (comprimento <= 0)
                throw new IllegalArgumentException("Comprimento deve ser um valor positivo");
            this.comprimento = comprimento;
        }

        public double getAltura() {
            return altura;
        }

        public void setAltura(double altura) {
            if (altura <= 0)
                throw new IllegalArgumentException("Altura deve ser um valor positivo");
            this.altura = altura;
        }

        public double calcularArea() {
            return comprimento * altura;
        }

        public double calcularPerimetro() {
            return 2 * (comprimento + altura);
        }

        public String toString() {
            return "Retangulo de comprimento " + comprimento + " e altura " + altura;
        }

        public boolean equals(Object obj) {
            if (obj instanceof retangulo) {
                retangulo retangulo = (retangulo) obj;
                return this.comprimento == retangulo.comprimento && this.altura == retangulo.altura;
            }
            return false;
        }
}
