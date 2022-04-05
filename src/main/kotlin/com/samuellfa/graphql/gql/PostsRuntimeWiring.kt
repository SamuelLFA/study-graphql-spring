package com.samuellfa.graphql.gql

import graphql.schema.GraphQLCodeRegistry
import graphql.schema.idl.RuntimeWiring
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.graphql.execution.RuntimeWiringConfigurer
import org.springframework.stereotype.Component

@Component
class PostsRuntimeWiring : RuntimeWiringConfigurer {
    @Autowired
    private lateinit var dataFetchers: DataFetchers

    override fun configure(builder: RuntimeWiring.Builder) {
        builder
            .codeRegistry(buildCodeRegistry())/*
                  .type("Query",
                          typeWiring -> typeWiring
                                  .dataFetcher("allPosts", postsDataFetchers.allPosts())
                                  .dataFetcher("postById", postsDataFetchers.postById())
                  )
                  .type("Mutation",
                          typeWiring -> typeWiring
                                  .dataFetcher("createPost", postsDataFetchers.createPost())
                                  .dataFetcher("addComment", postsDataFetchers.addComment())
                  )
                  .type("Post", typeWiring -> typeWiring
                          .dataFetcher("author", postsDataFetchers.authorOfPost())
                          .dataFetcher("comments", postsDataFetchers.commentsOfPost())
                  )
                  .type("Subscription", typeWiring -> typeWiring
                          .dataFetcher("commentAddded", postsDataFetchers.commentAdded())
                  )*/
//            .directive("uppercase", UpperCaseDirectiveWiring())
            .build()
    }

    private fun buildCodeRegistry(): GraphQLCodeRegistry {
        return GraphQLCodeRegistry.newCodeRegistry()
            .dataFetchers(
                "Query", mapOf(
                    Pair("findProduct", dataFetchers.findByName()),
                )
            )
            .dataFetchers(
                "Mutation", mapOf(
                    Pair("createProduct", dataFetchers.createPost())
                )
            ) //.typeResolver()
            //.fieldVisibility()
            // Spring has set the default property data fetching.
            //.defaultDataFetcher(environment -> PropertyDataFetcher.fetching(environment.getFieldDefinition().getName()))
            .build()
    }
}