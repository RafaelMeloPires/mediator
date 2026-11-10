import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PortariaTest {

    @Test
    void deveRetornarSempreAMesmaInstancia() {
        assertSame(Portaria.getInstancia(), Portaria.getInstancia());
    }

    @Test
    void deveSerUmSetor() {
        assertTrue(Portaria.getInstancia() instanceof Setor);
    }

    @Test
    void deveReceberMensagem() {
        assertEquals("Portaria: recebemos sua solicitação 'Liberar entrada de visita' e vamos atender.",
                Portaria.getInstancia().receberMensagem("Liberar entrada de visita"));
    }
}