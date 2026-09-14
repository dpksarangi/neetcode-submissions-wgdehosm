class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        Map<Integer, List<Integer>> graph= new HashMap();
        for(int i=0; i< prerequisites.length; i++){
            graph.putIfAbsent(prerequisites[i][0],new ArrayList());
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int[] path= new int[numCourses];
        for(int course: graph.keySet()){
            
            if(! dfs(course,graph,path)) return false;
        }

        return true;
        
        
    }

    public static boolean dfs(int course, Map<Integer, List<Integer>> graph, int[] path){
        
        if(path[course]==1){
            return false;
        }
        if(path[course]==2){
            return true;
        }
        if(!graph.containsKey(course)){
            return true;
        }
        
        path[course]=1;
        for(int s: graph.get(course)){
            if(! dfs(s,graph,path)) return false;
        }

        path[course]=2;

        return true;
    }
}
