package org.example.model.dao.impl;

import org.example.db.DB;
import org.example.db.DbException;
import org.example.model.dao.DepartmentDAO;
import org.example.model.entities.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDAO {

    private Connection conn;

    public DepartmentDaoJDBC(Connection conn){this.conn = conn;}

    @Override
    public void insertDepartment(Department department) {

    }

    @Override
    public void updateDepartment(Department department) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Department findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("select * from department where Id = ?");

            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()){
                return instantiateDepartment(rs);
            }
            return null;

        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Department> findAll() {
        return List.of();
    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException{
        return new Department(rs.getInt("Id"), rs.getString("Name"));
    }
}
