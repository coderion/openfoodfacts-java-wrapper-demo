# OpenFoodFacts Java Wrapper DEMO Application

## Usage

Add one dependency in your POM:

```xml
<dependencies>
    <dependency>
        <groupId>pl.coderion.openfoodfacts</groupId>
        <artifactId>openfoodfacts</artifactId>
        <version>0.0.1-SNAPSHOT</version>
        <classifier>java-wrapper</classifier>
    </dependency>
</dependencies>
```

Create product service class and find product by its barcode:

```javascript
ProductService productService = new DefaultProductService();
ProductResponse response = productService.findProductByCode("737628064502");
```
