package br.com.rodrigoeduque.app.productapi.repository;

import br.com.rodrigoeduque.app.productapi.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
