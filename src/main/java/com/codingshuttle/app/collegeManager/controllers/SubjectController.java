package com.codingshuttle.app.collegeManager.controllers;

import com.codingshuttle.app.collegeManager.entities.SubjectEntity;
import com.codingshuttle.app.collegeManager.services.SubjectService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/subjects")
public class SubjectController {
    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping(path = "/{subjectId}")
    public SubjectEntity getSubjectById(@PathVariable Long subjectId) {
        return subjectService.getSubjectById(subjectId);
    }

    @PostMapping
    public SubjectEntity createNewSubject(@RequestBody SubjectEntity subjectEntity) {
        return subjectService.createNewSubject(subjectEntity);
    }

    @PutMapping(path="/{subjectId}/professor/{professorId}")
    public SubjectEntity assignProfessorToSubject(@PathVariable Long subjectId, @PathVariable Long professorId)  {
        return subjectService.assignProfessorToSubject(subjectId, professorId);
    }

    @PutMapping(path="/{subjectId}/students/{studentId}")
    public SubjectEntity assignStudentToSubject(@PathVariable Long subjectId, @PathVariable Long studentId)  {
        return subjectService.assignStudentToSubject(subjectId, studentId);
    }
}
