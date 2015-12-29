package io.pivotal.wwsko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cassandra.core.cql.CqlIdentifier;
import org.springframework.data.cassandra.core.CassandraAdminTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class Bootstrapper implements CommandLineRunner {

    @Autowired
    private CassandraAdminTemplate _template;

    public void run(String... args) throws Exception {
        _template.createTable(true, new CqlIdentifier("oinker"), Model.class, new HashMap<>());
    }
}