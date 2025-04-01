package com.kb.common.typehandler;

import com.kb.common.enums.OrderType;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.mybatis.spring.annotation.MapperScan;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(OrderType.class)
public class OrderTypeHandler implements TypeHandler<OrderType> {
    @Override
    public void setParameter(PreparedStatement ps, int i, OrderType parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.name());
    }

    @Override
    public OrderType getResult(ResultSet rs, String columnName) throws SQLException {
        return OrderType.valueOf(rs.getString(columnName));

    }

    @Override
    public OrderType getResult(ResultSet rs, int columnIndex) throws SQLException {
        return OrderType.valueOf(rs.getString(columnIndex));
    }

    @Override
    public OrderType getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return OrderType.valueOf(cs.getString(columnIndex));
    }
}
