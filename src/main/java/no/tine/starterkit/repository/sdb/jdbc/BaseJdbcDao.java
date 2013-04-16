package no.tine.starterkit.repository.sdb.jdbc;

import java.io.Serializable;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

public abstract class BaseJdbcDao<T, ID extends Serializable> implements JdbcDao<T, ID> {


    @Value("${sdb.schema}")
    private String dbSchema;

    private SimpleJdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    @Autowired
    public void setDataSource(@Qualifier(value = "dataSourceNMHDB2P") final DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new SimpleJdbcTemplate(dataSource);
    }

    protected SimpleJdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    protected DataSource getDataSource() {
        return dataSource;
    }

    public String getDbSchema() {
        return dbSchema;
    }

    @Override
    public List<T> findAll() {
        throw new UnsupportedOperationException("findAll is currently not implemented");
    }

    @Override
    public T findByFarmId(ID farmId) {
        return null;
    }


    @Override
    @Transactional
    public T update(T entity) {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public List<T> create(List<T> entities) {
        throw new UnsupportedOperationException("Currently not implemented");
    }

    @Override
    @Transactional
    public T create(T entity) {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    @Transactional
    public void delete(T entity) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void delete(List<T> entities) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}