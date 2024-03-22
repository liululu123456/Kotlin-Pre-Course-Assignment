package org.example.Controller

import model.Inventory
import model.Product
import retrofit2.Call
import retrofit2.http.GET

interface ProductController {
    @GET("/products")
    fun getAllProducts(): Call<List<Product>>
    @GET("/inventories")
    fun getAllInventories(): Call<List<Inventory>>

}