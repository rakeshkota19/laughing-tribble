class Solution {
    public boolean isHappy(int n) {
        Set<Integer> s = new HashSet<Integer>();

        while (true) {
            if (s.contains(n))
                return false;

            if (n == 1)
                return true;
   
            int tmp = 0;
            s.add(n);
            while(n > 0) {
                int rem = n % 10;
                tmp = tmp + (rem*rem);
                n = n / 10;
            }

            System.out.println(tmp);
            n = tmp;
            
        }

    }
}