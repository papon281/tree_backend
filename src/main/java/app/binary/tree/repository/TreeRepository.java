package app.binary.tree.repository;

import app.binary.tree.db.BinaryTreeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreeRepository extends JpaRepository<BinaryTreeEntity, Long> {
}
