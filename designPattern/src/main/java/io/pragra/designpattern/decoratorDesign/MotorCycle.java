package io.pragra.designpattern.decoratorDesign;

public interface MotorCycle {
    String make();
    String model();

     class Honda implements MotorCycle {
        @Override
        public String make() {
            return "Pulser";
        }

        @Override
        public String model() {
            return "Sports";
        }
    }

    class MotorCycleDecorator implements MotorCycle {
        private MotorCycle motorCycle;
        public MotorCycleDecorator(MotorCycle motorCycle) {
            this.motorCycle = motorCycle;
        }

        @Override
        public String make() {
            return motorCycle.make();
        }

        @Override
        public String model() {
            return motorCycle.model();
        }
    }

    class Addshoker extends MotorCycleDecorator {
        public Addshoker(MotorCycle motorCycle) {
            super(motorCycle);
        }

        @Override
        public String make() {
            return super.make() + "Addshoker";
        }

        @Override
        public String model() {
            return super.model() + "Add sports model shokers";
        }
    }

    static void main(String[] args) {
        MotorCycle motorCycle = new Honda();
        motorCycle = new Addshoker((motorCycle));
        System.out.println(motorCycle.make());
        System.out.println(motorCycle.model());
    }
}
