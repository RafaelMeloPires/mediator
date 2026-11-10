import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManutencaoTest {

    @Test
    void deveRetornarSempreAMesmaInstancia() {
        assertSame(Manutencao.getInstancia(), Manutencao.getInstancia());
    }

    @Test
    void deveSerUmSetor() {
        assertTrue(Manutencao.getInstancia() instanceof Setor);
    }

    @Test
    void deveReceberMensagem() {
        assertEquals("Manutenção: chamado 'Lâmpada queimada no corredor' aberto, um técnico será enviado.",
                Manutencao.getInstancia().receberMensagem("Lâmpada queimada no corredor"));
    }
}