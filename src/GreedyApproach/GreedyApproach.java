package GreedyApproach;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GreedyApproach {

    public static class Item
    {
        Integer value;
        Integer weight;

        @Override
        public String toString() {
            return value+" "+weight;
        }
    }

    public static class itemComparator implements Comparator<Item>
    {
        public int compare(Item i1,Item i2)
        {
//            return i1.value/ i1.weight - i2.value/ i2.weight;// ASC Order
            return i2.value/ i2.weight - i1.value/ i1.weight; // DSC Order
        }
    }

    public static void main(String[] args) {

        List<Integer> value = List.of(60,100,150,120);
        List<Integer> weight = List.of(10,20,50,15);
        List<Item> itemList = new ArrayList<>();

        int W = 30;

        int profit = 0;

        for (int i=0;i< value.size();i++)
        {
            Item item = new Item();

            item.value = value.get(i);
            item.weight = weight.get(i);

            itemList.add(item);
        }

        itemList.sort(new itemComparator());

        for (Item item : itemList) // Maximise Profit
        {
            int IW = item.weight;
            int IV = item.value;

            if (IW <= W) {
                W -= IW;
                profit += IV;
            } else {
                profit += (IV / IW) * W;
                break;
            }
        }

        System.out.println("Profit = " + profit);
    }
}
