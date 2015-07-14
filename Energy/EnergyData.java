public class EnergyData {
	//Attributes
	private String region;
	
	private double perCapita1990;
	private double perCapita2008;
	
	private int population1990;
	private int population2008;
	
	private double total1990;
	private double total2008;
	//constructor that initializes the value for energy data
	public EnergyData() {
		region = "";
		perCapita1990 = 0;
		perCapita2008 = 0;
		population1990 = 0;
		population2008 = 0;
		total1990 = 0;
		total2008 = 0;
	}
	//behaviour to get the region
	public String getRegion() {
		return region;
	}
	//behaviour to set the region
	public void setRegion(String region) {
		this.region = region;
	}
	
	
	
	//behaviour to return per capita 1990
	public double getPerCapita1990() {
		return perCapita1990;
	}
	//behaviour to set per capita 1990
	public void setPerCapita1990(double perCapita1990) {
		this.perCapita1990 = perCapita1990;
	}
	//behaviour to get per capita 2008
	public double getPerCapita2008() {
		return perCapita2008;
	}
	//behaviour to set per capita 2008
	public void setPerCapita2008(double perCapita2008) {
		this.perCapita2008 = perCapita2008;
	}
	//behaviour to get per capita growth percent
	public double getPerCapitaGrowthPercent() {
		return ((perCapita2008 - perCapita1990)/perCapita1990)*100.0;
	}
	
	
	//behaviour to get population 1990
	public int getPopulation1990() {
		return population1990;
	}
	//behaviour to set population 1990
	public void setPopulation1990(int pop) {
		this.population1990 = pop;
	}
	//behaviour to get population 2008
	public int getPopulation2008() {
		return population2008;
	}
	//behaviour to set population 2008
	public void setPopulation2008(int pop) {
		this.population2008 = pop;
	}
	//behaviour to get population growth percent
	public double getPopulationGrowthPercent() {
		return ((population2008 - population1990)/population1990)*100.0;
	}
	
	
	//behaviour to get total 1990
	public double getTotal1990() {
		return total1990;
	}
	//behaviour to set total 1990
	public void setTotal1990(double total1990) {
		this.total1990 = total1990;
	}
	//behaviour to get total 2008
	public double getTotal2008() {
		return total2008;
	}
	//behaviour to set total 2008
	public void setTotal2008(double total2008) {
		this.total2008 = total2008;
	}
	//behaviour to get total growth percent
	public double getTotalGrowthPercent() {
		return ((total2008 - total1990)/total1990)*100.0;
	}
	

}
