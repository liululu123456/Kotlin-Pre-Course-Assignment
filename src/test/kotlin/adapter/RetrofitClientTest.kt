package adapter

import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.Assertions


@ExtendWith(MockKExtension::class)
class RetrofitClientTest{

    @Test
    fun get_Product_data_From_mock_json_server(){

        val retrofitClient = RetrofitClient()
        val result = retrofitClient.getProducts()

        Assertions.assertEquals(5, result!!.size)
    }

    @Test
    fun get_Inventory_data_From_mock_json_server(){

        val retrofitClient = RetrofitClient()
        val result = retrofitClient.getInventories()

        Assertions.assertEquals(8, result!!.size)
    }
}