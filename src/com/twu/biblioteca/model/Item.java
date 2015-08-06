package com.twu.biblioteca.model;

public interface Item {
    boolean equals(String name);
    String toString();
    boolean getStatus();
    String getName();
    void setStatus(boolean status);
    void setIssuedBy(String issuedBy);
    String getDetailsAlongWithIssuedBy();
    String getIssuedId();
}
