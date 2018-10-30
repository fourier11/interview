package javapractice;

public class OnlyNum {
	
	//我自己的答案
	public static int onlyNum(int[] a){
		int temp;
		int result=99;
		boolean flag=false;
		for(int i=0;i<a.length;i++){
			temp=a[i];
			for(int j=0;j<a.length;j++){
				if(j==i){
					continue;
				}
				if(a[i]==a[j]){
					break;
				}
				if(j==a.length-1){
					result=temp;
					flag=true;
				}
			}
			if(i==a.length-1&&!flag){
				result=a[i];
			}
		}
		return result;
	}
	
	
	//更好的优化结果
	
	
	
	public static void main(String[] args) {
		int[] a={1,1,2,2,3,5,5};

		System.out.println(onlyNum(a)+"");
	}
	

}
