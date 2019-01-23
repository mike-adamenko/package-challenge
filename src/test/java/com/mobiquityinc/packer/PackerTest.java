package com.mobiquityinc.packer;

import com.mobiquityinc.packer.exception.APIException;
import org.junit.Assert;
import org.junit.Test;

import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.UUID;

/**
 *
 */
public class PackerTest {

    @Test(expected = APIException.class)
    public void shouldThrowAPIExceptionIfFilePathInvalid(){
        //invalidFilePath is generated randomly to be ensure it does not exist
        String invalidFilePath = UUID.randomUUID().toString();
        Packer.pack(invalidFilePath);
    }

    @Test(expected = APIException.class)
    public void shouldThrowAPIExceptionIfFileContentInvalid() throws URISyntaxException {
        java.net.URL url = PackerTest.class.getResource("/testInvalid.txt");
        Packer.pack(Paths.get(url.toURI()).toString());
    }

    @Test
    public void shouldReturnValidResult() throws URISyntaxException {
        java.net.URL url = PackerTest.class.getResource("/testValid.txt");
        String validResult ="4\n-\n2,7\n8,9";
        Assert.assertEquals(validResult, Packer.pack(Paths.get(url.toURI()).toString()));
    }
}
