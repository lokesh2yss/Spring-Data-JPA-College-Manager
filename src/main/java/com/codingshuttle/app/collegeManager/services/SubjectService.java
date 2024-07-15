package com.codingshuttle.app.collegeManager.services;

import com.codingshuttle.app.collegeManager.entities.ProfessorEntity;
import com.codingshuttle.app.collegeManager.entities.StudentEntity;
import com.codingshuttle.app.collegeManager.entities.SubjectEntity;
import com.codingshuttle.app.collegeManager.repositories.ProfessorRepository;
import com.codingshuttle.app.collegeManager.repositories.StudentRepository;
import com.codingshuttle.app.collegeManager.repositories.SubjectRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class SubjectService {
    private final StudentRepository studentRepository;
    private final ProfessorRepository professorRepository;
    private final SubjectRepository subjectRepository;

    public SubjectService(StudentRepository studentRepository, ProfessorRepository professorRepository, SubjectRepository subjectRepository) {
        this.studentRepository = studentRepository;
        this.professorRepository = professorRepository;
        this.subjectRepository = subjectRepository;
    }

    public SubjectEntity getSubjectById(Long subjectId) {
        return subjectRepository.findById(subjectId).orElse(null);
    }

    public SubjectEntity createNewSubject(SubjectEntity subjectEntity) {
        return subjectRepository.save(subjectEntity);
    }

    public SubjectEntity assignProfessorToSubject(Long subjectId, Long professorId) {
        Optional<SubjectEntity> subjectEntity = subjectRepository.findById(subjectId);
        Optional<ProfessorEntity> professorEntity = professorRepository.findById(professorId);

        return subjectEntity
                .flatMap(subject -> professorEntity.map(
                        professor -> {
                            subject.setProfessor(professor);
                            return subjectRepository.save(subject);
                        }
                )).orElse(null);
    }

    public SubjectEntity assignStudentToSubject(Long subjectId, Long studentId) {
        Optional<SubjectEntity> subjectEntity = subjectRepository.findById(subjectId);
        Optional<StudentEntity> studentEntity = studentRepository.findById(studentId);

        return subjectEntity
                .flatMap(subject ->
                        studentEntity.map(student -> {
                            subject.getStudents().add(student);
                            return subjectRepository.save(subject);
                        })).orElse(null);
    }
}
