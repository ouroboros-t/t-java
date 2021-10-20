package com.techelevator.projects.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.techelevator.projects.model.Department;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Employee;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcEmployeeDao implements EmployeeDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcEmployeeDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		String sql = "SELECT employee_id, department_id,  first_name, last_name, birth_date, hire_date " +
				" FROM employee;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while(results.next()) {
			employees.add(mapRowToEmployee(results));

		}

	return employees;
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		List<Employee> employees = new ArrayList<Employee>();
		//ILIKE
		String sql = "SELECT employee_id, department_id,  first_name, last_name, birth_date, hire_date " +
				" FROM employee " +
				"WHERE first_name ILIKE ? AND last_name ILIKE ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, "%" + firstNameSearch + "%" , "%" + lastNameSearch + "%");
		while(results.next()){
			employees.add(mapRowToEmployee(results));

		}
		return employees;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(Long projectId) {
		List<Employee> employeesByProject = new ArrayList<Employee>();
		String sql = "SELECT employee.employee_id, department_id,  first_name, last_name, birth_date, hire_date " +
					"FROM employee JOIN project_employee AS pe ON employee.employee_id = pe.employee_id " +
					"WHERE project_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);

		while(results.next()){
			employeesByProject.add(mapRowToEmployee(results));
		}
		return employeesByProject;

	}

	@Override
	public void addEmployeeToProject(Long projectId, Long employeeId) {
		String sql = "INSERT INTO project_employee(project_id, employee_id) VALUES(?,?);";

		jdbcTemplate.update(sql, projectId, employeeId);
	}

	@Override
	public void removeEmployeeFromProject(Long projectId, Long employeeId) {
		String sql = "DELETE FROM project_employee AS pe WHERE pe.employee_id = ? AND pe.project_id = ?;";
		jdbcTemplate.update(sql, employeeId, projectId);

	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		List<Employee> employeesWithoutProjects = new ArrayList<Employee>();
		String sql = "SELECT employee.employee_id, department_id,  first_name, last_name, birth_date, hire_date " +
				"FROM employee LEFT JOIN project_employee AS pe ON employee.employee_id = pe.employee_id WHERE pe.project_id IS NULL;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

		while(results.next()){
			employeesWithoutProjects.add(mapRowToEmployee(results));
		}
		return employeesWithoutProjects;
	}

	private Employee mapRowToEmployee(SqlRowSet rowSet){
		Employee employee = new Employee();
		employee.setId(rowSet.getLong("employee_id"));
		employee.setDepartmentId(rowSet.getLong("department_id"));
		if(rowSet.wasNull()){
			employee.setDepartmentId(null);
		}
		employee.setFirstName(rowSet.getString("first_name"));
		employee.setLastName(rowSet.getString("last_name"));
		employee.setBirthDate(rowSet.getDate("birth_date").toLocalDate());
		employee.setHireDate(rowSet.getDate("hire_date").toLocalDate());
		return employee;
	}

}
