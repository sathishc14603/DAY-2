class Solution { 
    public int[] nextGreaterElements(int[] nums) { 
        int len=nums.length; 
        int ans[]=new int[len]; 
        Arrays.fill(ans,(int)- (1e9+7)); 
        Stack<Integer> stk=new Stack<>(); 
        boolean b=true; 
        int cnt=0,p=0; 
        for(int i=0;i<len*2;++i){ 
            while(!stk.isEmpty()&&nums[stk.peek()]<nums[i%len]){ 
                int k=stk.pop(); 
                if(k==len-2){cnt++;} 
                ans[k]=nums[i%len]; 
                if(cnt==2){b=!b; break;} 
            } 
            if(!b) break; 
            stk.push(i%len); 
        } 
        for(int i=0;i<len;++i) if(ans[i]==(int)-(1e9+7)) ans[i]=-1; 
        return ans; 
    } 
}
