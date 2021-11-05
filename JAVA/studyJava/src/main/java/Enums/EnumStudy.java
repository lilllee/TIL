package Enums;


// Enum은 안에서도 사용 가능 하고 class 밖에서도 사용 가능
// 그리고 Enum은 Type이 없음 그리고 대문자로

enum Level {
    LOW, MEDIUM, HIGH
}

public class EnumStudy {

    enum Flavor {
        CHOCOLATE, VANILLA, STRAWBERRY;

        public static void getChocolate() {
            System.out.println(Flavor.CHOCOLATE);
        }
    }

    enum Transport {
        PLANE(100), TRAIN(200), AUTOMOBILE(300);

        int speed;

        Transport(int s) {
            speed = s;
        }

        public static int[] getAllSpeed() {
            return new int[]{PLANE.speed, TRAIN.speed, AUTOMOBILE.speed};
        }

        public static int[] getAllOrdinal() {
            return new int[]{PLANE.ordinal(), TRAIN.ordinal(), AUTOMOBILE.ordinal()};
        }
    }

    static String[] levels = {"Low", "Medium", "High"};

    public static void main(String[] args) {

        System.out.println("=================");

        System.out.println(levels[0]);
        System.out.println(levels[1]);
        System.out.println(levels[2]);

        System.out.println("=================");

        System.out.println(Level.HIGH);
        System.out.println(Level.MEDIUM);
        System.out.println(Level.LOW);

        System.out.println("=================");

        Level level = Enums.Level.LOW;
        System.out.println(level);

        switch (level) {
            case LOW -> System.out.println("Low Level");
            case MEDIUM -> System.out.println("Medium Level");
            case HIGH -> System.out.println("High Level");
        }

        System.out.println("=================");

        Flavor flavor = Flavor.CHOCOLATE;

        Flavor.getChocolate();

        System.out.println("=================");

        Transport[] transport = Transport.values();

        for (Transport transportValues : transport) {
            System.out.println(transportValues);
        }

        System.out.println("=================");

        int[] transportsSpeed = Transport.getAllSpeed();

        for (int speed : transportsSpeed) {
            System.out.println(speed);
        }

        System.out.println("=================");

        int[] transportsOrdinal = Transport.getAllOrdinal();

        for (int ordinal : transportsOrdinal) {
            System.out.println(ordinal);
        }

        System.out.println("=================");

        Transport tp = Transport.TRAIN;

        if (tp.ordinal() < 2){
            System.out.println("Not an AutoMobile");
        }

        System.out.println("=================");
    }
}
