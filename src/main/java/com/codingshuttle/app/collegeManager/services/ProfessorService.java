package com.codingshuttle.app.collegeManager.services;

import com.codingshuttle.app.collegeManager.entities.ProfessorEntity;
import com.codingshuttle.app.collegeManager.entities.StudentEntity;
import com.codingshuttle.app.collegeManager.repositories.AdmissionRecordRepository;
import com.codingshuttle.app.collegeManager.repositories.ProfessorRepository;
import com.codingshuttle.app.collegeManager.repositories.StudentRepository;
import com.codingshuttle.app.collegeManager.repositories.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfessorService {
    private final StudentRepository studentRepository;
    private final ProfessorRepository professorRepository;
    private final SubjectRepository subjectRepository;

    public ProfessorService(StudentRepository studentRepository, ProfessorRepository professorRepository, SubjectRepository subjectRepository) {
        this.studentRepository = studentRepository;
        this.professorRepository = professorRepository;
        this.subjectRepository = subjectRepository;
    }

    public ProfessorEntity getProfessorById(Long professorId) {
        return professorRepository.findById(professorId).orElse(null);
    }

    public ProfessorEntity createNewProfessor(ProfessorEntity professorEntity) {
        return professorRepository.save(professorEntity);
    }

    public ProfessorEntity assignStudentToProfessor(Long professorId, Long studentId) {
        Optional<ProfessorEntity> professorEntity = professorRepository.findById(professorId);
        Optional<StudentEntity> studentEntity = studentRepository.findById(studentId);

        return professorEntity
                .flatMap(professor ->
                        studentEntity.map(student -> {
                            professor.getStudents().add(student);
                            return professorRepository.save(professor);

        })).orElse(null);
    }
}
