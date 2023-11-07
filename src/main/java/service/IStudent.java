package service;

import java.util.List;

public interface IStudent <E> {
    void add(E e);
    E findById(int id);
    void edit(int id,E e);
    void remove(int id);
    List<E> findAll();
    E findByStringId(String id);
}
