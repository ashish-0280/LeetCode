class Solution 
{
    public long bowlSubarrays(int[] nums) 
    {
        long count=0;
        
        //FIND NEXT GREATER
        int nextgreater[]=new int[nums.length];
        nextgreater=nextgreaterelement(nums);

        //FIND PREV GREATER
        int prevgreater[]=new int[nums.length];
        prevgreater=prevgreaterelement(nums);

        //NOW TRVAERSE FROM START -> use next greater
        for(int i=0;i<nums.length;i++)
        {
            int next=nextgreater[i];

            if(next!=-1 && next-i+1>=3){count++;}
        }

        //NOW TRAVERSE AGAIN FROM START -> use prev greater
        for(int i=0;i<nums.length;i++)
        {
            int prev=prevgreater[i];

            if(prev!=-1 && i-prev+1>=3){count++;}
        }

        return count;
    }

    public int[] nextgreaterelement(int nums[])
    {
        Deque<Integer> stack=new ArrayDeque<>();
        int res[]=new int[nums.length];
        for(int i=nums.length-1;i>=0;i--)
        {
            int curr=nums[i];

            while(!stack.isEmpty() && nums[stack.peek()]<=curr)
            {
                stack.pop();
            }

            res[i]=(stack.isEmpty()) ? -1 : stack.peek();
            stack.push(i);
        }

        return res;
    }

    public int[] prevgreaterelement(int nums[])
    {
        Deque<Integer> stack=new ArrayDeque<>();
        int res[]=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            int curr=nums[i];

            while(!stack.isEmpty() && nums[stack.peek()]<=curr)
            {
                stack.pop();
            }

            res[i]=(stack.isEmpty()) ? -1 : stack.peek();
            stack.push(i);
        }

        return res;
    }

}