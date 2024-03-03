package com.example.demo.Repository;

import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.*;
import com.example.demo.Config.DynamoDbConfig;
import com.example.demo.Constants.AppConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

@Repository
@Slf4j
public class DynamoDbRepoImpl implements DynamoDbRepo {

    @Autowired
    DynamoDbConfig dynamoDbConfig;


    @Override
    public void createProductTable() throws Exception {
        try {
            log.info("Creating table, please wait...");
            Table table = dynamoDbConfig.getDynamoDB().createTable(AppConstants.APP_PRODUCT,
                    Arrays.asList(
                            new KeySchemaElement(AppConstants.ID, KeyType.HASH),
                            new KeySchemaElement(AppConstants.NAME, KeyType.RANGE)
                    ),
                    Arrays.asList(
                            new AttributeDefinition(AppConstants.ID , ScalarAttributeType.S),
                            new AttributeDefinition(AppConstants.NAME, ScalarAttributeType.S)
                    ),
                    new ProvisionedThroughput(10L, 10L));
            table.waitForActive();
            log.info("Table created successfully, status : {}", table.getDescription().getTableStatus());
        } catch (Exception exception) {
            log.error("Exception occurred while creating table : {}", exception.getMessage());
            throw new Exception(exception.getMessage());
        }
    }

    @Override
    public void deleteProductTable(String tableName) throws Exception {
        try {
            Table table = dynamoDbConfig.getDynamoDB().getTable(tableName);
            table.delete();
            table.waitForDelete();
            log.info("Table deleted successfully!!");
        } catch (Exception exception) {
            log.error("Exception occurred while deleting table : {}", exception.getMessage());
            throw new Exception(exception.getMessage());
        }
    }
}
