package com.mobiquityinc.packer;

import com.mobiquityinc.exception.APIException;
import org.junit.Test;

import java.util.UUID;

/**
 *
 */
public class PackerTest {

    @Test(expected = APIException.class)
    public void shouldThrowAPIExceptionIfIncorrectParametersAreBeingPassed(){
        //invalidFilePath generated randomly to be ensure it does not exist
        String invalidFilePath = UUID.randomUUID().toString();
        Packer.pack(invalidFilePath);
    }
}
