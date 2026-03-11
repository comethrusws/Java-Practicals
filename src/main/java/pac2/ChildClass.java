package pac2;

import pac1.BaseClass;

public class ChildClass extends BaseClass {
    public static void main(String[] args) {
        ChildClass obj = new ChildClass();
        // Accessing protected method from parent class in another package
        obj.display();

        // Accessing protected inner class
        // ChildClass inherits the protected inner class definition from BaseClass
        BaseClass.ProtectionLevel pLevel = obj.new ProtectionLevel();
        pLevel.display();
        
        System.out.println("Accessing inner class fields from pac2.ChildClass:");
        // System.out.println("Default data: " + pLevel.data); // Not accessible (package-private)
        System.out.println("Public data: " + pLevel.pubdata);
        // System.out.println("Protected data: " + pLevel.protdata); // Not accessible (ChildClass is NOT a subclass of ProtectionLevel, just BaseClass)
        // System.out.println("Private data: " + pLevel.privdata); // Not accessible (private) 
    }
}
