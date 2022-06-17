package java17;

public class InstanceOf {

    public static void main(String args[]){

        InstanceOf instOf = new InstanceOf();
        instOf.printObjectType("test");
    }

    private void printObjectType(Object obj){

        //traditional approach
         if(obj instanceof String) {
            String type = (String) obj;
            if(type != null)
                System.out.println("It's a String");
        }

        //Java17 approach
        if(obj instanceof  String s && s != null)
            System.out.println("It's a String");

    }
}
