public class ConservadorStrategy implements ModeloCalculoRisco {
    @Override
    public double calcularRisco(double scoreBase) {
        double risco = (scoreBase * 0.7) + 2.0;
        return Math.min(risco, 100.0);
    }

    @Override
    public String getNomeModelo() {
        return "Conservador";
    }
}