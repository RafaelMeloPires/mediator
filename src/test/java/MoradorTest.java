import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoradorTest {

    @Test
    void deveCriarMorador() {
        Morador morador = new Morador("Rafael", "101");

        assertEquals("Rafael", morador.getNome());
        assertEquals("101", morador.getApartamento());
    }

    @Test
    void deveAlterarNome() {
        Morador morador = new Morador("Rafael", "101");
        morador.setNome("Ana");

        assertEquals("Ana", morador.getNome());
    }

    @Test
    void deveAlterarApartamento() {
        Morador morador = new Morador("Rafael", "101");
        morador.setApartamento("202");

        assertEquals("202", morador.getApartamento());
    }

    @Test
    void deveSerUmaPessoa() {
        Morador morador = new Morador("Rafael", "101");

        assertTrue(morador instanceof Pessoa);
    }

    @Test
    void deveEncaminharSolicitacaoParaPortaria() {
        Morador morador = new Morador("Rafael", "101");

        assertEquals("A Administração recebeu sua mensagem.\n" +
                        "Ela foi encaminhada para a Portaria.\n" +
                        ">>Portaria: recebemos sua solicitação 'Liberar entrada de visita' e vamos atender.",
                morador.solicitarPortaria("Liberar entrada de visita"));
    }

    @Test
    void deveEncaminharSolicitacaoParaManutencao() {
        Morador morador = new Morador("Rafael", "101");

        assertEquals("A Administração recebeu sua mensagem.\n" +
                        "Ela foi encaminhada para a Manutenção.\n" +
                        ">>Manutenção: chamado 'Lâmpada queimada no corredor' aberto, um técnico será enviado.",
                morador.solicitarManutencao("Lâmpada queimada no corredor"));
    }

    // ---------- Casos de erro ----------

    @Test
    void deveLancarExcecaoAoCriarMoradorComNomeNulo() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new Morador(null, "101"));
        assertEquals("Nome inválido", e.getMessage());
    }

    @Test
    void deveLancarExcecaoAoCriarMoradorComNomeVazio() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new Morador("", "101"));
        assertEquals("Nome inválido", e.getMessage());
    }

    @Test
    void deveLancarExcecaoAoCriarMoradorComApartamentoNulo() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new Morador("Rafael", null));
        assertEquals("Apartamento inválido", e.getMessage());
    }

    @Test
    void deveLancarExcecaoAoCriarMoradorComApartamentoVazio() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new Morador("Rafael", "  "));
        assertEquals("Apartamento inválido", e.getMessage());
    }

    @Test
    void deveLancarExcecaoAoAlterarNomeParaVazio() {
        Morador morador = new Morador("Rafael", "101");

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> morador.setNome(""));
        assertEquals("Nome inválido", e.getMessage());
        assertEquals("Rafael", morador.getNome());
    }

    @Test
    void deveLancarExcecaoAoAlterarApartamentoParaNulo() {
        Morador morador = new Morador("Rafael", "101");

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> morador.setApartamento(null));
        assertEquals("Apartamento inválido", e.getMessage());
        assertEquals("101", morador.getApartamento());
    }

    @Test
    void deveLancarExcecaoAoSolicitarPortariaComMensagemVazia() {
        Morador morador = new Morador("Rafael", "101");

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> morador.solicitarPortaria(""));
        assertEquals("Mensagem não pode ser vazia", e.getMessage());
    }

    @Test
    void deveLancarExcecaoAoSolicitarManutencaoComMensagemNula() {
        Morador morador = new Morador("Rafael", "101");

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> morador.solicitarManutencao(null));
        assertEquals("Mensagem não pode ser vazia", e.getMessage());
    }
}