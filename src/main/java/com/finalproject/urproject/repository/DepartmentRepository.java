package com.finalproject.urproject.repository;

import com.finalproject.urproject.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Query("SELECT p FROM Department p WHERE CONCAT(p.id, p.school, p.departmentName, p.hod) LIKE %?1%")
    public List<Department> search(String keyword);


}
