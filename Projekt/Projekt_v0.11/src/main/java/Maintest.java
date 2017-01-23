public class Maintest {
    Integer first;
    Integer second;
    Integer [] tab={first,second};
    Maintest(){
        first=new Integer(12);
        second=new Integer(11);
        System.out.println(tab[0]);
    }
    public static void main(String[] args) {
        Maintest test=new Maintest();
    }
}
