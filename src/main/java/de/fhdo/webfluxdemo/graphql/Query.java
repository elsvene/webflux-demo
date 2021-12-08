package de.fhdo.webfluxdemo.graphql;

import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class Query implements GraphQLQueryResolver {
	// Dummy-Query, da GraphQL mind. eine Root-Query will
	public String test() {
		return "Test!";
	}
}
