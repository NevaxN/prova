import java.util.ArrayList;
import java.util.List;

public class Sensor {
    private final List<Observador> observadores = new ArrayList<>();
    private DadosSensor dadosAtuais;

    public void inscrever(Observador observador) {
        if (!observadores.contains(observador)) {
            observadores.add(observador);
            System.out.println("   [Sistema] Novo observador inscrito: " + observador.getClass().getSimpleName());
        }
    }

    public void desinscrever(Observador observador) {
        observadores.remove(observador);
        System.out.println("   [Sistema] Observador desinscrito: " + observador.getClass().getSimpleName());
    }

    private void notificarObservadores() {
        for (Observador observador : observadores) {
            observador.atualizar(dadosAtuais);
        }
    }

    public void setDados(double temperatura, double umidade, double poluicao) {
        System.out.println("\n*** Sensor: Novos dados recebidos! ***");
        this.dadosAtuais = new DadosSensor(temperatura, umidade, poluicao);
        System.out.println("   -> " + dadosAtuais.toString());
        notificarObservadores();
    }
}