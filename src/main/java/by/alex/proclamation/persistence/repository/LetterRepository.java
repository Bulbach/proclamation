package by.alex.proclamation.persistence.repository;

import by.alex.proclamation.persistence.model.Letter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LetterRepository extends JpaRepository<Letter,Long> {
    boolean existsByEmailAndProf(String email, String prof);
}
