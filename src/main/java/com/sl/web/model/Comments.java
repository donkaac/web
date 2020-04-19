package com.sl.web.model;

import java.sql.Timestamp;

/**
 * Created by Achi on 4/19/2020.
 */
public class Comments {
    private Integer id;
    private String name;
    private Timestamp date;
    private String comment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comments comments = (Comments) o;

        if (id != null ? !id.equals(comments.id) : comments.id != null) return false;
        if (name != null ? !name.equals(comments.name) : comments.name != null) return false;
        if (date != null ? !date.equals(comments.date) : comments.date != null) return false;
        if (comment != null ? !comment.equals(comments.comment) : comments.comment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }
}
