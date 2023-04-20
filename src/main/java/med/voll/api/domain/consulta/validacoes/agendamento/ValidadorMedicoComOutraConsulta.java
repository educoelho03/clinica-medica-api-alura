package med.voll.api.domain.consulta.validacoes.agendamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoComOutraConsulta implements ValidadorAgendamentoDeConsulta{

    @Autowired
    private MedicoRepository medicoRepository;

    public void validar(DadosAgendamentoConsulta dados){
        var MedicoComOutraConsultaNoMesmoHorario = medicoRepository.existsByMedicoIdAndData(dados.idMedico(), dados.data());
        if(MedicoComOutraConsultaNoMesmoHorario){
            throw new ValidacaoException("Medico ja possui uma consulta agendada nesse horario");
        }
    }
}
