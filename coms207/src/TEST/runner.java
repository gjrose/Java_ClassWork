package TEST;

public class runner {
	public static void main(String[] args){
		int n = 4;
		for(int i =0; i<=n; i++){
			if(i == 0 || i == n){
			System.out.println("****");
			}
			else if(i >0 && i <n-1){
				System.out.println("*  *");
			}
		}
	}
}
