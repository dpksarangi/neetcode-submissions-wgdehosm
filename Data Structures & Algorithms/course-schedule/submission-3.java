class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean result = true;
        Map<Integer, List<Integer>> graph= new HashMap();
        for(int i=0; i< prerequisites.length; i++){
            graph.putIfAbsent(prerequisites[i][0],new ArrayList());
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }


        for(int course: graph.keySet()){
            int[] path= new int[numCourses];
            result = result && dfs(course,graph,path);
        }

        return result;
        
        
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
        boolean result = true;
        path[course]=1;
        for(int s: graph.get(course)){
            result= result && dfs(s,graph,path);
        }

        path[course]=2;

        return result;
    }
}
