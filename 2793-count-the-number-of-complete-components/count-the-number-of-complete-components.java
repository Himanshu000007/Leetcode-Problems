class Solution {
    int nodeCount = 0;
    int edgeCount = 0;

    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<Integer>[]graph = new ArrayList[n];
        for(int i = 0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        boolean visited[] = new boolean[n];
        int ans = 0;

        for(int i = 0;i < n;i++){
            if(!visited[i]){
                nodeCount = 0;
                edgeCount = 0;

                dfs(i,graph,visited);
                int actualEdges = edgeCount / 2;
                int expectedEdges = nodeCount * (nodeCount - 1)/2;

                if(actualEdges == expectedEdges){
                    ans++;
                }
            }
        }
        return ans;
    }


    private void dfs(int node,ArrayList<Integer>[]graph,boolean[]visited){
        visited[node] = true;
        nodeCount++;

        for(int neighbour: graph[node]){
            edgeCount++;
            if(!visited[neighbour]){
                dfs(neighbour,graph,visited);
            }
        }
    }
}
