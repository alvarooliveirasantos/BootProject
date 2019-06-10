package br.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.entidades.Boot;

@Repository
public interface BootRepository extends JpaRepository<Boot, Long>{

}
