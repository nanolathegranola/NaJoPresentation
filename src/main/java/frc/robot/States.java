public class States {

    public static enum ArmStates {
        UP(180),
        DOWN(-50),
        STOP(0);

        public final double degrees;

        ArmStates(double degrees) {
            this.degrees = degrees;
        }
    }

}
