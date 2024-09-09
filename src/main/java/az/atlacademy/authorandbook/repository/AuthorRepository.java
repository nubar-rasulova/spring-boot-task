
package az.atlacademy.authorandbook.repository;
//package com.example.authorbooktask.repository;


import az.atlacademy.authorandbook.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {

}