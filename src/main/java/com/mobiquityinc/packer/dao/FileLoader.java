package com.mobiquityinc.packer.dao;

import com.mobiquityinc.packer.domain.Item;
import com.mobiquityinc.packer.domain.Package;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 */
public class FileLoader implements Loader{

    private final String filePath;

    public FileLoader(String filePath){
        this.filePath=filePath;
    }

    @Override
    public List<Package> load() throws Exception {
        List<Package> packages;
        try (Stream<String> lines = Files.lines(Paths.get(filePath))){
             packages = lines
                    .map(lineToPackage)
                    .collect(Collectors.toList());
        }
        return packages;
    }

    private static Function<String, Package> lineToPackage = line -> {
        String[] splittedLine = line.split(":");
        BigDecimal limit = new BigDecimal(splittedLine[0].trim());

        List<String> lineItems = new ArrayList<>();
        Matcher m = Pattern.compile("\\(([^)]+)\\)")
                .matcher(splittedLine[1].trim());
        while (m.find()) {
            lineItems.add(m.group().substring(1,m.group().length() - 1 ));
        }

        List<Item> items = lineItems.stream()
                .map(thingAsString -> {
                    String[] thingDetails = thingAsString.split(",");
                    int id = Integer.parseInt(thingDetails[0]);
                    BigDecimal weight = new BigDecimal(thingDetails[1]);
                    BigDecimal price =  new BigDecimal(thingDetails[2].substring(1, thingDetails[2].length()));
                    return new Item(id, weight, price);
                })
                .collect(Collectors.toList());

        return new Package(limit, items);
    };
}
