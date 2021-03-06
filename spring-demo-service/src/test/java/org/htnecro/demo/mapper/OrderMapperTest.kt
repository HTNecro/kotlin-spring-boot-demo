package org.htnecro.demo.mapper

import org.htnecro.demo.AbstractTest
import org.htnecro.demo.constant.OrderStatus
import org.htnecro.demo.meta.Order
import org.testng.Assert
import org.testng.annotations.Test
import java.util.*
import javax.annotation.Resource
import javax.inject.Inject

/**
 * @author Haitao.Wu (HTNecro@gmail.com)
 */
class OrderMapperTest : AbstractTest() {

    @Inject
    private lateinit var orderMapper: OrderMapper

    @Test
    fun insert() {
        val order = Order()
        order.userId = 1
        order.orderNo = "201708210001"
        order.orderTime = Calendar.getInstance().time
        order.status = OrderStatus.NEW
        orderMapper.insert(order)

        val exist = orderMapper.findById(order.id!!)
        Assert.assertNotNull(exist)
        Assert.assertEquals(exist.orderNo, "201708210001")
    }

}