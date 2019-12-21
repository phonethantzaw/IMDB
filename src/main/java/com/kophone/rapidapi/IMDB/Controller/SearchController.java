package com.kophone.rapidapi.IMDB.Controller;

import com.kophone.rapidapi.IMDB.Model.IMDBDetail;
import com.kophone.rapidapi.IMDB.Model.Search;
import com.kophone.rapidapi.IMDB.Model.TitleParam;
import com.kophone.rapidapi.IMDB.Service.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @author ko phone
 */

@RestController
@RequestMapping("/api/")
public class SearchController {

    @Autowired
    private SearchRepository mService;

    @RequestMapping(value = "searchTitle", method = RequestMethod.POST)
    public ResponseEntity<List<Search>> searchTitle(TitleParam mRequest) throws IOException {

        List<Search> mSearch = mService.getIMDBSearch(mRequest);
        return new ResponseEntity<>(mSearch, HttpStatus.OK);
    }


    @RequestMapping(value = "IMDBDetail", method = RequestMethod.POST)
    public ResponseEntity<IMDBDetail> IMDBDetail(TitleParam mRequest) throws IOException {

        IMDBDetail mIMDBDetail = mService.getIMDBDetail(mRequest);
        return new ResponseEntity<>(mIMDBDetail, HttpStatus.OK);
    }
}
