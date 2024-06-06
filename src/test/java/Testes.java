import br.edu.fesa.teladelogin.comandaData.ComandaDTO;
import br.edu.fesa.teladelogin.comandaData.ComandaModel;
import br.edu.fesa.teladelogin.funcionarioData.FuncionarioDTO;
import br.edu.fesa.teladelogin.funcionarioData.FuncionarioModel;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Testes {
    @Test
    public void test() {
        FuncionarioDTO dto = new FuncionarioDTO();
        List<FuncionarioModel> list = dto.read();

        for (FuncionarioModel f : list) {
            System.out.println(f.getNome());
        }
    }

    @Test
    public void test1() {
        ComandaDTO dto = new ComandaDTO();
        List<ComandaModel> list = dto.read();

        for (ComandaModel c : list)
            System.out.println(c.getProfissional());
    }

    @Test
    public void test2() {
        ComandaDTO dto = new ComandaDTO();
        LocalDateTime agora = LocalDateTime.now();
        dto.create(2, agora, "teste", "teste", "teste", "teste", 2.20d);
    }
}
