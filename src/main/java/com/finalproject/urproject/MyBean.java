package com.finalproject.urproject;

import com.finalproject.urproject.repository.DepartmentRepository;
import com.finalproject.urproject.repository.EmployeeRepository;
import com.finalproject.urproject.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component("test")
public class MyBean {
    @Autowired
    private EmployeeRepository repo;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private LeaveRepository leaveRepository;

    public String getMessage(String dateBefore, String dateAfter) {
        Date date1 = null;
        Date date2 = null;
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
        try {
            date1 = sdf.parse(dateBefore);
            date2 = sdf.parse(dateAfter);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long time_difference = date2.getTime() - date1.getTime();
        long days_difference = (time_difference / (1000 * 60 * 60 * 24)) % 365;

        return "" + days_difference;

    }

    public String display(String dateBefore) {
        //Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(message);
        Date date1 = null;
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
        try {
            date1 = sdf.parse(dateBefore);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        long time_difference = date1.getTime() - date.getTime();
        long days = (time_difference / (1000 * 60 * 60 * 24)) % 365;

        return "" + days;
    }

    public String empRows() {
        long count = repo.count();
        return "" + count;
    }

    public String depRows() {
        long count = departmentRepository.count();
        return "" + count;
    }

    public String leaveRows() {
        long count = leaveRepository.count();
        return "" + count;
    }

}
