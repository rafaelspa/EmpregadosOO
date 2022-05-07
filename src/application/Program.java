/* Module 4 - Chapter 11 - EmployeeOO Challenge - Escola Devsuperior
 * Prof. Nelio Alves
 * 
 * Student: rsdepaula67@gmail.com
 * 
 * Description:
 * Program to exercise and evaluate composition of classes in UML style
 * using department, employee and address classes.
 */

package application;

import java.util.Scanner;

import model.entities.Address;
import model.entities.Department;
import model.entities.Employee;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// Department data
		System.out.print("Nome do departamento: ");
		String nameDepartment = sc.nextLine();
		System.out.print("Dia do pagamento: ");
		int payDay = sc.nextInt();
		
		Department department = new Department(nameDepartment, payDay);
		
		sc.nextLine();
		
		// Address data
		System.out.print("Email: ");
		String addressEmail = sc.nextLine();
		System.out.print("Telefone: ");
		String addressPhone = sc.nextLine();
		
		department.setAddress(new Address(addressEmail, addressPhone));
		
		
		// Employees' listing
		System.out.print("Quantos funcionários tem o departamento? ");
		
		int nEmployees = sc.nextInt();
		for (int i = 0; i < nEmployees; i++) {
			System.out.println("Dados do funcionário " + (i+1) + ":");
			sc.nextLine();
			System.out.print("Nome: ");
			String employeeName = sc.nextLine();
			System.out.print("Salário: ");
			double employeeSalary = sc.nextDouble();
			department.addEmployee(new Employee(employeeName, employeeSalary));
		}
		
		System.out.println();
		
		// Report decoupled from main.
		showReport(department);
		
		sc.close();
	}

	private static void showReport(Department department) {
		StringBuilder sb = new StringBuilder();
		sb.append("FOLHA DE PAGAMENTO:\n");
		sb.append("Departamento");
		sb.append(department.getName());
		sb.append(" = R$ ");
		sb.append(String.format("%.2f", department.payroll()) + '\n');
		sb.append("Pagamento realizado no dia ");
		sb.append(department.getPayDay() + "\n");
		sb.append("Funcionários:\n");
		for (Employee emp : department.getEmployees()) {
			sb.append(emp.getName() + "\n");
		}
		sb.append("Para dúvidas favor entrar em contato: ");
		sb.append(department.getAddress().getEmail());
		
		System.out.print(sb.toString());
	}

}
