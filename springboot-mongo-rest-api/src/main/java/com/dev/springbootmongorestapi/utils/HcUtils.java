package com.dev.springbootmongorestapi.utils;

import lombok.experimental.UtilityClass;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@UtilityClass
public class HcUtils {
    static final int MAX_LENGTH_FLATTEN_ITEMS = 1000;
    private static final String ITEMS_DELIMITER = ",";

    /**
     * Converts list of text items of an object into flatten text (comma separated).
     * <br></br>
     * Example: [ "VM02", "CB04", "GSJ7" ] --> "VM02,CB04,GSJ7"
     *
     * @param items
     * @return
     */
    public static String toFlattenItems(List<String> items) {
        if (CollectionUtils.isEmpty(items)) {
            return null;
        }
        String result = String.join(ITEMS_DELIMITER, Optional.ofNullable(items).orElse(Collections.emptyList()));
        if (result.length() > MAX_LENGTH_FLATTEN_ITEMS) {
            result = result.substring(0, MAX_LENGTH_FLATTEN_ITEMS);
            int lastCommaIndex = result.lastIndexOf(ITEMS_DELIMITER);
            if (lastCommaIndex > 0) {
                result = result.substring(0, lastCommaIndex);
            }
        }
        return result;
    }

    /**
     * Retrieves the items list from the flat items.
     * <br></br>
     * Example: "VM02,CB04,GSJ7" --> ["VM02","CB04","GSJ7"]
     *
     * @param flattenItems
     * @return
     */
    public static List<String> toItems(String flattenItems) {
        if (StringUtils.isEmpty(flattenItems)) {
            return Collections.emptyList();
        }
        return Arrays.stream(flattenItems.trim().split(ITEMS_DELIMITER))
                .map(s -> s.trim()).collect(Collectors.toList());
    }

}
