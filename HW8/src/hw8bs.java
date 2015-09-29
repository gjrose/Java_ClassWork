
public class hw8bs {
	public static void main(String[] args){
		int[] reNum = new int[]{5,2,5};
		System.out.println(reMin(reNum,0));
	}
	public static int reMin(int[] array, int index) {
		  
		if (index == array.length - 1) return array[index];
		else return Math.min(array[index], reMin(array, index + 1));
		}
}
