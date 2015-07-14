class testpower{
	public static void main(String [] args){
	double x=3.15;
	long n=17;
	System.out.println(x+"^"+n+" is: "+powerOne(x,n));
	}
	static double powerOne(double x, long n){
		if(n>=0){
			if(n==0){
				x=1;
			}
			
			else{
				double result=x;
				for(int i=1;i<n;i++){
					x*=result;
				}
			}
		}
		else{
			System.exit(-1);
		}
			
		return x;
	}
}
