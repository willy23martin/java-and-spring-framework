package openweb.wmc.repositories;

import org.springframework.data.repository.CrudRepository;

import openweb.wmc.entities.EntityA;

public interface IRepositoryA extends CrudRepository<EntityA, Long> {

}
