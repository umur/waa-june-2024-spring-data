package miu.waa.spring_demo.service;

import miu.waa.spring_demo.entity.Address;

import java.util.List;

public interface CRUDService<T, ID> {
    List<T> getAll();
    T getById(ID id);
    default T create(T t) { throw new RuntimeException("Method NOT implemented!"); }
    T update(T t);
    void deleteById(ID id);
}
