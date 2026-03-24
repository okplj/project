
public class College {

	protected String name;
	protected int numOfdept;
	public Department [] deptList;
	
	public College (String name, int numOFdept) {
		this.name = name;
		this.numOfdept = numOFdept;
		deptList = new Department [numOFdept];
	}
	
	public void addDept(Department D){
		if(numOfdept < deptList.length) 
			deptList[numOfdept]= D;
		numOfdept++;
	}
	public int sumOfstudent(Department S) {
		int sum = 0;
		for (int i=0;i<numOfdept; i++) {
			sum += S.totalStudent;
		}
		return sum;
	}
}
