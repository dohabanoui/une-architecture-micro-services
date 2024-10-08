package org.sdia.billingservice.feign;

import jakarta.ws.rs.QueryParam;
import org.sdia.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="PRODUCT-SERVICE")
public interface ProductItemRestClient {
    //recupere une page qui contient des produits (la pagination)
    @GetMapping(path = "/products")
    PagedModel<Product> pageProducts();

    //PagedModel<Product> pageProducts(@QueryParam(value="page") int page,@QueryParam(value = "size") int size);

    @GetMapping(path = "/products/{id}")
    Product getProductById(@PathVariable Long id);
}
