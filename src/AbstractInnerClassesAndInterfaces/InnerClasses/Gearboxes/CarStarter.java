package AbstractInnerClassesAndInterfaces.InnerClasses.Gearboxes;

public class CarStarter {

    public static void main(String[] args) {
        Gearbox mcLaren = new Gearbox(6); // outer class
        mcLaren.operateClutch(true);
        mcLaren.changeGear(1);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(1000));
        mcLaren.changeGear(2);
        System.out.println(mcLaren.wheelSpeed(3000));
        mcLaren.operateClutch(true);
        mcLaren.changeGear(3);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(6000));
    }
}
