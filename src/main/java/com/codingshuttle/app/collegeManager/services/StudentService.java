package com.codingshuttle.app.collegeManager.services;

import com.codingshuttle.app.collegeManager.entities.AdmissionRecordEntity;
import com.codingshuttle.app.collegeManager.entities.StudentEntity;
import com.codingshuttle.app.collegeManager.repositories.AdmissionRecordRepository;
import com.codingshuttle.app.collegeManager.repositories.ProfessorRepository;
import com.codingshuttle.app.collegeManager.repositories.StudentRepository;
import com.codingshuttle.app.collegeManager.repositories.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final ProfessorRepository professorRepository;
    private final SubjectRepository subjectRepository;

    private final AdmissionRecordRepository admissionRecordRepository;

    public StudentService(StudentRepository studentRepository, ProfessorRepository professorRepository, SubjectRepository subjectRepository, AdmissionRecordRepository admissionRecordRepository) {
        this.studentRepository = studentRepository;
        this.professorRepository = professorRepository;
        this.subjectRepository = subjectRepository;
        this.admissionRecordRepository = admissionRecordRepository;
    }

    public StudentEntity getStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    public StudentEntity createNewStudent(StudentEntity studentEntity) {
        return studentRepository.save(studentEntity);
    }

    public StudentEntity assignAdmissionRecordToStudent(Long studentId, Long admissionRecordId) {
        Optional<StudentEntity> studentEntity = studentRepository.findById(studentId);
        Optional<AdmissionRecordEntity> admissionRecordEntity = admissionRecordRepository.findById(admissionRecordId);

        return studentEntity.flatMap(
                student -> admissionRecordEntity.map(
                        admissionRecord -> {
                            student.setAdmissionRecord(admissionRecord);
                            return studentRepository.save(student);
                        }
                )
        ).orElse(null);
    }
}
