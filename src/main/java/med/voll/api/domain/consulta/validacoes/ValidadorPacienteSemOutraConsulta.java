package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.paciente.PacienteRepository;

public class ValidadorPacienteSemOutraConsulta {


    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
    var primeiroHorario = dados.data().withHour(7);
    var ultimoHorario = dados.data().withHour(18);
    var PacienteComOutraConsulta = repository.existsByPacienteIdAndDataBetween(dados.idPaciente(), primeiroHorario, ultimoHorario);

    if(PacienteComOutraConsulta){
        throw new ValidacaoException("O paciente ja tem uma consulta marcada para esse dia");

    }

    }
}
