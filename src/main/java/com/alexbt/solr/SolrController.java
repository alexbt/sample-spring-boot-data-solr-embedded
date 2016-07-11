package com.alexbt.solr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.search.MatchAllDocsQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/solr")
public class SolrController {

	@Autowired
	private ModelSolrRepository modelRepository;
	
	@Autowired
	private SolrTemplate solrTemplate;

	@RequestMapping(value = "/repo", method = RequestMethod.GET)
	public Iterable<Model> findByRepo() throws IOException {
		return modelRepository.findAll();
	}
	
	@RequestMapping(value = "/template", method = RequestMethod.GET)
	public Iterable<Model> findByTemplate() throws IOException {
		Query q = new SimpleQuery("*:*");
		return solrTemplate.queryForPage(q, Model.class).getContent();
	}

	@RequestMapping(value = "/repo/{value}", method = RequestMethod.GET)
	public void saveByRepo(@PathVariable String value) {
		Model model = new Model();
		model.setValue(value);
		model.setId(System.currentTimeMillis());
		modelRepository.save(model);
	}
	
	@RequestMapping(value = "/template/{value}", method = RequestMethod.GET)
	public void saveByTemplate(@PathVariable String value) {
		Model model = new Model();
		model.setValue(value);
		model.setId(System.currentTimeMillis());
		solrTemplate.saveBean(model);
		solrTemplate.commit();
	}
	
	
}
