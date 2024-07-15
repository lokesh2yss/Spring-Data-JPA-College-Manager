package com.codingshuttle.app.collegeManager.controllers;

import com.codingshuttle.app.collegeManager.entities.ProfessorEntity;
import com.codingshuttle.app.collegeManager.services.ProfessorService;
import com.codingshuttle.app.collegeManager.services.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/professors")
public class ProfessorController {
    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping(path = "/{professorId}")
    public ProfessorEntity getProfessorById(@PathVariable Long professorId) {
        return professorService.getProfessorById(professorId);
    }

    @PostMapping
    public ProfessorEntity createNewProfessor(@RequestBody ProfessorEntity professorEntity) {
        return professorService.createNewProfessor(professorEntity);
    }

    @PutMapping(path="/{professorId}/students/{studentId}")
    public ProfessorEntity assignStudentToProfessor(@PathVariable Long professorId, @PathVariable Long studentId) {
        return professorService.assignStudentToProfessor(professorId, studentId);
    }
}
