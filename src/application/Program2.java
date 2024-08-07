package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		List<Department> list = new ArrayList<>();
		
		System.out.println("=== TEST 1: department findById ===");
		Department dep = depDao.findById(4);
		System.out.println(dep);
		
		
		System.out.println("\n=== TEST 2: department update ====");
		dep = depDao.findById(6);
		dep.setName("Cometics");
		depDao.update(dep);
		System.out.println("Update complete!");
		
		
		System.out.println("\n=== TEST 3: department insert ===");
		Department newDep = new Department(7, "Ifood");
		depDao.insert(newDep);
		System.out.println("Inserted! New id = " + newDep.getId());
		
		
		System.out.println("\n=== TEST 4: department delete ===");
		System.out.print("Enter id for delete teste: ");
		int id = sc.nextInt();
		depDao.deleteById(id);
		System.out.println("Delete completed");
		
		System.out.println("\n=== TEST 5: department findAll ====");
		list = depDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}
		
		
		
		
		sc.close();
	}

}
