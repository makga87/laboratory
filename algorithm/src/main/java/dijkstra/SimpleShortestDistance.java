package dijkstra;

public class SimpleShortestDistance {

    // https://m.blog.naver.com/ndb796/221234424646 첫번째 그래프 모양 참고

    private int INF = Integer.MAX_VALUE;

    private int[][] graph = {
            {0, 2, 5, 1, INF, INF},
            {2, 0, 3, 2, INF},
            {5, 3, 0, 3, 1, 5},
            {1, 2, 3, 0, 1, INF},
            {INF, INF, 1, 1, 0, 2},
            {INF, INF, 5, INF, 2, 0}
    };

    public int[] distance = {0, INF, INF, INF, INF, INF};

    public static void main(String[] args) {

        SimpleShortestDistance simpleShortestDistance = new SimpleShortestDistance();
        int[][] _graph = simpleShortestDistance.graph;
        int minIdx = 0;
        for (int i = 0; i < _graph.length; i++) {

            for (int j = minIdx; j < _graph[i].length; j++) {
                minIdx = simpleShortestDistance.searchShortIndex(_graph[i]);

            }
        }

    }

    public int searchShortIndex(int[] row) {
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int i = 0; i < row.length; i++) {
            if (min > row[i]) {
                min = row[i];
                minIdx = i;
            }
        }
        return minIdx;
    }

}
