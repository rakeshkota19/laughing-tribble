class Solution {

    class Pair implements Comparable<Pair>{
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this. y = y;
        }

        public int compareTo(Pair o) {
            int a = ( this.x * this.x + this.y * this.y);
            int b = ( o.x * o.x + o.y*o.y);
            return b - a;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        int len = points.length;

        for (int i = 0 ; i < k ; i++) {
            pq.add(new Pair(points[i][0], points[i][1]));
        }

        for (int i = k ; i < len ; i++) {
            int x = points[i][0], y = points[i][1];
            double a = Math.sqrt( x * x + y *y);
            Pair o = pq.peek();
            double b = Math.sqrt( o.x * o.x + o.y *o.y);
          //  System.out.println("x" + o.x + " y: " + o.y);
            if (a >= b)
                continue;
            
            pq.poll();
            pq.add(new Pair(x,y));
        }

        int [][] ans = new int[k][2];
        int i = 0;
        while (!pq.isEmpty()) {
            Pair o = pq.poll();
            ans[i][0] = o.x;
            ans[i][1] = o.y;
            i++;
        }

        return ans;
    }
}