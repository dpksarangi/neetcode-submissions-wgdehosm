class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, Map<String,Double>> graph = new HashMap();
        for(int i=0;i< equations.size();i++){
            String from = equations.get(i).get(0);
            String to = equations.get(i).get(1);
            Double rate= values[i];

            graph.putIfAbsent(from, new HashMap<String,Double>());
            graph.putIfAbsent(to, new HashMap<String,Double>());

            graph.get(from).put(to,rate);
            graph.get(to).put(from,1.0/rate);
        }

        double[] results= new double[queries.size()];

        for(int i=0;i<queries.size();i++){
            String from = queries.get(i).get(0);
            String to = queries.get(i).get(1);

            if (!graph.containsKey(from) || !graph.containsKey(to)) {
                results[i] = -1.0;
                continue;
            }

            if (from.equals(to)) {
                results[i] = 1.0;
                continue;
            }

            Set<String> visited= new HashSet();

            results[i]= dfs(from,to,1.0, graph,visited);
        }
        return results;
        
    }

    public static double dfs(String current, String to, double product, Map<String, Map<String,Double>> graph, Set<String> visited){

        if(current.equals(to))
            return product;
        
        visited.add(current);
        for(Map.Entry<String, Double> neighbour: graph.get(current).entrySet()){
            String next= neighbour.getKey();
            double weight = neighbour.getValue();

            

            if(visited.contains(next)){
                continue;
            }
            double result = dfs(next,to,product*weight,graph,visited);

            if(result!=-1.0){
                return result;
            }
        }

        return -1.0;


    }
}