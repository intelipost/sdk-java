package br.com.intelipost.sdk.unit;

import static br.com.intelipost.sdk.util.JsonLoader.loadFile;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.intelipost.sdk.client.IntelipostClient;
import br.com.intelipost.sdk.response.LabelResponse;

@RunWith(MockitoJUnitRunner.class)
public class LabelTest {

    @Mock
    private IntelipostClient intelipostClient;

    @Before
    public void before() {
        LabelResponse labelResponse = loadFile(LabelResponse.class, "/Label.json");
        when(intelipostClient.getLabel(anyString(), anyInt())).thenReturn(labelResponse);
    }

    @Test
    public void shouldRetriveLabel() {
        LabelResponse label = intelipostClient.getLabel(anyString(), anyInt());
        assertThat(label.getLabelUrl(), not(isEmptyOrNullString()));
    }
}
