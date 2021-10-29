package Impl.inheritance;

public class InheritanceStudy {

    int left, right;

    public InheritanceStudy(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public void setLF(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public void sum() {
        System.out.println(this.left + this.right);
    }

    public void avg() {
        System.out.println((this.left + this.right) / 2);
    }
}

class SubInheritanceStudy extends InheritanceStudy {

    public SubInheritanceStudy(int right, int left) {
        super(right,left);
    }
    public void sub(){
        System.out.println(this.left - this.right);
    }
}

