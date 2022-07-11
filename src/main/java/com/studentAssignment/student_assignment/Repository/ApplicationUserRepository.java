package com.studentAssignment.student_assignment.Repository;

import com.studentAssignment.student_assignment.Entity.ApplicationUSerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUSerEntity, Long> {

    Optional<ApplicationUSerEntity> findByEmail(String email);

}
