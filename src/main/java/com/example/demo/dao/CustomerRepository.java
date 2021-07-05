package com.example.demo.dao;

import com.example.demo.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//CrudRepository에 선언된 메서드들의 바디를 구현하지 않았는데 어떻게 사용이 가능한거지..? -> @NoRepositoryBean 때문인거 같기도함... 찾아보자!
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    List<Customer> findByName(String name); //springboot가 자동으로 메서드 이름 분석해서 name으로 객체 찾는 메서드 수행 가능하게 해줌
    List<Customer> findByNameLike(String name); //Like 검색 수행함

    //JPQL 사용, ?1 : 첫 번째 param, ?2 : 두 번째 param
    @Query("from Customer where name = ?1 and primaryContact = ?2")
    List<Customer> findVipList(String name, int primaryContact);

    //nativeQuery 사용
    @Query(value="select * from Customer where name = ?1 and primary_contact = ?2", nativeQuery = true)
    List<Customer> findVipList2(String name, int primaryContact);
}
