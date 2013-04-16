package no.tine.starterkit.repository.sdb.jdbc;

import java.io.Serializable;

import no.tine.starterkit.repository.GenericRepository;

public interface JdbcDao<T, ID extends Serializable> extends GenericRepository<T, ID> {


    T findByFarmId(ID farmId);

}