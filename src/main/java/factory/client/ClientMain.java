package factory.client;

import factory.factory.AdidaLaborFactory;
import factory.factory.LaborFactory;
import factory.product.Clothes;

public class ClientMain {

	public static void main(String[] args) {
      LaborFactory adidasLaborFactory = new AdidaLaborFactory();
      Clothes adidasClothes = adidasLaborFactory.productClothes();
      adidasClothes.wear();
	}

}
