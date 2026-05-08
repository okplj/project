
import java.io.*;

public class College {

	protected String name;
    protected int numOfdept;
    public Department [] deptList;

  //class Constructer
    public College (String name, int size) {
        this.name = name;
        numOfdept = 0;
        deptList = new Department [size];
    }

   //adds department to college
    // handling an exception
    public void addDept(Department D) throws CollegeException {

    	if(numOfdept >= deptList.length){
    		throw new CollegeException("there is no space to add new department.");
    	}
    	  deptList[numOfdept]= D;
    	  numOfdept++;
    	  
    		 //        if(numOfdept < deptList.length) {
//            deptList[numOfdept]= D;
//            numOfdept++;
//        }
//        else
//            System.out.println("there is no space to add new department.");
    }

//returns total number of students
    public int sumOfstudent() {
        int sum = 0;
        for (int i=0;i<numOfdept; i++) {
            sum += deptList[i].totalStudent;
        }
        return sum;
    }
    // checked exception and propagated
    public void SavetoFile(String name) throws IOException{
    	
    	File f = new File(name);
    	FileOutputStream fos = new FileOutputStream(f);
    	ObjectOutputStream obs = new ObjectOutputStream(fos);
    	obs.writeInt(numOfdept);
    	
    	for(int i = 0; i<numOfdept;i++) {
    		obs.writeObject(deptList[i]);
    	}
    	obs.close();
    	System.out.println("saved successfully");
    	
    }
    public void loadfromFile(String name) throws Exception {
    	
    		File f =new File(name);
    		FileInputStream fis=new FileInputStream(f);
    		ObjectInputStream ois = new ObjectInputStream(fis);
    		int count = ois.readInt();
    		if(count > deptList.length) {
    			deptList = new Department[count];
    		}
    		numOfdept = count ;
    		for(int i = 0; i<numOfdept;i++) {
        		deptList[i] = (Department)ois.readObject();
    		}
    		System.out.println("loaded successfully");
    		ois.close();
    	
    	
    }
}
