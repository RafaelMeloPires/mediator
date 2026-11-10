public class Morador extends Pessoa {

    private String apartamento;

    public Morador(String nome, String apartamento) {
        super(nome);
        setApartamento(apartamento);
    }

    public String getApartamento() {
        return apartamento;
    }

    public void setApartamento(String apartamento) {
        if (apartamento == null || apartamento.trim().isEmpty()) {
            throw new IllegalArgumentException("Apartamento inválido");
        }
        this.apartamento = apartamento;
    }

    public String solicitarPortaria(String mensagem) {
        return Administracao.getInstancia().encaminharParaPortaria(mensagem);
    }

    public String solicitarManutencao(String mensagem) {
        return Administracao.getInstancia().encaminharParaManutencao(mensagem);
    }
}