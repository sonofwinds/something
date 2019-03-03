package annotation;

import annotation.FruitColor.Color;

public class Apple {
	@FruitName("红富士苹果")
	private String appleName;
	@FruitColor(fruitColor = Color.RED)
	private String appleColor;
	@FruitProvider(address="焦作",id=111111,name="望京大厦")
	private String fruitProvider;
	public String getAppleName() {
		return appleName;
	}
	public void setAppleName(String appleName) {
		this.appleName = appleName;
	}
	public String getAppleColor() {
		return appleColor;
	}
	public void setAppleColor(String appleColor) {
		this.appleColor = appleColor;
	}
	public String getFruitProvider() {
		return fruitProvider;
	}
	public void setFruitProvider(String fruitProvider) {
		this.fruitProvider = fruitProvider;
	}
	private void setN() {
		
	}
}
