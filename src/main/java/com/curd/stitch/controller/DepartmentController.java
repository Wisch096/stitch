package com.curd.stitch.controller;

import com.curd.stitch.dto.DepartmentSummaryDTO;
import com.curd.stitch.repository.PersonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final PersonRepository personRepository;

    public DepartmentController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    public List<DepartmentSummaryDTO> getDepartmentSummaries() {
        return personRepository.getDepartmentSummaries();
    }
}
