package io.pivotal.wwsko;

import org.springframework.data.cassandra.repository.CassandraRepository;

/**
 * Created by azwickey on 12/23/15.
 */
public interface DataRepository extends CassandraRepository<Model> {

}
