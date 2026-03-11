package pac1;

public class SamePackageNonSubclass {
    public static void main(String[] args) {
        BaseClass obj = new BaseClass();
        // Accessing protected member within the same package
        // This is allowed because protected access includes package-level access
        obj.display();

        // Accessing protected inner class
        BaseClass.ProtectionLevel pLevel = obj.new ProtectionLevel();
        pLevel.display();
        System.out.println("Accessing inner class fields:");
        System.out.println("Default data: " + pLevel.data);
        System.out.println("Public data: " + pLevel.pubdata);
        System.out.println("Protected data: " + pLevel.protdata);
        // pLevel.privdata is not accessible because it is private
    }
}
