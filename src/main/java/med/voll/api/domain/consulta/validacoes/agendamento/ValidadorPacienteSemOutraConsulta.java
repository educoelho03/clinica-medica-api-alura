package med.voll.api.domain.consulta.validacoes.agendamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteSemOutraConsulta implements ValidadorAgendamentoDeConsulta{

    @Autowired
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
