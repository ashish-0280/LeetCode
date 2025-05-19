class Solution {
    public String triangleType(int[] nums) {
        int num1 = nums[0];
        int num2 = nums[1];
        int num3 = nums[2];
        if(num1 + num2 <= num3 || num2 + num3 <= num1 || num3 + num1 <= num2){
            return "none";
        } else if(num1 == num2 && num2 == num3){
            return "equilateral";
        } else if(num1 == num2 || num2 == num3 || num3 == num1){
            return "isosceles";
        } 
        return "scalene";
    }
}