package com.kh.polymorphism;





import java.util.Scanner;

import com.kh.polymorphism.controller.EmployeeController;
// FQCN(Full Qualified Class Name)
import com.kh.polymorphism.model.Employee;
import com.kh.polymorphism.model.Engineer;
import com.kh.polymorphism.model.Manager;
import com.kh.polymorphism.model.Secretary;

	/*
	 * 다양성(polymorphism)
	 * - 하나의 객체 변수가 여러가지 모양과 모습을 가지는 능력
	 * - 부모 타입으로 자식 객체를 생성하는것
	 * 
	 *  Liskov Substitution Principle, LSP
	 *  - 부모의 객체는 자식 객체로 교체해도 문제 없다.
	 *  - 다향성이 제대로 설계되어 있는지 판단 하는 기준 중 하나
	 * 
	 * */

public class Application {

	
	
	public static void main(String[] args) {
		Employee em = new Employee("문채은", 3000000);
		Employee en = new Engineer("최다인", 3500000, "자바", 300000);
		Employee ma = new Manager("김은진", 4000000, "개발팀");
		Employee se = new Secretary("전영현", 4500000, "문채은");
		
		//System.out.println(em);
		//System.out.println(en);
		//System.out.println(ma);
		//System.out.println(se);
		
		
		
		// 다양성 + 객체 배열
		Employee[] emp = {em, en, ma, se};
		
		for (Employee employee : emp) {
			//System.out.println(employee);
		}
		
		EmployeeController ec = new EmployeeController();
		// 이름으로 사람 찾기 -> 이름은 문자열(equals), getName
		
		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력해주세요 : ");
		String name = sc.nextLine();
		//System.out.println(em.getName());
		//System.out.println("이름 : ");
		//String name = sc.nextLine();
		
		
		
		// 찾은 사람의 연봉은?
		//System.out.println(em.getSalary() * 12);
		// 특정 자식 객체 찾는 방법!
		int annual = ec.getAnnualSalary(findEmployee);
		if(annual != -1);
		System.out.println(annual);
			
		
		//전체 총 월급 (for문 필요! 각 getSalary 더해 나가기)
		//System.out.println(em.getSalary() + en.getSalary() + ma.getSalary() + se.getSalary());
		System.out.println(ec.totalSalary(emp));
	}
}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

