package com.alexbt.solr;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface ModelSolrRepository extends PagingAndSortingRepository<Model, String> {
}     