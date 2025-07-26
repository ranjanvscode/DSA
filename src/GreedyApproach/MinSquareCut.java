package GreedyApproach;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MinSquareCut {


    public static void main(String[] args) {

        List<Integer> X = new ArrayList<>();
        List<Integer> Y = new ArrayList<>();

        X.add(5);X.add(8);X.add(3);X.add(4);X.add(2);
        Y.add(4);Y.add(1);Y.add(2);

        X.sort(Comparator.reverseOrder());
        Y.sort(Comparator.reverseOrder());

        System.out.println(X);
        System.out.println(Y);
    }
}


