public class Portaria implements Setor {

    private static Portaria instancia = new Portaria();

    private Portaria() {}

    public static Portaria getInstancia() {
        return instancia;
    }

    @Override
    public String receberMensagem(String mensagem) {
        return "Portaria: recebemos sua solicitação '" + mensagem + "' e vamos atender.";
    }
}