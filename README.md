# Problem Brief #

## SOFT8020  - Final Group Project 

####Deadline: 10th December
###Overview
  This project is worth 50% of the final grade for the module. Groups of 3 will work on a solution together.

  Crowdfunding is a phenomenon and is growing rapidly as a means of getting investment for early stage product development, including everything from video games, to Dungeons & Dragons figurines, to VR headsets, to movies, to social campaigns and anything else you could think of – tech and non-tech, tangible and intangible. 
  
   One example of a crowdfunding site is Kickstarter.com.

   You are to develop a new crowdfunding site with the following features:

* You can assume there is an existing user base – I am not interested in seeing yet another CRUD-style user management system; users are in the database already and they have a userid, name, password and credit limit.
* Users (once logged in) can add a project to be crowdfunded, giving it a name, description, picture (you may embed a youtube video if you like), a goal amount, and a time limit. Users will be able to list projects and for the ones they own, they will have an edit button (they can update the description, but nothing else); they cannot change the date or the goal amount – they can only cancel projects.
* Users can pledge money, but only an amount that will not put them over their credit limit (having added up all their active pledge amounts). Users can cancel their pledges, but once a project achieves its goal within the specified time, the pledge becomes permanent.
* Create one web page (blind link that only the admin knows – not secure, but hey!) that when loaded checks all projects and closes the ones that have reached their time limit or the funding goal.
* I am happy with a non-searchable list of projects – just list all on one page.

#####Notes

1. Essentially this project has 3 entities: user, project and pledge; a user owns projects (and conversely projects are owned by users), users make pledges against projects (a classic ternary relationship).
2. There is 10% put aside for anything that goes beyond the very basics of the spec. This can be just about anything, but do point out what you did extra in the comments when submitting. This could involve NOSQL, paging, searching and sorting, internationalization, and so on – if in doubt ask me.
3. I am not all that interested in visual styling – just make the web site well structured, readable, navigable, etc.
4. Repository classes must be tested using JUnit
5. You must validate user input
6. You must use the following without exception:
    * Spring Boot
    * Spring MVC
    * Thymeleaf
    * Spring Data JPA
    * JUnit 4 + Mockito
    * Hibernate Validator or Spring Validator
    * H2 for an embedded database

#####Marking

* 35% - Overall design, structure, use of architectural layering, clean code, algorithms
* 35% - Implementation of features
* 10% - JUnit classes / TDD test cases
* 10% - Validation with either Hibernate Validator or Spring Validator
* 10% - Additional feature(s) (functional or technological), which you must highlight when submitting

***

# To Do #
* Improve visuals on projects page
* Show page
    * Improve visuals
    * Display all project info
    * Add edit button
* User dashboard
    * list all users projects
* Add project page
* Implement security