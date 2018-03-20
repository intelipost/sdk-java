package br.com.intelipost.sdk.unit;

import static br.com.intelipost.sdk.util.JsonLoader.loadFile;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.intelipost.sdk.client.IntelipostClient;
import br.com.intelipost.sdk.response.ZipCodeResponse;

@RunWith(MockitoJUnitRunner.class)
public class ZipCodeTest {

    @Mock
    private IntelipostClient intelipostClient;

    @Before
    public void before() {
        ZipCodeResponse response = loadFile(ZipCodeResponse.class, "/ZipCode.json");
        when(intelipostClient.getZipCodeInfo(anyString())).thenReturn(response);
    }

    @Test
    public void shouldZipCodeReturnInfo() {
        ZipCodeResponse zipCodeInfo = intelipostClient.getZipCodeInfo("00000000");
        assertNotNull(zipCodeInfo);
    }

    @Test
    public void shouldZipCodeMatchNeighborhood() {
        ZipCodeResponse zipCodeInfo = intelipostClient.getZipCodeInfo("00000-000");
        assertEquals(zipCodeInfo.getNeighborhood(), "Power Mock");
    }
}
