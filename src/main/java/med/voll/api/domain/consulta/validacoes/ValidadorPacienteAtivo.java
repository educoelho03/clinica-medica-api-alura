package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.paciente.PacienteRepository;

public class ValidadorPacienteAtivo {

    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        if(dados.idPaciente() == null){
            return;
        }

        var pacienteEstaAtivo = repository.findAtivoById(dados.idPaciente());

        if(!pacienteEstaAtivo){
            throw new ValidacaoException("Paciente nao esta mais ativo");
        }
    }
}
