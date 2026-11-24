/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a,b)-> Integer.compare(a.start,b.start));

        int max=0;
        int count =0;
        PriorityQueue<Integer> endTimes = new PriorityQueue<>();

        for(Interval meeting: intervals){
            if(!endTimes.isEmpty() && endTimes.peek()<=meeting.start){
                endTimes.poll();

            }

            endTimes.offer(meeting.end);

        }

        return endTimes.size();

    }
}
