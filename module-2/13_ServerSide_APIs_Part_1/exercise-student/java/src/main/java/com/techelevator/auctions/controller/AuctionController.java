package com.techelevator.auctions.controller;

import com.techelevator.auctions.dao.AuctionDao;
import com.techelevator.auctions.dao.MemoryAuctionDao;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

    private AuctionDao dao;

    public AuctionController() {
        this.dao = new MemoryAuctionDao();
    }


    @GetMapping()
    public List<Auction> listAuction(@RequestParam(required = false, defaultValue = "") String title_like,
                                      @RequestParam(required = false, defaultValue = "0") double currentBid_lte){

        if(!title_like.equals("") && currentBid_lte !=0){
            return dao.searchByTitleAndPrice(title_like,currentBid_lte);
        } else if(!title_like.equals("")){
            return dao.searchByTitle(title_like);
        } else if (currentBid_lte != 0) {
            return dao.searchByPrice(currentBid_lte);
        }
        return dao.list();
    }

    @GetMapping("/{id}")
    public Auction getAuction(@PathVariable int id){
        return dao.get(id);
    }

    @PostMapping()
    public Auction createAuction(@RequestBody Auction newAuction){
        return dao.create(newAuction);
    }















}
