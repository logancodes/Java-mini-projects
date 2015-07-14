class power2{
	public static void main(String [] args){
		double base =2.0;
		long n=5;
		System.out.println(base+"^"+n+" is: "+powerThree(base,n));		

	}
	static double powerThree(double x, long n){
		long checker=n%2;
		double value=0.0;
		if(n==0){
			return 1;
		}
		else if(checker==0&&n>0){
			n=n/2;
			double result=powerThree(x,n);
			return result*result;
		}
		else{
			n=n/2;
			double result=powerThree(x,n);
			value=result*result*x;
			return value;
		}
		//return value;
	}
}
