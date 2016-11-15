package ie.cit.crowdfunding.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ie.cit.crowdfunding.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>{

}
