package GreedyApproach;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GA2 {

    static class Meeting
    {
        int startTime;
        int endTime;
        int meetingNum;

        public String toString()
        {
            return (startTime+" "+endTime);
        }
    }


    private static class MeetingSort implements Comparator<Meeting>
    {
        public int compare(Meeting m1, Meeting m2)
        {
            return m1.endTime - m2.endTime;
        }
    }
    public static void main(String[] args) {
        List<Integer> start = List.of(1,3,0,5,8,5);
        List<Integer> end = List.of(2,4,6,7,9,9);

        List<Meeting> meetingList = new ArrayList<>();

        for (int i=0;i< start.size();i++)
        {
            Meeting meeting = new Meeting();

            meeting.startTime = start.get(i);
            meeting.endTime = end.get(i);
            meeting.meetingNum = i+1;

            meetingList.add(meeting);
        }

        meetingList.sort(new MeetingSort());

        System.out.println(meetingList);

        List<Meeting> result = new ArrayList<>();

        result.add(meetingList.get(0));
        int resultLastIndex=0;

        for (int i=1;i< meetingList.size();i++)
        {
            int et = result.get(resultLastIndex).endTime;
            int st = meetingList.get(i).startTime;

            if (et<=st)
            {
                result.add(meetingList.get(i));
                resultLastIndex++;
            }
        }

        System.out.println(result);//Answer

        for (Meeting obj:result)//Printing Meeting Number
        {
            System.out.print(obj.meetingNum+" ");
        }
    }
}
