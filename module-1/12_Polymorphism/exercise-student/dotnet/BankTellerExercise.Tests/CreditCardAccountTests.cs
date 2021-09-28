using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Reflection;

namespace BankTellerExercise.Tests
{
    [TestClass]
    public class CreditCardAccountTests
    {
        private Type type;
        private PropertyInfo[] properties;

        [TestInitialize]
        public void SetUpBankAccount()
        {
            type = Type.GetType("BankTellerExercise.CreditCardAccount, BankTellerExercise");
            properties = type.GetProperties();
        }

        [TestMethod]
        public void ConstructorTest()
        {
            object ccAccount = Activator.CreateInstance(type, new object[] { "TEST", "6011222233334444" });

            object accountHolder = GetPropertyValue(ccAccount, "AccountHolderName");
            object accountNumber = GetPropertyValue(ccAccount, "AccountNumber");

            Assert.IsNotNull(ccAccount);
            Assert.AreEqual(accountHolder, "TEST");
            Assert.AreEqual(accountNumber, "6011222233334444");
        }

        [TestMethod]
        public void PayTest()
        {
            object ccAccount = Activator.CreateInstance(type, new object[] { "null", "null" });

            MethodInfo method = type.GetMethod("Pay");

            object[] methodParameters = new object[] { 25M };

            method.Invoke(ccAccount, methodParameters);

            object debtAmt = GetPropertyValue(ccAccount, "Debt");

            Assert.AreEqual(-25M, debtAmt);
        }

        [TestMethod]
        public void ChargeTest()
        {
            object ccAccount = Activator.CreateInstance(type, new object[] { "null", "null" });

            MethodInfo method = type.GetMethod("Charge");

            object[] methodParameters = new object[] { 25M };

            method.Invoke(ccAccount, methodParameters);

            object debt = GetPropertyValue(ccAccount, "Debt");

            Assert.AreEqual(25M, debt);
        }

        [TestMethod]
        public void AmountTest()
        {
            object ccAccount = Activator.CreateInstance(type, new object[] { "null", "null" });

            MethodInfo method = type.GetMethod("Charge");

            object[] methodParameters = new object[] { 500M };

            method.Invoke(ccAccount, methodParameters);

            object debt = GetPropertyValue(ccAccount, "Debt");
            object balance = GetPropertyValue(ccAccount, "Balance");

            Assert.AreEqual(500M, debt);
            Assert.AreEqual(-500M, balance);
        }

        private object GetPropertyValue(object instance, string propName)
        {
            object retVal = new object();
            foreach (PropertyInfo prop in properties)
            {
                if (prop.Name == propName)
                {
                    retVal = prop.GetValue(instance);
                }
            }
            return retVal;
        }
    }
}
