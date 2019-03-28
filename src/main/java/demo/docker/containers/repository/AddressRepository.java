package demo.docker.containers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.docker.containers.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
