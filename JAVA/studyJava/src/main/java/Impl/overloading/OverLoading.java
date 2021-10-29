package Impl.overloading;

public class OverLoading {

    int a, b;
    int c = 0;

    public void set(int a, int b) {
        System.out.println("set A B");
        this.a = a;
        this.b = b;
    }

    public void set(int a, int b, int c) {
        System.out.println("set A B C");
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void sum() {
        System.out.println(this.a + this.b + this.c);
    }
}

class OverLoadingTest extends OverLoading {

    public static void main(String[] args) {
        OverLoading overLoading = new OverLoading();
        overLoading.set(10,20);
        overLoading.sum();
        overLoading.set(10,20,30);
        overLoading.sum();
    }
}
