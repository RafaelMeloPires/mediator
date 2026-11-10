public class Manutencao implements Setor {

    private static Manutencao instancia = new Manutencao();

    private Manutencao() {}

    public static Manutencao getInstancia() {
        return instancia;
    }

    @Override
    public String receberMensagem(String mensagem) {
        return "Manutenção: chamado '" + mensagem + "' aberto, um técnico será enviado.";
    }
}