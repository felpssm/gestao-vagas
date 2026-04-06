package com.felpssdev.gestao_vagas.modules.candidate.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felpssdev.gestao_vagas.exceptions.JobNotFoundException;
import com.felpssdev.gestao_vagas.exceptions.UserNotFoundException;
import com.felpssdev.gestao_vagas.modules.candidate.CandidateRepository;
import com.felpssdev.gestao_vagas.modules.candidate.entity.ApplyJobEntity;
import com.felpssdev.gestao_vagas.modules.company.repositories.JobRepository;
import com.felpssdev.gestao_vagas.modules.candidate.repository.ApplyJobRepository;

@Service
public class ApplyJobCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplyJobRepository applyJobRepository;

    public ApplyJobEntity execute(UUID idCandidate, UUID idJob) {
        this.candidateRepository.findById(idCandidate)
                .orElseThrow(UserNotFoundException::new);

        // validar se a vaga existe
        this.jobRepository.findById(idJob)
                .orElseThrow(JobNotFoundException::new);

        // candidato inscrever na vaga
        var applyJob = ApplyJobEntity.builder()
                .candidateId(idCandidate)
                .jobId(idJob).build();

        applyJob = applyJobRepository.save(applyJob);
        return applyJob;
    }

}
