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
		if (nums[start] == 6) return (groupSum6(start+1, nums, target-6) || groupSum6(start+1, nums, (target-6)-nums[start]));
		return (groupSum6(start+1, nums, target) || groupSum6(start+1, nums, target-nums[start]));
	}

	public static void main(String[] args){
		// int[] num = {2,4,8};
		// System.out.println(groupSum(0,num,10));
		// System.out.println(groupSum(0,num,9));
		// System.out.println(groupSum(0,num,14));
		int[] num2 = {2,3};
		int[] num3 = {5,2,3};
		System.out.println(splitArray(num2));
		System.out.println(splitArray(num3));		
	}
}