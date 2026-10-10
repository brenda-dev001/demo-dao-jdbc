package org.example.model.dao;

import org.example.model.entities.Department;

import java.util.List;

public interface DepartmentDAO {

     void insertDepartment(Department department);

     void updateDepartment(Department department);

     void deleteById(Integer id);

     Department findById(Integer id);

     List<Department> findAll();

}
