class power1{
	public static void main(String[] args){
		double base=2.0;
		long n= 4;
		System.out.println(base+"^"+n+" is: "+powerTwo(base,n));		
	}
	static double powerTwo(double x, long n){
		if (n < 0) {
			throw new IllegalArgumentException("Illegal Power Argument");
        	}
		if(n==0){
			return 1;
		}
		else{
			return x*powerTwo(x,n-1);
		}
	}
}
