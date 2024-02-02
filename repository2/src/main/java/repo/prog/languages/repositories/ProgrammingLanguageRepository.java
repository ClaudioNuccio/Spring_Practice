package repo.prog.languages.repositories;

import repo.prog.languages.entities.ProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage,Long> {

}
