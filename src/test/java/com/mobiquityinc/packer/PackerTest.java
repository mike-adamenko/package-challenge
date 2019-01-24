package com.mobiquityinc.packer;

import com.mobiquityinc.packer.exception.APIException;
import org.junit.Assert;
import org.junit.Test;

import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * Unit tests for {@link Packer}
 *
 * @author Mike Adamenko (mnadamenko@gmail.com)
 */
public class PackerTest {

    @Test(expected = APIException.class)
    public void shouldThrowAPIExceptionIfFilePathInvalid() {
        //invalidFilePath is generated randomly to be ensure it does not exist
        Packer.pack(UUID.randomUUID().toString());
    }

    @Test(expected = APIException.class)
    public void shouldThrowAPIExceptionIfFileContentInvalid() throws URISyntaxException {
        java.net.URL url = PackerTest.class.getResource("/testInvalid.txt");
        Packer.pack(Paths.get(url.toURI()).toString());
    }

    @Test(expected = APIException.class)
    public void shouldThrowAPIExceptionIfExceed15Items() throws URISyntaxException {
        java.net.URL url = PackerTest.class.getResource("/testExceed15Items.txt");
        Packer.pack(Paths.get(url.toURI()).toString());
    }

    @Test(expected = APIException.class)
    public void shouldThrowAPIExceptionIfItemCostExceed100() throws URISyntaxException {
        java.net.URL url = PackerTest.class.getResource("/testItemCostExceed100.txt");
        Packer.pack(Paths.get(url.toURI()).toString());
    }

    @Test(expected = APIException.class)
    public void shouldThrowAPIExceptionIfItemWeghtExceed100() throws URISyntaxException {
        java.net.URL url = PackerTest.class.getResource("/testItemWeghtExceed100.txt");
        Packer.pack(Paths.get(url.toURI()).toString());
    }

    @Test(expected = APIException.class)
    public void shouldThrowAPIExceptionIfLimitExceed100() throws URISyntaxException {
        java.net.URL url = PackerTest.class.getResource("/testLimitExceed100.txt");
        Packer.pack(Paths.get(url.toURI()).toString());
    }

    @Test
    public void shouldReturnValidResult() throws URISyntaxException {
        java.net.URL url = PackerTest.class.getResource("/testValid.txt");
        String validResult = "4\n-\n2,7\n8,9";
        Assert.assertEquals(validResult, Packer.pack(Paths.get(url.toURI()).toString()));
    }
}
