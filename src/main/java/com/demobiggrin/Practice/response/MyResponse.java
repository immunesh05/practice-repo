package com.demobiggrin.Practice.response;

public class MyResponse {
    private int id;
    private String comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "MyResponse{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                '}';
    }
}
