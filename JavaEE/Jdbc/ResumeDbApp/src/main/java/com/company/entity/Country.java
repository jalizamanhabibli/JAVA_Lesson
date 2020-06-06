package com.company.entity;

public class Country {
    private Integer id;

    private String name;

    private String nationality;

    public Country() {}

    public Country(int id, String name, String nationality) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
    }

    public int getId() {
        return this.id.intValue();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return this.nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Country other = (Country)obj;
        if (this.id != other.id)
            return false;
        return true;
    }

    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + this.id;
        return hash;
    }

    public String toString() {
        if (this.name == null)
            return this.nationality;
        if (this.nationality == null)
            return this.name;
        return this.name + "(" + this.nationality + ")";
    }
}
