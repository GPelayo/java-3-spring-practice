package com.grocerific.orderitem;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class OrderItemMapper implements RowMapper<OrderItem>{

	@Override
	public OrderItem mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
		OrderItem order = new OrderItem();
		order.setOrderId(resultSet.getInt("order_id"));
		order.setLineNumber(resultSet.getInt("line_number"));
		order.setProductId(resultSet.getInt("product_id"));
		order.setQuantity(resultSet.getInt("quantity"));
		order.setUnitPrice(resultSet.getFloat("unit_price"));
		return order;
	}
}