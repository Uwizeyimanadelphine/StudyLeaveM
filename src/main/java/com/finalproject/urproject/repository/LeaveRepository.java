package com.finalproject.urproject.repository;

import com.finalproject.urproject.entity.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveRepository extends JpaRepository<Leave, Long> {
    @Query("SELECT p FROM Leave p WHERE CONCAT(p.id, p.institution, p.educationLevel,p.country) LIKE %?1%")
    public List<Leave> search(String keyword);
    //List<Leave> findByCreatedAtBetween(Date dateLeave, Date dateCome);

    @Query(value = "SELECT * FROM `leave`", nativeQuery = true)
    List<Leave> totaldays();


    @Query(value = "SELECT `id`, `country`, `date_come`, `date_leave`, `education_level`, `institution`, `employee_emp_id`, `total_date`,DATEDIFF(`date_come`,`date_leave`) as difference FROM `leave` WHERE 1", nativeQuery = true)
    public List<Leave> getMyLeaves();


    /*SELECT

      <td>[[${leave.datediff}]]</td>-->
     country,
     DATEDIFF(date_leave, date_come) daysDiff
 FROM
     `leave`
 ORDER BY daysDiff DESC;SELECT * FROM `leave` WHERE 1;




 */
}
