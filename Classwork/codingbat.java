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

	public static void main(String[] args){
		// System.out.println(groupSum(0,num,10));
		// System.out.println(groupSum(0,num,9));
		// System.out.println(groupSum(0,num,14));
		int[] num3 = {2,5,10,4};
		//System.out.println(splitArray(num2));
		//System.out.println(splitArray(num3));	
		// System.out.println(groupSum6(0, num3, 8));	
		// System.out.println(groupSum6(0, num3, 9));	
		System.out.println(groupSum5(0, num3, 19));	
		System.out.println(groupSum5(0, num3, 12));

	}
}