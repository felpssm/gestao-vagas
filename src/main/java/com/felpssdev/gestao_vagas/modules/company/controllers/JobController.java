package com.felpssdev.gestao_vagas.modules.company.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felpssdev.gestao_vagas.modules.company.entities.JobEntity;

import jakarta.validation.Valid;

@RestController
@RequestMapping("job")
public class JobController {

    public void create(@Valid @RequestBody JobEntity jobEntity) {

    }
}
