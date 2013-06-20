package com.ironman.controller;

import com.ironman.domain.Listing;
import com.ironman.domain.ListingStatus;
import com.ironman.service.ListingService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jsingh on 2013-06-19 at 2:29 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(value = {"file:src/main/webapp/WEB-INF/spring/applicationContext.xml", "file:src/main/webapp/WEB-INF/spring/servlet-context.xml"})
public class ListingControllerTest {
    @Autowired
    WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void shouldReturnListingsByListingStatus() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/listings?status=" + ListingStatus.AVAILABLE)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void shouldReturnListingsByPrice() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/listings?priceGe=100000&priceLe=500000")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void shouldReturnListingsByCity() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/listings?city=Brampton")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
