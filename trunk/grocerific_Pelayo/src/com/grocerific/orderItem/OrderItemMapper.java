package com.grocerific.orderItem;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class OrderItemMapper implements RowMapper<OrderItem>{

	@Override
	public OrderItem mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
		OrderItem Order = new OrderItem();
		Order.setId(resultSet.getInt("id"));
		Order.setOrderDate(resultSet.getString("order_date"));
		Order.setTotal(resultSet.getFloat("total"));
		return Order;
	}
}
