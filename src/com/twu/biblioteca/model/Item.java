package com.twu.biblioteca.model;

public interface Item {
    boolean equals(String name);
    boolean getStatus();
    void setStatus(boolean status);
    void setIssuedBy(String issuedBy);
    String toString();
    String getDetailsAlongWithIssuedBy();
    String getIssuedId();
}
