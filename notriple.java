public boolean noTriples(int[] nums) {
  for(int x=0;x<nums.length-2;x++){
      if(nums[x]==nums[x+1] && nums[x]==nums[x+2])
        return false;
  }
  
  return true;
}

//http://programmingcode4life.blogspot.my/2015/08/no-triples-interger-in-row.html