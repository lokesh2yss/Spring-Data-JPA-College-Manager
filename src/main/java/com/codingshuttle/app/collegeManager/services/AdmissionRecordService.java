package com.codingshuttle.app.collegeManager.services;

import com.codingshuttle.app.collegeManager.entities.AdmissionRecordEntity;
import com.codingshuttle.app.collegeManager.repositories.AdmissionRecordRepository;
import com.codingshuttle.app.collegeManager.repositories.ProfessorRepository;
import com.codingshuttle.app.collegeManager.repositories.StudentRepository;
import com.codingshuttle.app.collegeManager.repositories.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdmissionRecordService {
    private final StudentRepository studentRepository;
    private final AdmissionRecordRepository admissionRecordRepository;

    public AdmissionRecordService(StudentRepository studentRepository, AdmissionRecordRepository admissionRecordRepository) {
        this.studentRepository = studentRepository;
        this.admissionRecordRepository = admissionRecordRepository;
    }

    public AdmissionRecordEntity getAdmissionRecordById(Long admissionRecordId) {
        return admissionRecordRepository.findById(admissionRecordId).orElse(null);
    }
    public AdmissionRecordEntity createNewAdmissionRecord(AdmissionRecordEntity admissionRecordEntity) {
        return admissionRecordRepository.save(admissionRecordEntity);
    }


}
