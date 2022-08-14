package test;

public class MyClass {
    public static void main(String[] args) {
        name2 a = new name2(10);
        System.out.println(a.toString());
    }
    public static class name {
        public int diem;

        public name(int diem) {
            this.diem = diem;
        }

        public String toString() {
            return "Diem :" + diem;
        }
    }

    public static class name1 extends name {

        public name1(int diem) {
            super(diem);
        }

        @Override
        public String toString() {
            return super.toString() + "lan1";
        }
    }
    public static class name2 extends name1 {
        public name2(int diem) {
            super(diem);
        }

        @Override
        public String toString() {
            return super.toString() + " lan 2";
        }
    }
}
