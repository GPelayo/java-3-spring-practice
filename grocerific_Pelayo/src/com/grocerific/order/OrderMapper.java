package com.grocerific.order;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class OrderMapper implements RowMapper<Order>{

	@Override
	public Order mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
		Order Order = new Order();
		Order.setId(resultSet.getInt("id"));
		Order.setOrderDate(resultSet.getString("order_date"));
		Order.setTotal(resultSet.getFloat("total"));
		return Order;
	}
}
