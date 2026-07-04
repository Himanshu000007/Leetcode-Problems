class Solution {
    HashMap<Integer,HashMap<Integer,HashSet<Integer>>> graph;
    public int minScore(int n, int[][] edges) {
        int minEdge = Integer.MAX_VALUE;
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        graph = new HashMap<>();
        for(int edge[] : edges){
            HashMap<Integer,HashSet<Integer>> nodes = graph.getOrDefault(edge[0],new HashMap<>());
            HashSet<Integer> duplicates = nodes.getOrDefault(edge[1],new HashSet<>());
            duplicates.add(edge[2]);
            nodes.put(edge[1],duplicates);
            graph.put(edge[0],nodes);

            nodes = graph.getOrDefault(edge[1],new HashMap<>());
            duplicates = nodes.getOrDefault(edge[0],new HashSet<>());
            duplicates.add(edge[2]);
            nodes.put(edge[0],duplicates);
            graph.put(edge[1],nodes);
            
        }
        q.offer(1);
        visited[1] = true;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- != 0){
                int node = q.poll();
                HashMap<Integer,HashSet<Integer>> edgesList = graph.get(node); 
                if(edgesList == null) continue;
                for(int key : edgesList.keySet()){
                    for(int wt : edgesList.get(key)){
                        if(!visited[key]){
                            visited[key] = true;
                            q.offer(key);
                        }
                        minEdge = Math.min(minEdge,wt);
                    }
                }
            }
        }
        return minEdge;
    }
}