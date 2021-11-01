using Microsoft.VisualStudio.TestTools.UnitTesting;
using FluentAssertions;
using Moq;
using RestSharp;
using System.Net;
using AuctionApp.Exceptions;
using AuctionApp.Models;

namespace AuctionApp.Tests
{
    [TestClass]
    public class ApiServiceTests
    {
        [TestMethod]
        public void Step2_LoginMethod()
        {
            // Arrange
            ApiUser expected = new ApiUser { Username = "test", Token = "abcdefgh123456789", Message = null };

            Mock<IRestClient> restClient = new Mock<IRestClient>();
            restClient.Setup(x => x.Execute<ApiUser>(It.IsAny<IRestRequest>(), Method.POST))
                .Returns(new RestResponse<ApiUser>
                {
                    StatusCode = HttpStatusCode.OK,
                    Data = expected,
                    ResponseStatus = ResponseStatus.Completed
                });
            ApiService apiService = new ApiService(restClient.Object);

            // Act
            ApiUser actual = apiService.Login("test", "test");

            // Assert
            expected.Should().BeEquivalentTo(actual); // Uses FluentAssertions
        }

        [TestMethod]
        [ExpectedException(typeof(UnauthorizedException))]
        public void Step3_UnauthorizedResponse()
        {
            // Arrange
            var response = new RestResponse<Auction>
            {
                StatusCode = HttpStatusCode.Unauthorized,
                ResponseStatus = ResponseStatus.Completed
            };
            ApiService apiService = new ApiService();

            // Act
            apiService.ProcessErrorResponse(response);

            // Assert
            Assert.Fail("Exception should be thrown.");
        }

        [TestMethod]
        [ExpectedException(typeof(ForbiddenException))]
        public void Step3_ForbiddenResponse()
        {
            // Arrange
            var response = new RestResponse<Auction>
            {
                StatusCode = HttpStatusCode.Forbidden,
                ResponseStatus = ResponseStatus.Completed
            };
            ApiService apiService = new ApiService();

            // Act
            apiService.ProcessErrorResponse(response);

            // Assert
            Assert.Fail("Exception should be thrown.");
        }

        [TestMethod]
        [ExpectedException(typeof(NonSuccessException))]
        public void Step3_Other4xxResponse()
        {
            // Arrange
            var response = new RestResponse<Auction>
            {
                StatusCode = HttpStatusCode.BadRequest,
                ResponseStatus = ResponseStatus.Completed
            };
            ApiService apiService = new ApiService();

            // Act
            apiService.ProcessErrorResponse(response);

            // Assert
            Assert.Fail("Exception should be thrown.");
        }
    }
}
