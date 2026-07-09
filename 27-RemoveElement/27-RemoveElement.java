// Last updated: 09/07/2026, 10:07:40
class Solution {
    public int removeElement(int[] nums, int val) {
        int k =0;
        for(int i =0;i<nums.length;i++){
            if(nums[i] != val){
                nums[k]=nums[i];
                k++;
            }
        }
        return k;
        
    }
}