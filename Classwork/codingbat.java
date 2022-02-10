public class codingbat{
	public static boolean groupSum(int start, int[] nums, int target) {
		if (start>=nums.length) return (target == 0);
		return (groupSum(start+1, nums, target) || groupSum(start+1, nums, target-nums[start]));
	}
	
	public static boolean splitArray(int[] nums){
		return splitArray(nums, 0, 0);
	}

	public static boolean splitArray(int[] nums, int start, int total ){
		if(start>= nums.length) return(total == 0);
		return (splitArray(nums,start+1,total+nums[start])||splitArray(nums, start+1, total-nums[start]));
	}
	public static boolean groupSum6(int start,int[] nums, int target){
		if(start>= nums.length) return target==0;
		if (nums[start] == 6) return (groupSum6(start+1, nums, target-6));
		return (groupSum6(start+1, nums, target) || groupSum6(start+1, nums, target-nums[start]));
	}
	public static boolean groupSum5(int start, int[] nums, int target){
		if(start>= nums.length) return target==0;
		if (nums[start]%5==0) return groupSum5(start+1, nums, (target)-nums[start]);
		if ((start>0 && nums[start] == 1) && nums[start-1]%5 == 0) return groupSum5(start+1, nums, target);
		return (groupSum5(start+1, nums, target) || groupSum5(start+1, nums, target-nums[start]));
	}
	public static boolean groupNoAdj(int start, int[] nums, int target){
		if(start>= nums.length) return target==0;
		return (groupNoAdj(start+1, nums, target) || groupNoAdj(start+2, nums, target-nums[start]));
	}

	public static void main(String[] args){
		int[] num3 = {2,5,10,4};	
		System.out.println(groupNoAdj(0, num3, 14));	
		System.out.println(groupNoAdj(0, num3, 12));

	}
}