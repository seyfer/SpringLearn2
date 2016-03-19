package seed.seyfer.spring.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by seyfer on 3/14/16.
 */
public interface SkillRepository extends CrudRepository<Skill, Long> {
    public List<Skill> findByLabel(String label);
}
