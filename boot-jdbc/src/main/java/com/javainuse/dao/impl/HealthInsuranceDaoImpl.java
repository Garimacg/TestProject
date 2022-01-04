package com.javainuse.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.javainuse.dao.HealthInsuranceDao;
import com.javainuse.model.EmployeeHealthInsurance;

@Repository
public class HealthInsuranceDaoImpl  implements HealthInsuranceDao {

	@Autowired
	JdbcTemplate dataSource;

	/*@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}*/

	@Override
	public void registerEmployeeHealthInsurance(EmployeeHealthInsurance emp) {
		String sql = "INSERT INTO employeeHealthInsurance "
				+ "(empId, healthInsuranceSchemeName, coverageAmount) VALUES (?, ?,?)";
		dataSource.update(sql,
				new Object[] { emp.getEmpId(), emp.getHealthInsuranceSchemeName(), emp.getCoverageAmount() });
	}

	@Override
	public void deleteEmployeeHealthInsuranceById(String empid) {
		String sql = "DELETE FROM employeeHealthInsurance WHERE empId = ?";
		dataSource.update(sql, new Object[] { empid });

	}
}