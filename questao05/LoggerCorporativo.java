public class LoggerCorporativo {
    
    private static volatile LoggerCorporativo instancia;

    private static int contadorInstancias = 0; 
    
    private LoggerCorporativo() {
        contadorInstancias++;
        System.out.println("--- 🆕 LoggerCorporativo: INSTÂNCIA CRIADA # " + contadorInstancias + " ---");
        System.out.println("   [Init] Conectando ao servidor de monitoramento externo...");
        System.out.println("   [Init] Abrindo arquivo de log...");
    }

    public static LoggerCorporativo getInstancia() {
        if (instancia == null) {
            synchronized (LoggerCorporativo.class) {
                if (instancia == null) {
                    instancia = new LoggerCorporativo();
                }
            }
        }
        return instancia;
    }
    
    public void registrarLog(String tipo, String mensagem) {
        String log = String.format("[%s] [%s] %s", java.time.LocalTime.now(), tipo, mensagem);
        
        System.out.println("   [LOG] Registrando: " + log);
    }

    public void registrarErro(String mensagem) {
        registrarLog("ERRO", mensagem);
    }
    
    public void registrarEvento(String mensagem) {
        registrarLog("EVENTO", mensagem);
    }
}