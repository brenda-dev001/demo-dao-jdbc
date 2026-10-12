package org.example.application;

import org.example.db.DB;
import org.example.model.dao.DaoFactory;
import org.example.model.dao.impl.SellerDaoJDBC;
import org.example.model.entities.Department;
import org.example.model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Program {

    public static void main(String[] args){

        SellerDaoJDBC sellerDaoJdbc = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: seller findById() ===");
        Seller seller = sellerDaoJdbc.findById(1);
        System.out.println(seller);

        System.out.println("=== TEST 2: seller findByDepartment() ===");
        Department department = new Department(2, "departmentTest");
        List<Seller> listFindByDepartment = sellerDaoJdbc.findByDepartment(department);

        for(Seller obj : listFindByDepartment){
            System.out.println(obj);
        }

        System.out.println("=== TEST 3: seller findAll() ===");
        List<Seller> listFindAll = sellerDaoJdbc.findAll();

        for(Seller obj : listFindAll){
            System.out.println(obj);
        }

        System.out.println("=== TEST 4: seller insertSeller() ===");
        Seller insertSeller = new Seller(null, "Luiza", "Luiza@", new Date(), 4000.0, department);
        sellerDaoJdbc.insertSeller(insertSeller);
        System.out.println("Inserted! New id = " + insertSeller.getId());
    }
}
