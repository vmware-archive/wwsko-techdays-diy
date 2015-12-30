package io.pivotal.wwsko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cassandra.core.cql.CqlIdentifier;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class Bootstrapper implements CommandLineRunner {

    @Autowired
    private CassandraConfig _config;

    public void run(String... args) throws Exception {
        _config.getAdminTemplate().createTable(true, new CqlIdentifier("demo"), Model.class, new HashMap<>());
    }
}