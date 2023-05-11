package com.pfm.project.controller;

import com.pfm.project.domain.home.API_Storage;
import com.pfm.project.service.HomeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/")
@Tag(name = "Home", description = "Home화면 관련 api")
public class HomeController {

    private final HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("/api")
    public void savedb(){

        String result = "";
        String result2 = "";

        List<API_Storage> req = new ArrayList<>();
        Long SH_ID;	 //업소아이디
        String SH_NAME;	 //업소명
        int INDUTY_CODE_SE;	 //분류코드
        String INDUTY_CODE_SE_NAME;	 //분류코드명
        String SH_ADDR;	 //업소 주소
        String SH_PHONE;	 //업소 전화번호
        String SH_WAY;	 //찾아오시는 길
        String SH_INFO;	 //업소정보
        String SH_PRIDE;	 //자랑거리
        String SH_PHOTO; 	//업소 사진

        try {
            URL url = new URL("http://openapi.seoul.go.kr:8088/7a584c4877627261393579564c574a/json/ListPriceModelStoreService/1/1000");
            URL url1 = new URL("http://openapi.seoul.go.kr:8088/7a584c4877627261393579564c574a/json/ListPriceModelStoreService/1001/1210");
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-type","application/json");

            HttpURLConnection connection1 = (HttpURLConnection)url1.openConnection();
            connection1.setRequestMethod("GET");
            connection1.setRequestProperty("Content-type","application/json");

            BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
            BufferedReader bf2 = new BufferedReader(new InputStreamReader(url1.openStream(),"UTF-8"));

            result = bf.readLine();
            result2 = bf2.readLine();

            JSONParser parser = new JSONParser();
            JSONObject object = (JSONObject) parser.parse(result);
            JSONObject object2 = (JSONObject) parser.parse(result2);

            JSONObject out1 = (JSONObject) object.get("ListPriceModelStoreService");

            JSONObject out2 = (JSONObject) object2.get("ListPriceModelStoreService");

            JSONArray array = (JSONArray) out1.get("row");
            JSONArray array2 = (JSONArray) out2.get("row");




            for (int i =0; i<array.size(); i++){
                JSONObject arr = (JSONObject) array.get(i);
                Long id = Long.parseLong((String) arr.get("SH_ID"));
                String store_name = (String)arr.get("SH_NAME");
                int store_code = Integer.parseInt((String) arr.get("INDUTY_CODE_SE"));
                String store_code_name = (String)arr.get("INDUTY_CODE_SE_NAME");
                String address = (String)arr.get("SH_ADDR");
                String number = (String)arr.get("SH_PHONE");
                String come = (String)arr.get("SH_WAY");
                String info = (String)arr.get("SH_INFO");
                String pride = (String)arr.get("SH_PRIDE");
                String photo = (String)arr.get("SH_PHOTO");

                API_Storage api_request = new API_Storage(id,store_name,store_code,store_code_name,address,number,come,pride,photo,info);
                req.add(api_request);

            }

            for (int i =0; i<array2.size(); i++){
                JSONObject arr = (JSONObject) array2.get(i);
                Long id = Long.parseLong((String) arr.get("SH_ID"));
                String store_name = (String)arr.get("SH_NAME");
                int store_code = Integer.parseInt((String) arr.get("INDUTY_CODE_SE"));
                String store_code_name = (String)arr.get("INDUTY_CODE_SE_NAME");
                String address = (String)arr.get("SH_ADDR");
                String number = (String)arr.get("SH_PHONE");
                String come = (String)arr.get("SH_WAY");
                String info = (String)arr.get("SH_INFO");
                String pride = (String)arr.get("SH_PRIDE");
                String photo = (String)arr.get("SH_PHOTO");

                API_Storage api_request = new API_Storage(id,store_name,store_code,store_code_name,address,number,come,pride,photo,info);
                req.add(api_request);

            }

            homeService.saveDB(req);



        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

   // private final HomeService service;

   /* public HomeController(HomeService service) {
        this.service = service;
    }

    @Operation(summary = "FirstHomepage", description = "홈페이지 처음들어왔을때")
    @PostMapping("/home")
    public List<HomeCoordinatesResponse> coordinates(@RequestBody HomeCoordinatesRequest coordinates) {
        return service.homeCoordinates(coordinates);
    }


    @Operation(summary = "HomeCard", description = "홈페이지 카드클릭시반응")
    @GetMapping("/card/{storeid}")
    public HomeCardResponse coordinates(@PathVariable("storeid") String storeid) {

        return service.homeCard(storeid);

    }

    @GetMapping("/search")
    public List<SearchResponse> homeSearch(@RequestParam("name") String serach,
                                           @RequestBody HomeCoordinatesRequest req) {

        return service.homeSearch(serach, req);


    }*/


}
