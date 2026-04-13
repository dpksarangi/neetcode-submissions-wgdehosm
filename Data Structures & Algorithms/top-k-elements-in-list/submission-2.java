class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map= new HashMap();
        for(int a: nums){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        PriorityQueue<Integer> pq= new PriorityQueue<Integer>((a,b)->map.get(a)-map.get(b));
        for(int i: map.keySet()){
            pq.add(i);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[] result= new int[k];

        for(int i=0;i<k;i++){
            result[i]=(pq.poll());
        }
        return result;
     }
}
