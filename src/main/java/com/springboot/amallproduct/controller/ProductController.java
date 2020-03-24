package com.springboot.amallproduct.controller;
import com.springboot.amallproduct.bean.Product;
import com.springboot.amallproduct.mapper.ProductMapper;
import com.springboot.amallproduct.web.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductMapper productMapper;

    @PostMapping("/soa/product/add")
    public Response add(Product product) {
        Integer res = productMapper.add(product);
        if (res != null) {
            return new Response("200", "ok", null);
        }
        return new Response("500", "Fail");
    }

    @GetMapping("/soa/product/{id}")
    public Response get(@PathVariable("id") Integer id) {
        Product product = productMapper.getById(id);
        if (product != null) {
            return new Response("200", "ok", product);
        }
        return new Response("500", "Fail");
    }

    @GetMapping("/soa/product/list")
    public Response list() {
        List<Product> products = productMapper.queryLists();
            return new Response("200", "ok", products);
    }

    @DeleteMapping("/soa/product/{id}")
    public Response delete(@PathVariable Integer id) {
        Integer res = productMapper.delete(id);
         return new Response("200", "ok", null);
    }

    @PostMapping("/soa/product/update")
    public Response update(Product product) {
        Integer res = productMapper.update(product);
        if (res != null) {
            return new Response("200", "ok", null);
        }
        return new Response("500", "Fail");
    }


}
