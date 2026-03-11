package pac2;

import pac1.BaseClass;

public class DifferentPackageNonSubclass {
    public static void main(String[] args) {
        BaseClass obj = new BaseClass();
        
        // This should cause a compilation error
        // ProtectionLevel has protected access in pac1.BaseClass
        // DifferentPackageNonSubclass is in pac2 and does NOT extend BaseClass
        // Therefore, it cannot access the protected inner class
        
        // Uncommenting the lines below will cause compile-time errors:
        // BaseClass.ProtectionLevel pLevel = obj.new ProtectionLevel();
        // pLevel.display();
        
        System.out.println("Cannot access protected inner class from a non-subclass in a different package.");
    }
}
