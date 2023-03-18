package com.dev.springbootgraphqlrestapi.batchloaders;

import org.dataloader.BatchLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class CustomBatchLoader implements BatchLoader<String, Object> {
    @Override
    public CompletionStage<List<Object>> load(List<String> keys) {
        // Load data for the given keys and return a CompletionStage with the loaded values
        return CompletableFuture.supplyAsync(() -> {
            List<Object> values = new ArrayList<>();
            for (String key : keys) {
                // Load data for the current key and add it to the list of values
                Object value = loadDataForKey(key);
                values.add(value);
            }
            return values;
        });
    }

    // A helper method to load data for a given key
    private Object loadDataForKey(String key) {
        // Load data for the given key from some data source
        // For example, you might load data from a database or a REST API
        return "Data for key " + key;
    }
}
