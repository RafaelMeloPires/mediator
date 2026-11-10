public class Administracao {

    private static Administracao instancia = new Administracao();

    private Administracao() {}

    public static Administracao getInstancia() {
        return instancia;
    }

    public String encaminharParaPortaria(String mensagem) {
        validarMensagem(mensagem);
        return "A Administração recebeu sua mensagem.\n" +
                "Ela foi encaminhada para a Portaria.\n" +
                ">>" + Portaria.getInstancia().receberMensagem(mensagem);
    }

    public String encaminharParaManutencao(String mensagem) {
        validarMensagem(mensagem);
        return "A Administração recebeu sua mensagem.\n" +
                "Ela foi encaminhada para a Manutenção.\n" +
                ">>" + Manutencao.getInstancia().receberMensagem(mensagem);
    }

    private void validarMensagem(String mensagem) {
        if (mensagem == null || mensagem.trim().isEmpty()) {
            throw new IllegalArgumentException("Mensagem não pode ser vazia");
        }
    }
}