package com.trendmciro.course.unittesting.springrest.dao;


import com.trendmciro.course.unittesting.springrest.entity.Customer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Autowired
  private NamedParameterJdbcTemplate namedJdbcTemplate;

  /**
   * get customer by id
   */
  public Customer get(Long id) {
    String sql = "SELECT * FROM customer WHERE id=:id";
    MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
    mapSqlParameterSource.addValue("id", id);

    return namedJdbcTemplate.queryForObject(sql, mapSqlParameterSource,
        new BeanPropertyRowMapper<>(Customer.class));
  }

  public Long create(Customer customer) {
    String sql = "INSERT INTO customer(first_name, last_name) VALUES(:firstName, :lastName)";
    SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(customer);

    KeyHolder keyHolder = new GeneratedKeyHolder();
    namedJdbcTemplate.update(sql, sqlParameterSource, keyHolder);
    Long id = keyHolder.getKey().longValue();

    return id;
  }

  public int update(Customer customer) {
    String sql = "UPDATE customer SET first_name=:firstName, last_name=:lastName WHERE id=:id";
    SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(customer);

    int update = namedJdbcTemplate.update(sql, sqlParameterSource);
    return update;
  }

  /**
   * get all customers
   */
  public List<Customer> list() {
    String sql = "select * from customer";
    List<Customer> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Customer.class));
    return query;
  }

}
