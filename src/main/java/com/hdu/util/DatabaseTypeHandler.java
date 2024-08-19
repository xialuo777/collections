package com.hdu.util;

import com.hdu.entity.issues.DataBaseType;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@MappedTypes(DataBaseType.class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class DatabaseTypeHandler extends BaseTypeHandler<DataBaseType> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, DataBaseType o, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, o.toString());
    }
    @Override
    public DataBaseType getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        String name = resultSet.getString(columnName);
        return name != null? DataBaseType.valueOf(name): null;
    }

    @Override
    public DataBaseType getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String name = resultSet.getString(i);
        return name != null? DataBaseType.valueOf(name): null;
    }


    @Override
    public DataBaseType getNullableResult(CallableStatement callableStatement, int columIndex) throws SQLException {
        String name = callableStatement.getString(columIndex);
        return name != null? DataBaseType.valueOf(name): null;
    }
}
