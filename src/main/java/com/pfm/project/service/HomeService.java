
package com.pfm.project.service;

import com.pfm.project.domain.home.API_Storage;
import com.pfm.project.domain.home.API_Storage_Repository;
import com.pfm.project.dto.home.request.API_Request;
import com.pfm.project.dto.home.request.HomeCoordinatesRequest;
import com.pfm.project.dto.home.response.HomeCardResponse;
import com.pfm.project.dto.home.response.HomeCoordinatesResponse;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HomeService {

    //private final HomeRepasitory home;
    private final API_Storage_Repository storage;

    public HomeService(API_Storage_Repository storage) {
        this.storage = storage;
    }

    @Transactional
    public void saveDB(List<API_Storage> req) {

            storage.saveAll(req);

    }

//    @Transactional
//    public List<HomeCoordinatesResponse> homeCoordinates(HomeCoordinatesRequest req) {
//
//        List<HomeCoordinatesResponse> response = null;
//
//        return response;
//
//    }
//
//
//    @Transactional
//    public HomeCardResponse homeCard(String storeid) {
//
//        HomeCardResponse res = null;
//
//        return res;
//    }


//    @Transactional
//    public List<SearchResponse> homeSearch(String search, HomeCoordinatesRequest req) {
//
//        List<SearchResponse> res = null;
//
//        return res;
//    }


}

