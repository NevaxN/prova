public class AgressivoStrategy implements ModeloCalculoRisco {
    @Override
    public double calcularRisco(double scoreBase) {
        double risco = (scoreBase * 1.5) + 10.0;
        return Math.min(risco, 100.0);
    }

    @Override
    public String getNomeModelo() {
        return "Agressivo";
    }
}