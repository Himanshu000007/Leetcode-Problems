class Solution {

    public void dfs(int[][] isConnected,int node,boolean[] visited){
        int n = isConnected.length;
        visited[node] = true;
        for(int neighbour = 0;neighbour<n;neighbour++){
            if(!visited[neighbour] && isConnected[node][neighbour]==1){
                dfs(isConnected,neighbour,visited);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int provinces = 0;
        boolean visited[] = new boolean[isConnected.length];
        for(int i = 0;i<isConnected.length;i++){

        if(!visited[i]){
            dfs(isConnected,i,visited);
            provinces++;
        }
        }
        return provinces;
    }
}