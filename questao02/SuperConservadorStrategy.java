class SuperConservadorStrategy implements ModeloCalculoRisco {
    @Override
    public double calcularRisco(double scoreBase) {
        double risco = (scoreBase * 0.5) + 1.0;
        return Math.min(risco, 100.0);
    }

    @Override
    public String getNomeModelo() {
        return "Super Conservador";
    }
}