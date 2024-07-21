package org.j2os.entity;

import javax.persistence.*;

@Entity(name = "person")
@Table(name = "person")
@NamedQueries({
        @NamedQuery(name = "x1",query = "select entity from person entity where entity.name=:firstName or entity.family=:lastName"),
        @NamedQuery(name = "x2",query = "select entity from person  entity"),
})
public class Person {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private long id ;
    private String name,family;

    public long getId() {
        return id;
    }

    public Person setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public String getFamily() {
        return family;
    }

    public Person setFamily(String family) {
        this.family = family;
        return this;
    }
}
