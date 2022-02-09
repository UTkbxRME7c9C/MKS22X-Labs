public class codingbat{
	public static boolean groupSum(int start, int[] nums, int target) {
		if (start>=nums.length) return (target == 0);
		return (groupSum(start+1, nums, target) || groupSum(start+1, nums, target-nums[start]));
	  }	  
	public static void main(String[] args){
		int[] num = {2,4,8};
		System.out.println(groupSum(0,num,10));
		System.out.println(groupSum(0,num,9));
		System.out.println(groupSum(0,num,14));
		
	}
}