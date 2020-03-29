package kr.co.fastcampus.eatgo.service;


import kr.co.fastcampus.eatgo.domain.Region;
import kr.co.fastcampus.eatgo.domain.RegionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.swing.plaf.synth.SynthContext;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

public class RegionServiceTest {

    private RegionService regionService;

    @Mock
    private RegionRepository regionRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        mockRegionRepository();
        regionService = new RegionService(regionRepository);
    }

    private void mockRegionRepository() {
        List<Region> regions = new ArrayList<>();
        regions.add(Region.builder().name("Seoul").build());
        given(regionRepository.findAll()).willReturn(regions);
    }

    @Test
    public void getRegions(){
        List<Region> regions = regionService.getRegions();
        Region region = regions.get(0);
        assertThat(region.getName(), is("Seoul"));
    }

    @Test
    public void addRegion(){

        Region region = regionService.addRegion("Seoul");
        assertThat(region.getName(), is("Seoul"));

        // service에서 regionRepository의 save를 실제 실행 했느가
        verify(regionRepository).save(any());
    }

}