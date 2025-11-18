public class CriadorRelatorioSemanal extends CriadorRelatorio {
    @Override
    protected Relatorio criarRelatorio() {
        return new RelatorioSemanal();
    }
}