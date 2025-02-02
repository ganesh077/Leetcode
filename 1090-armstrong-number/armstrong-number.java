class Solution {
    public boolean isArmstrong(int n) {
        int count = countdigits(n);
        int modified = n;
        int sum = 0;

        while (modified > 0) {
            int temp_var = modified%10;
            sum += Math.pow(temp_var,count);
            System.out.print(sum+" ");
            modified /= 10;
        }

        
        return sum == n;


    }

    static int countdigits(int a) {
        int modified = a;
        int count = 0;
        while (modified > 0) {
            count += 1;
            modified = modified/10;
        }
        return count;
    }
}