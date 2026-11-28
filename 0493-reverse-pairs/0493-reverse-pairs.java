class Solution {
    int count = 0;
    public int reversePairs(int[] nums) {
        mergesort(nums);
        return count;
    }
    public void mergesort(int []nums){
        int n = nums.length;
        if(n<=1) return;
        int [] a = new int[n/2];
        int [] b = new int [n-n/2];
        int idx =0;
        for(int i =0;i<a.length;i++) a[i] = nums[idx++];
        for(int i =0;i<b.length;i++) b[i] = nums[idx++];

        mergesort(a);
        mergesort(b);
        countpairs(a , b);
        merge(a,b,nums); 
    }
    public void countpairs(int []a, int []b){
        int j = 0;
        for(int i =0;i< a.length;i++){
            while(j<b.length && (long)a[i] >(long) 2* (long)b[j] )
                j++;
            count+=j;
        }
    }
    public void merge(int []a,int[] b,int []nums){
        int i =0,j= 0, k=0;
        while(i<a.length && j<b.length){
            if(a[i]<=b[j]) {
                nums[k++]=a[i++];
            }
            else nums[k++]=b[j++];
        }
        while(i<a.length) nums[k++]=a[i++];
        while(j<b.length) nums[k++]=b[j++];
    }
}