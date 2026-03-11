package pac1;

public class BaseClass {
    protected class ProtectionLevel{
        int data = 100;
        public int pubdata = 200;
        private int privdata = 300;
        protected int protdata = 400;

        public void display(){
            System.out.println("This is a public method from pac1.BaseClass.ProtectionLevel");
        }

        public ProtectionLevel(){
            System.out.println("Default data: " + data);
            System.out.println("Public data: " + pubdata);
            System.out.println("Private data: " + privdata);
            System.out.println("Protected data: " + protdata);
        }
    }

    protected void display() {
        System.out.println("This is a protected method from pac1.BaseClass");
    }

    public static void main(String[] args){
        BaseClass baseClass = new BaseClass();
        baseClass.display();
        ProtectionLevel protectionLevel = baseClass.new ProtectionLevel();
        protectionLevel.display();
    }
}
