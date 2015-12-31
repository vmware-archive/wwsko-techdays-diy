package io.pivotal.wwsko;

import com.datastax.driver.core.Cluster;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cassandra.config.CassandraCqlClusterFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.core.CassandraAdminOperations;
import org.springframework.data.cassandra.core.CassandraAdminTemplate;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.stereotype.Component;

/**
 * Created by azwickey on 12/23/15.
 */
@EnableCassandraRepositories
@Configuration
public class CassandraConfig extends AbstractCassandraConfiguration {

    @Value("${spring.data.cassandra.keyspace-name}")
    private String _keyspace;

    @Value("${spring.data.cassandra.contact-points}")
    private String _cp;

    public String getKeyspaceName() {
        return _keyspace;
    }

    @Override
    @Bean
    public CassandraCqlClusterFactoryBean cluster() {
        CassandraCqlClusterFactoryBean bean = new CassandraCqlClusterFactoryBean();
        bean.setAuthProvider(this.getAuthProvider());
        bean.setCompressionType(this.getCompressionType());
        bean.setContactPoints(_cp);
        bean.setKeyspaceCreations(this.getKeyspaceCreations());
        bean.setKeyspaceDrops(this.getKeyspaceDrops());
        bean.setLoadBalancingPolicy(this.getLoadBalancingPolicy());
        bean.setMetricsEnabled(this.getMetricsEnabled());
        bean.setPort(this.getPort());
        bean.setReconnectionPolicy(this.getReconnectionPolicy());
        bean.setPoolingOptions(this.getPoolingOptions());
        bean.setRetryPolicy(this.getRetryPolicy());
        bean.setShutdownScripts(this.getShutdownScripts());
        bean.setSocketOptions(this.getSocketOptions());
        bean.setStartupScripts(this.getStartupScripts());
        return bean;
    }

    @Bean
    public CassandraAdminTemplate getAdminTemplate() throws Exception {
        return new CassandraAdminTemplate(session().getObject(), cassandraConverter());
    }

}
