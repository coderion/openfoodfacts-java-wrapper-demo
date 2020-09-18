import pl.coderion.openfoodfacts.openfoodfactsjavawrapper.model.Ingredient;
import pl.coderion.openfoodfacts.openfoodfactsjavawrapper.model.Nutriments;
import pl.coderion.openfoodfacts.openfoodfactsjavawrapper.model.Product;
import pl.coderion.openfoodfacts.openfoodfactsjavawrapper.model.ProductResponse;
import pl.coderion.openfoodfacts.openfoodfactsjavawrapper.service.DefaultProductService;
import pl.coderion.openfoodfacts.openfoodfactsjavawrapper.service.ProductService;

public class OpenFoodFactsJavaWrapperDemoApplication {

    public static void main(String[] args) {
        ProductService productService = new DefaultProductService();
        ProductResponse response = productService.findProductByCode("737628064502");

        StringBuilder sb = new StringBuilder()
                .append(String.format("Status: %s%n", response.getStatusVerbose()));

        if (response.isStatus()) {
            Product product = response.getProduct();

            sb.append(String.format("Code: %s%n", response.getCode()))
                    .append(String.format("Product name: %s%n", product.getProductName()))
                    .append(String.format("Ingredients:%n"));

            for (Ingredient ingredient : product.getIngredients()) {
                sb.append(String.format(" * %s%n", ingredient.getText()));
            }

            Nutriments nutriments = product.getNutriments();

            sb.append(String.format("Nutriments:%n"))
                    .append(String.format(" * Energy %s %s%n", nutriments.getEnergy(), nutriments.getEnergyUnit()))
                    .append(String.format(" * Calcium %s%s%n", nutriments.getCalcium(), nutriments.getCalciumUnit()))
                    .append(String.format(" * Carbohydrates %s%s%n", nutriments.getCarbohydrates(), nutriments.getCarbohydratesUnit()))
                    .append(String.format(" * Cholesterol %s%s%n", nutriments.getCholesterol(), nutriments.getCholesterolUnit()))
                    .append(String.format(" * Fat %s%s%n", nutriments.getFat(), nutriments.getFatUnit()))
                    .append(String.format(" * Saturated fat %s%s%n", nutriments.getSaturatedFat(), nutriments.getSaturatedFatUnit()))
                    .append(String.format(" * Fiber %s%s%n", nutriments.getFiber(), nutriments.getFiberUnit()))
                    .append(String.format(" * Iron %s%s%n", nutriments.getIron(), nutriments.getIronValue()))
                    .append(String.format(" * Proteins %s%s%n", nutriments.getProteins(), nutriments.getProteinsUnit()))
                    .append(String.format(" * Salt %s%s%n", nutriments.getSalt(), nutriments.getSaltUnit()))
                    .append(String.format(" * Sodium %s%s%n", nutriments.getSodium(), nutriments.getSodiumUnit()))
                    .append(String.format(" * Sugars %s%s%n", nutriments.getSugars(), nutriments.getSugarsUnit()));

            sb.append(String.format("Selected image: %s%n", product.getSelectedImages().getFront().getDisplay().getUrl()));
        }

        System.out.println(sb.toString());
    }
}
