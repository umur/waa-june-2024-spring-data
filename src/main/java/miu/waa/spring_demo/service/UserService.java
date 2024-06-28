package miu.waa.spring_demo.service;

import miu.waa.spring_demo.entity.Address;
import miu.waa.spring_demo.entity.User;

public interface UserService extends CRUDService<User, Integer> {
    Address setUpAddress(int userId, Address address);
}
