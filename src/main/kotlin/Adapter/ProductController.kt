package org.example.Controller

import org.example.Model.Inventory
import org.example.Model.Product
import retrofit2.http.GET

interface ProductController {
    @GET("/products")
    fun getAllProducts(): List<Product>
    @GET("/inventories")
    fun getAllInventories(): List<Inventory>

}