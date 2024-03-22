package adapter

import com.google.gson.GsonBuilder
import org.example.Controller.ProductController
import model.Inventory
import model.Product
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    private val productController: ProductController

    init {
        val gson = GsonBuilder().create()
        val retrofit = Retrofit.Builder()
            .baseUrl("http://localhost:3000")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        productController = retrofit.create(ProductController::class.java)
    }

    fun getProducts(): List<Product>? {
        return productController.getAllProducts().execute().body()
    }

    fun getInventories(): List<Inventory>? {
        return productController.getAllInventories().execute().body()
    }
}