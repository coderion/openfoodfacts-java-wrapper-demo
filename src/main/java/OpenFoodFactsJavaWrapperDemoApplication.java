import pl.coderion.openfoodfacts.openfoodfactsjavawrapper.model.ProductResponse;
import pl.coderion.openfoodfacts.openfoodfactsjavawrapper.service.DefaultProductService;
import pl.coderion.openfoodfacts.openfoodfactsjavawrapper.service.ProductService;

import java.util.Optional;

public class OpenFoodFactsJavaWrapperDemoApplication {

    public static void main(String[] args) {
        ProductService productService = new DefaultProductService();
        Optional<ProductResponse> productResponse = productService.findProductByCode("737628064502");

        if (productResponse.isPresent()) {
            System.out.println(productResponse.get().getProduct().getProductName());
        }
    }
}
