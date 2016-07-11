package com.alexbt.solr;

import java.io.File;
import java.io.FileNotFoundException;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.embedded.EmbeddedSolrServer;
import org.apache.solr.core.CoreContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@Configuration
@EnableSolrRepositories(multicoreSupport = true)
public class SolrConfiguration {

	@Autowired
	private ModelSolrRepository modelRepository;
	
	@Bean
	SolrServer solrServer() throws FileNotFoundException {
		String solrHome = getClass().getClassLoader().getResource("solr-home").getPath();
		CoreContainer container = CoreContainer.createAndLoad(solrHome, new File(solrHome + "/solr.xml"));

		return new EmbeddedSolrServer(container, "alexbt");
	}

	@Bean
	public SolrTemplate solrTemplate(SolrServer solrServer) throws Exception {
		SolrTemplate solrTemplate = new SolrTemplate(solrServer());
		modelRepository.deleteAll();
		return solrTemplate;
	}
}
