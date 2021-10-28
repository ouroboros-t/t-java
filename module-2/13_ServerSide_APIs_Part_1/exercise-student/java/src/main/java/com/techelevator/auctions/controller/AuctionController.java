package com.techelevator.auctions.controller;

import com.techelevator.auctions.dao.AuctionDao;
import com.techelevator.auctions.dao.MemoryAuctionDao;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

    private AuctionDao dao;

    public AuctionController() {
        this.dao = new MemoryAuctionDao();
    }

    /**
     * Return the Auction with the given ID
     */
    @RequestMapping(path = "/{auctionId}", method = RequestMethod.GET)
    public Auction getById(@PathVariable int auctionId) {
        return dao.get(auctionId);
    }

}
