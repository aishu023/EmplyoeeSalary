import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

 

class Result {

 

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

 

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
    // Write your code here

    Stack<Integer> scores = new Stack<>();
    scores.push(ranked.get(0));
    for (int i = 1; i < ranked.size(); i++) {
    int cur = ranked.get(i);
    if (!scores.peek().equals(cur))
    scores.push(cur);
    }

 

  List<Integer> result = new ArrayList<>();

 

    for (int i = 0; i < player.size(); i++) {
    int cur = player.get(i);
    while (!scores.isEmpty() && cur >= scores.peek()) {
        scores.pop();
    }

 

    result.add(scores.size() + (scores.isEmpty() || !scores.peek()  .equals(cur) ? 1 : 0));
}
    return result;

    // Set<Integer> rank=new HashSet<>();
    // rank.addAll(ranked);
    // ranked=new ArrayList<>(rank);
    // ranked.sort(Comparator.reverseOrder());
    // int n=player.size();
    // int r=ranked.size();
    // List<Integer> list=new ArrayList<>();



    // for(int i=0;i<n;i++){

    //     if(player.get(i)<ranked.get(r-1)){
    //         list.add(ranked.size()+1);
    //         continue;
    //     }
    //     for(int j=r-1;j>=0;j--){
    //         if(j==0){
    //             if(player.get(i)>=ranked.get(0)){
    //                 list.add(1);
    //                 continue;
    //             }
    //         }
    //           if(player.get(i)>=ranked.get(j) && player.get(i)<ranked.get(j-1)){
    //             list.add(j+1);
    //             continue;
    //         }

    //     }


    // }

    // return list;


 

    }

 

}

 

