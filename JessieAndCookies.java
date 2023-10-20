import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

 

class Result4 {

 

    public static int cookies(int k, List<Integer> A) {

    int ans=0;

    System.out.println("Arr "+A);
    PriorityQueue<Integer> arr=new PriorityQueue<>(A);

    System.out.println("Que "+arr);
    while(arr.peek()<k){

        if(arr.size()<2){
            return -1;
        }

    int x=arr.poll();
    System.out.println("x "+x);
    int y=arr.poll();
    System.out.println("y "+y);
    int sum=x+y*2;

    arr.add(sum);

    ans++;


    }

    return ans;

    }

 

}

 

public class Jesse_And_Cookies {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);

 

        int n = sc.nextInt();

 

        int k = sc.nextInt();
        List<Integer> A=new ArrayList<>();

 

        while(n-- >0) {
            A.add(sc.nextInt());

        }

 

        int result = Result4.cookies(k, A);

 

        System.out.println(result);
    }
}