package factory.factory;

import factory.product.AdidasClothes;
import factory.product.AdidasShoes;
import factory.product.Clothes;
import factory.product.Shoes;

public class AdidaLaborFactory implements LaborFactory {

	public Clothes productClothes() {
		return new AdidasClothes();
	}

	public Shoes productShoes() {
		return new AdidasShoes();
	}

}
