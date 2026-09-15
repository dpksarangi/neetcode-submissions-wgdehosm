class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map= new HashMap();
        for(Integer i: nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        Queue<Integer> pq= new PriorityQueue((a,b)->map.get(a)-map.get(b));

        for(int val: map.keySet()){
            pq.offer(val);
        
            if(pq.size()>k){
                pq.poll();
            }

        }
        int[] result= new int[k];
        for(int i=0;i<k;i++){
            result[i]=pq.poll();
        }
        return result;

     }
}
