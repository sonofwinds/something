package factory.factory;

import factory.product.Clothes;
import factory.product.Shoes;

public interface LaborFactory {
	Clothes productClothes();

	Shoes productShoes();
}
