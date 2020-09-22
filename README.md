# OpenFoodFacts Java Wrapper DEMO Application

## Current version 0.0.6

## Usage

Add one dependency in your POM:

```xml
<dependencies>
    <dependency>
        <groupId>pl.coderion.openfoodfacts</groupId>
        <artifactId>openfoodfacts</artifactId>
        <version>0.0.6</version>
        <classifier>java-wrapper</classifier>
    </dependency>
</dependencies>
```

Create product service class and find product by its barcode:

```javascript
ProductService productService = new DefaultProductService();
ProductResponse response = productService.findProductByCode("737628064502");
```
