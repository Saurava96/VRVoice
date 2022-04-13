package com.darkdemon.VRVoice.DynamoDB;


import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamoDBConfiguration {

    @Bean
    public DynamoDBMapper CreateMapper(){

        return new DynamoDBMapper(BuildAmazonDB());

    }

    private AmazonDynamoDB BuildAmazonDB(){

        BasicAWSCredentials basicCredentials = new BasicAWSCredentials("AKIA6OSGLTSYDSTVANVP","8MKuNjwc305OYfUengWzNTNv9+WSJLY6QNkMFhi4");

        AWSStaticCredentialsProvider staticCredentials = new AWSStaticCredentialsProvider(basicCredentials);

        AwsClientBuilder.EndpointConfiguration endpointConfiguration = new AwsClientBuilder.EndpointConfiguration(
                "dynamodb.us-east-1.amazonaws.com", "us-east-1"
        );

        return AmazonDynamoDBClientBuilder.standard().withEndpointConfiguration(endpointConfiguration)
                .withCredentials(staticCredentials).build();



    }

}
