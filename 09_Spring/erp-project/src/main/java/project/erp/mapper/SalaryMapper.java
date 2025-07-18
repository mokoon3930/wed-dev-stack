package project.erp.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.project.erp.finance.vo.Salary;

@Mapper
public interface SalaryMapper {
	void addSale(Salary salary);
	
}
