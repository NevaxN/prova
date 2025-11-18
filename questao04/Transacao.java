public class Transacao {
    private final String id;
    private final double valor;
    private final String geolocalizacao;
    private final boolean historicoLimpo;
    private final String dispositivoAtual;
    
    private boolean aprovada = true; 
    private String motivoFalha = "Aprovada";

    public Transacao(String id, double valor, String geolocalizacao, boolean historicoLimpo, String dispositivoAtual) {
        this.id = id;
        this.valor = valor;
        this.geolocalizacao = geolocalizacao;
        this.historicoLimpo = historicoLimpo;
        this.dispositivoAtual = dispositivoAtual;
    }

    public double getValor() { 
        return valor; 
    }
    
    public String getGeolocalizacao() { 
        return geolocalizacao; 
    }

    public boolean isHistoricoLimpo() { 
        return historicoLimpo; 
    }

    public String getDispositivoAtual() { 
        return dispositivoAtual; 
    }
    
    public boolean isAprovada() { 
        return aprovada; 
    }
    
    public String getId() { 
        return id; 
    }
    
    public String getMotivoFalha() { 
        return motivoFalha; 
    }

    public void setFalha(String motivo) {
        this.aprovada = false;
        this.motivoFalha = motivo;
    }
}