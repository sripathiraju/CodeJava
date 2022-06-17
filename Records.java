package java17;

/*
1)Record is a special type of class like enum.
2)The arguments inside parenthesis are final by default.
3)Record generates getters method automatically that can be accessed using obj.argumentName.
4)Record generates equals, hashcode, toString methods automatically.
5)Records doesn't generate any setter methods and Records are immutable.
6)We can create instance methods and static methods.
7)We can create static fields but instance fields are not allowed.
8)Records can't extend any other class because it implicitly extends record class like enum extends enum class but they can implement
9)Records are final classes implicitly, and they can't be extended by any other class
10)Records provide canonical constructor implicitly, We can override it if needed. or we can write the compact constructor like shown in below code
*/

import java.util.Objects;

public class Records {

    public static void main(String args[]){

        //Traditional way
        EmployeeClass empClass = new EmployeeClass("Employee 1", 123);
        System.out.println(empClass);
        System.out.println("Name is : "+empClass.getName()+" and EmpNo is : "+empClass.getEmpNo());

        //New way
        EmployeeRecord empRecord = new EmployeeRecord("Employee 2", 456);
        System.out.println(empRecord);
        System.out.println("Name is : "+empRecord.name()+" and EmpNo is : "+empRecord.empNo());

        EmployeeRecord2 empRecord2 = new EmployeeRecord2("Employee 3", 789);
        System.out.println(empRecord2.nameInUpperCase("test"));
        EmployeeRecord2.printHello();
    }
}


record EmployeeRecord(String name, int empNo){}



record EmployeeRecord2(String name, int empNo){

    public static final String STATIC_FIELD = "STATIC_FIELD";
    //public String instanceField;

   public EmployeeRecord2(String name, int empNo){
        if(empNo < 0)
            throw new IllegalArgumentException("Employee No should not negative");
        this.name = name;
        this.empNo = empNo;
    }

   /* public  EmployeeRecord2{
        if(empNo < 0)
            throw new IllegalArgumentException("Employee No should not negative");
    } */

    public String nameInUpperCase(String name){
        return name.toUpperCase();
    }

    public static void printHello(){
        System.out.println("Hello from Records");
    }
}

class EmployeeClass{
    private final String name;
    private  final int empNo;

    EmployeeClass(String name, int empNo) {
        this.name = name;
        this.empNo = empNo;
    }

    public String getName() {
        return name;
    }

    public int getEmpNo() {
        return empNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeClass that = (EmployeeClass) o;
        return empNo == that.empNo && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, empNo);
    }

    @Override
    public String toString() {
        return "EmployeeClass{" +
                "name='" + name + '\'' +
                ", empNo=" + empNo +
                '}';
    }
}