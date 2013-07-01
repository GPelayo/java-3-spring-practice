package com.grocerific.orderItem;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class OrderItemJDBC implements OrderItemDAO{
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource ds) {
		dataSource = ds;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void createNewOrder(String orderDate, float total) {
		String insertIntoOrders = "Insert into orders (order_date, total) values (?, ?)";
		jdbcTemplate.update(insertIntoOrders, orderDate, total);
	}

	public OrderItem getOrderById(Integer id) {
		String selectOrderById = String.format("Select * from orders where id = ?", id);
		OrderItem order = jdbcTemplate.queryForObject(selectOrderById, new Object[]{id}, new OrderItemMapper());
		return order;
	}

	public List<OrderItem> listOrders() {
		String selectAllOrders = "SELECT * from orders ORDER BY order_date DESC";
		List<OrderItem> orders = jdbcTemplate.query(selectAllOrders, new OrderItemMapper());
		return orders;
	}

	public void delete(Integer id) {
		String deleteOrder = "Delete from orders where id = ?";
		jdbcTemplate.update(deleteOrder, id);
	}

	@Override
	public void update(OrderItem order) {
		String updateOrder = String.format("UPDATE orders SET order_date=?, total=?  where id=?");
		jdbcTemplate.update(updateOrder, order.getOrderDate(), order.getTotal(), order.getId());
	}
}
