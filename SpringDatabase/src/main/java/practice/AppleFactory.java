package practice;

public class AppleFactory {

	AppleConfig config;
	
	public void setConfig (AppleConfig config) {
		this.config = config;
	}
	
	public Apple getApple() {
		return new RealApple(config);
	}
	
	class RealApple implements Apple {
		
		private String color;
		private int price;
		
		
		RealApple(AppleConfig config){
			this.color = config.getColor();
			this.price = config.getPrice();
		}
		
		@Override
		public String getColor() {			
			return color;
		}
		
		@Override
		public int getPrice() {			
			return price;
		}
		
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return super.toString();
		}
	}
	
	
}
