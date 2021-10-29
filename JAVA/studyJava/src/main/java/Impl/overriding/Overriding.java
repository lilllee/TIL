package Impl.overriding;

public class Overriding {
    int a, b;

    public Overriding(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public void sum(){
        System.out.println(this.a + this.b);
    }
    public void avg(){
        System.out.println((this.a + this.b) / 2);
    }
}

class OverridingTest extends Overriding {
    public OverridingTest(int a, int b) {
        super(a, b);
    }
    public void sum(){
        System.out.println("재정의해서 사용" + (this.a + this.b));
    }
    public void avg(){
        super.avg();
    }
}
