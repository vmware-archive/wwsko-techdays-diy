package io.pivotal.wwsko;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.util.Date;
import java.util.UUID;

/**
 * Created by azwickey on 12/23/15.
 */
@Table("demo")
public class Model {

    @PrimaryKey
    private String id;
    private String handle;
    private String content;
    private Date created;

    public Model() {
        this.created = new Date();
        this.id = UUID.randomUUID().toString();
    }

    public Model(String handle, String content) {
        this.handle = handle;
        this.content = content;
        this.created = new Date();
        this.id = UUID.randomUUID().toString();
    }
    public String getId() {
        return id;
    }

    public String getHandle() {
        return handle;
    }

    public String getContent() {
        return content;
    }

    public Date getCreated() {
        return created;
    }


}
