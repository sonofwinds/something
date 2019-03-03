package factory.factory;

import factory.product.Clothes;
import factory.product.NikeClothes;
import factory.product.NikeShoes;
import factory.product.Shoes;

public class NikeLaborFactory implements LaborFactory {

	public Clothes productClothes() {
		return new NikeClothes();
	}

	public Shoes productShoes() {
		return new NikeShoes();
	}

}
