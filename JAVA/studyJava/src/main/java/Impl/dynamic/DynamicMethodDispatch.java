package Impl.dynamic;

public class DynamicMethodDispatch {
    void print(){
        System.out.println("print super");
    }
}
class sub1 extends DynamicMethodDispatch{
    @Override
    void print(){
        System.out.println("print sub1");
    }
}
class sub2 extends DynamicMethodDispatch{
    @Override
    void print(){
        System.out.println("print sub2");
    }
}
class Test{
    public static void main(String[] args) {
        DynamicMethodDispatch dy = new DynamicMethodDispatch();
        dy.print();
        dy = new sub1();
        dy.print();
        dy = new sub2();
        dy.print();
    }
}