package io.pivotal.wwsko;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.core.CassandraAdminTemplate;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

/**
 * Created by azwickey on 12/23/15.
 */
@EnableCassandraRepositories
@Configuration
public class CassandraConfig extends AbstractCassandraConfiguration {

    @Value("${spring.data.cassandra.keyspace-name}")
    private String _keyspace;

    public String getKeyspaceName() {
        return _keyspace;
    }

    @Bean
    public CassandraAdminTemplate getCassandraAdminTemplate() throws Exception{
        return new CassandraAdminTemplate(session().getObject(), cassandraConverter());
    }
}
