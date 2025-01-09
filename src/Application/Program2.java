package Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDAO;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		DepartmentDAO departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("=== Test 1: Seller findById ===");

		Department department = departmentDao.findById(3);
		System.out.println(department);

		List<Department> list = new ArrayList<>();
		System.out.println("\n=== Test 3: Seller findAll===");
		list = departmentDao.findAll();

		for (Department obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n=== Test 4: Seller Insert===");
		Department newDepartment = new Department(7, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New Id = " + newDepartment.getId());

		System.out.println("\n=== Test 5: Seller Update===");
		department = departmentDao.findById(1);
		department.setName("Teste");
		departmentDao.update(department);
		System.out.println("Update Completed");

		System.out.println("\n=== Test 6: Seller Delete===");
		System.out.println("Enter ID for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete Completed! ");

		sc.close();
	}
}
