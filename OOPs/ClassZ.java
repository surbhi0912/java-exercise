package OOPs;

public class ClassZ extends ClassY
{
        public void methodZ() {
                System.out.println("class Z method");
        }
        public static void main(String args[]){
                ClassZ obj = new ClassZ();
                obj.methodX(); //calling grand parent class method
                obj.methodY(); //calling parent class method
                obj.methodZ(); //calling local method
        }
}
