package cz.jty.restApi_advanced.controller;

import cz.jty.restApi_advanced.model.dto.ProductDTO;
import cz.jty.restApi_advanced.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "RestApi ProductApp")
@RestController
@CrossOrigin // v případě že se připojuje něco z jiného portu - například frontend, který běží na portu 3001 volá backend na portu 8080
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService=productService;
    }

    @GetMapping("/product/{id}")
    @Operation(summary = "get product by id", description = "path /product/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable ("id") long id){
        try {
            return ResponseEntity.ok(productService.getProductById(id));
        }catch (IllegalArgumentException illegalArgumentException){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @Operation(summary = "get all products and sort them asc by id or any other value", description = "default sorting is by id, optinal sorting by name path /products?sortBy=name ")
    @GetMapping(value = "/products") // kdyz ma byt sortBy nepovinny tak nemsmi byt uveden v hlavicce mappingu. Jinak kdyby byl povinny tak by vypadal takto: @GetMapping(value = "/products",params = "sortBy")
    public ResponseEntity<List<ProductDTO>> getAllProducts(@RequestParam (name = "sortBy", defaultValue = "id") String sortBy){ // @RequestParam udava, ze parametr neni povinny a v pripade nezadani se pouzije defaultni hodnota
        try {
            List<ProductDTO> productsDTO = productService.getAllProducts(sortBy);
            return ResponseEntity.ok(productsDTO);
        }catch (IllegalArgumentException illegalArgumentException){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Operation(summary = "update product with given id")
    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProductById(@PathVariable ("id") long id, @RequestBody ProductDTO productDTO){
        try {
            productService.updateProductById(id,productDTO);
            return ResponseEntity.ok("Product has been updated");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Product hasnt been updated");
        }
    }

    @Operation(summary = "delete product by id")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable("id") long id){
        try {
            productService.deleteProductById(id);
            return ResponseEntity.ok("Product was deleted");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product wasnt found");
        }

    }

    @Operation(summary = "new product", description = "requested parameters - String image, String name, Decimal price / id is generated byt db")
    @PostMapping("/product")
    public ResponseEntity<String> createProduct(@Valid @RequestBody ProductDTO productDTO){ // @Valid znamena, ze se bude validovat dle zadanych anotaci na tride ProductDTO, @RequestBody slouží k namapování příchozích dat na objekt
        try {
            productService.createProduct(productDTO);
            return ResponseEntity.ok("Product was saved");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Saving error");
        }
    }

}
