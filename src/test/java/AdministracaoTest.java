import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdministracaoTest {

    @Test
    void deveRetornarSempreAMesmaInstancia() {
        assertSame(Administracao.getInstancia(), Administracao.getInstancia());
    }

    @Test
    void deveEncaminharParaPortaria() {
        assertEquals("A Administração recebeu sua mensagem.\n" +
                        "Ela foi encaminhada para a Portaria.\n" +
                        ">>Portaria: recebemos sua solicitação 'Liberar entrada de visita' e vamos atender.",
                Administracao.getInstancia().encaminharParaPortaria("Liberar entrada de visita"));
    }

    @Test
    void deveEncaminharParaManutencao() {
        assertEquals("A Administração recebeu sua mensagem.\n" +
                        "Ela foi encaminhada para a Manutenção.\n" +
                        ">>Manutenção: chamado 'Lâmpada queimada no corredor' aberto, um técnico será enviado.",
                Administracao.getInstancia().encaminharParaManutencao("Lâmpada queimada no corredor"));
    }

    // ---------- Casos de erro ----------

    @Test
    void deveLancarExcecaoAoEncaminharMensagemNulaParaPortaria() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> Administracao.getInstancia().encaminharParaPortaria(null));
        assertEquals("Mensagem não pode ser vazia", e.getMessage());
    }

    @Test
    void deveLancarExcecaoAoEncaminharMensagemVaziaParaPortaria() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> Administracao.getInstancia().encaminharParaPortaria(""));
        assertEquals("Mensagem não pode ser vazia", e.getMessage());
    }

    @Test
    void deveLancarExcecaoAoEncaminharMensagemNulaParaManutencao() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> Administracao.getInstancia().encaminharParaManutencao(null));
        assertEquals("Mensagem não pode ser vazia", e.getMessage());
    }

    @Test
    void deveLancarExcecaoAoEncaminharMensagemSoComEspacosParaManutencao() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> Administracao.getInstancia().encaminharParaManutencao("   "));
        assertEquals("Mensagem não pode ser vazia", e.getMessage());
    }
}