public class ModeradoStrategy implements ModeloCalculoRisco {
    @Override
    public double calcularRisco(double scoreBase) {
        double risco = (scoreBase * 1.0) + 5.0;
        return Math.min(risco, 100.0);
    }

    @Override
    public String getNomeModelo() {
        return "Moderado";
    }
}