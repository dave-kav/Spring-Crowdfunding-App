package ie.cit.crowdfunding.repository;

import org.springframework.data.repository.CrudRepository;

import ie.cit.crowdfunding.entity.Project;

public interface ProjectRepository extends CrudRepository<Project, Integer>{

}
