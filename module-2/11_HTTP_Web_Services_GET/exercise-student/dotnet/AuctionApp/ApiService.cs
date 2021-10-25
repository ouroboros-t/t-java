using RestSharp;
using System.Collections.Generic;
using AuctionApp.Models;

namespace AuctionApp
{
    public class ApiService
    {
        public const string API_URL = "http://localhost:3000/auctions";
        public IRestClient client = new RestClient();

        public List<Auction> GetAllAuctions()
        {
            throw new System.NotImplementedException();
        }

        public Auction GetDetailsForAuction(int auctionId)
        {
            throw new System.NotImplementedException();
        }

        public List<Auction> GetAuctionsSearchTitle(string searchTitle)
        {
            throw new System.NotImplementedException();
        }

        public List<Auction> GetAuctionsSearchPrice(double searchPrice)
        {
            throw new System.NotImplementedException();
        }
    }
}
