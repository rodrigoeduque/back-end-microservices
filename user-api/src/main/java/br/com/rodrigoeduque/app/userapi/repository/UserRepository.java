package br.com.rodrigoeduque.app.userapi.repository;

import br.com.rodrigoeduque.app.userapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> queryByNomeLike(String nome);

    User findByCpf(String cpf);

}
