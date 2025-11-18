public class CriadorRelatorioDiario extends CriadorRelatorio {
    @Override
    protected Relatorio criarRelatorio() {
        return new RelatorioDiario();
    }
}