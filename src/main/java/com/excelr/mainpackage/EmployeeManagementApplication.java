package com.excelr.mainpackage;

import com.excelr.mainpackage.model.Employee;
import com.excelr.mainpackage.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
public class EmployeeManagementApplication implements CommandLineRunner  {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
//		Employee e4=new Employee();
//		e4.setFirstName("Susan");
//		e4.setLastName("S");
//		e4.setDepartment("IT");
//		e4.setEmailId("susan@gmail.com");
//		e4.setAddress("Mumbai");
//		e4.setSalary(32000);
//		e4.setPhoneNumber("9535287278");
//		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//		Date dateOfJoining = dateFormat.parse("01/18/2022");
//		e4.setDateOfJoining(dateOfJoining);
//		employeeRepository.save(e4);

	}
	private static Date setToMidnight(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
}
