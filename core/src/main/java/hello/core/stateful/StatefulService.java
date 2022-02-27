package hello.core.stateful;

public class StatefulService {

    private int price;

    public void order(String name, int price){
        this.price = price; //이 부분이 문제가 된다.
    }

    public int getPrice(){
        return price;
    }

    // 만일 무상태(statless)로 설계하려면
    // 아래 처럼 설계했어야 한다.

//    public int orderStateless(String name, int price){
//        return price ;
//    }
//
//    int price = statefulService.order("User-A", 10000);
}
