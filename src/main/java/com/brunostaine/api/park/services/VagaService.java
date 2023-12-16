package com.brunostaine.api.park.services;

import com.brunostaine.api.park.entity.Vaga;
import com.brunostaine.api.park.exceptions.CodigoUniqueViolationException;
import com.brunostaine.api.park.exceptions.EntityNotFoundException;
import com.brunostaine.api.park.repository.VagaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class VagaService {

    private final VagaRepository vagaRepository;
    @Transactional
    public Vaga salvar(Vaga vaga) {
        try {
            return vagaRepository.save(vaga);
        } catch (DataIntegrityViolationException ex) {
            throw new CodigoUniqueViolationException(
                    String.format("Vaga com o código '%s' já cadastrada", vaga.getCodigo()));
        }
    }
    @Transactional(readOnly = true)
    public Vaga buscarPorCodigo(String codigo){
        return vagaRepository.findBycodigo(codigo).orElseThrow(
                () -> new EntityNotFoundException(String.format("Vaga com o código '%s' não foi encontrada", codigo))
        );
    }
}
