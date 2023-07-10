package entity;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class Emp {
	private int no;		//社員番号
	private String name;		//社員名
	private LocalDate hireDate;		//社員名
	private Dept dept;			//部署
	private int branchNo;	//ダミーのラジオボタン

	//LocalDate型からjava.sql.Date型に変換し返却
	//Insert文発行時に使用する
	public Date getSqlHireDate() {
		return  Date.valueOf(hireDate);
	}
	//LocalDate型からStrin形に変換し返却
	//画面表示時に使用  JSPで${〇〇Scope.emp.stringHireDate}
	//と書いたときにこのメソッドが呼ばれる
	public String getStringHireDate() {
		return hireDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
	}

	public Emp(String name, LocalDate hireDate, Dept dept, int branchId) {
		this.name = name;
		this.hireDate = hireDate;
		this.dept = dept;
		this.branchNo = branchId;
	}

	public Emp(int no, String name, LocalDate hireDate, Dept dept) {
		this.no = no;
		this.name = name;
		this.hireDate = hireDate;
		this.dept = dept;
	}


}
