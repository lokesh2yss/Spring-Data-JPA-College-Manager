package com.codingshuttle.app.collegeManager.repositories;

import com.codingshuttle.app.collegeManager.entities.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {
}
