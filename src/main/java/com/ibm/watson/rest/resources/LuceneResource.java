package com.ibm.watson.rest.resources;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.lucene.document.Document;

import com.ibm.watson.DocumentAndScore;
import com.ibm.watson.QueryLucene;
import com.ibm.watson.rest.LuceneResponse;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("lookup")
public class LuceneResource {
	
	private static Log log = LogFactory.getLog(LuceneResource.class);
	@Context ServletContext servletContext;
	@QueryParam(value = "q") String query;
	@QueryParam(value = "type") String semanticType;

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<LuceneResponse> getIt() {
    	QueryLucene queryLucene = (QueryLucene) servletContext.getAttribute("lucene");
    	List<DocumentAndScore> results = (semanticType == null) ? queryLucene.doQuery(query) : queryLucene.doQuery(query, semanticType);
    	log.info("Got " + results.size() + " results");
    	//JsonArrayBuilder value = Json.createArrayBuilder();
    	List<LuceneResponse> responses = new ArrayList<>();
		for (DocumentAndScore docAndScore : results) {
			Document doc = docAndScore.getDocument();
			float score = docAndScore.getScore();
	    	LuceneResponse response = new LuceneResponse(doc, score);
	    	responses.add(response);
			/*
			JsonObject obj = 
        			Json.createObjectBuilder()
        			.add("code", doc.get("code"))
        			.add("name", doc.get("name"))
        			.build();
			value.add(obj);
			*/
		}

        return responses;
    }
}