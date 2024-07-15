package com.codingshuttle.app.collegeManager.controllers;

import com.codingshuttle.app.collegeManager.entities.AdmissionRecordEntity;
import com.codingshuttle.app.collegeManager.services.AdmissionRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="admission-records")
public class AdmissionRecordController {
    private final AdmissionRecordService admissionRecordService;

    public AdmissionRecordController(AdmissionRecordService admissionRecordService) {
        this.admissionRecordService = admissionRecordService;
    }

    @GetMapping(path = "/{admissionRecordId}")
    public AdmissionRecordEntity getAdmissionRecordById(@PathVariable Long admissionRecordId) {
        return admissionRecordService.getAdmissionRecordById(admissionRecordId);
    }

    @PostMapping
    public AdmissionRecordEntity createNewAdmissionRecord(@RequestBody AdmissionRecordEntity admissionRecordEntity) {
        return admissionRecordService.createNewAdmissionRecord(admissionRecordEntity);
    }
}
