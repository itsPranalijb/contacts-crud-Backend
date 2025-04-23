//You can then use this repository to save, update, fetch, or delete contacts.

package com.crm.crm.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ContactRepository extends JpaRepository<Contact, Long> {}


