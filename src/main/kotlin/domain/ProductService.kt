package org.example.domain

import adapter.RetrofitClient
import model.ProductDetail

class ProductService {
    private val retrofitClient = RetrofitClient()

    private val products = retrofitClient.getProducts()
    private val inventories = retrofitClient.getInventories()

    private fun calculatePrice(type: String, quantity: Int, price: Double): Double {
        return when (type) {
            "NORMAL" -> price
            "HIGH_DEMAND" -> when {
                quantity > 100 -> price
                quantity in 31..100 -> price * 1.2
                else -> price * 1.5
            }
            else -> 0.0
        }
    }

    private fun getAllProductsDetail():List<ProductDetail>{
        val productDetail: MutableList<ProductDetail> = mutableListOf()
        if (products != null) {
            for (product in products) {
                var totalQuantity= 0
                if (inventories !=null) {
                    totalQuantity = inventories.filter { it.SKU == product.SKU }.sumOf { it.quantity }
                }
                val price = calculatePrice(product.type, totalQuantity, product.price)
                val detail= ProductDetail(product.SKU, product.name, price, totalQuantity, product.image)
                productDetail.add(detail)
            }
        }
        return productDetail
    }


    fun showAllDetail(){
        val allProductsDetail = getAllProductsDetail()
        for (product in allProductsDetail){
            println("SKU: ${product.SKU}")
            println("Name: ${product.name}")
            println("Price: ${product.price}")
            println("Inventory: ${product.quantity}")
            println("Image URL: ${product.image}")
            println()
        }
    }

}