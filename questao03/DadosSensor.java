public class DadosSensor {
    private final double temperatura;
    private final double umidade;
    private final double poluicao;

    public DadosSensor(double temperatura, double umidade, double poluicao) {
        this.temperatura = temperatura;
        this.umidade = umidade;
        this.poluicao = poluicao;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public double getUmidade() {
        return umidade;
    }

    public double getPoluicao() {
        return poluicao;
    }

    @Override
    public String toString() {
        return String.format("Temp: %.1f°C | Umid: %.1f%% | Poluicao: %.1f", temperatura, umidade, poluicao);
    }
}