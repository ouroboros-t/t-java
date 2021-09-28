using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Reflection;

namespace BankTellerExercise.Tests
{
    [TestClass]
    public class SavingsAccountTests
    {
        private Type type;
        private PropertyInfo[] properties;

        [TestInitialize]
        public void SetUpBankAccount()
        {
            type = Type.GetType("BankTellerExercise.SavingsAccount, BankTellerExercise");
            properties = type.GetProperties();
        }

        [TestMethod]
        public void TryToWithdrawFromNegativeBalance()
        {
            SavingsAccount savAcct = new SavingsAccount("", "", -1);

            decimal newBalance = savAcct.Withdraw(1);

            Assert.AreEqual(-1, newBalance);
            Assert.AreEqual(-1, savAcct.Balance);
        }

        [TestMethod]
        public void SendPositiveIntoNegativeTest()
        {
            SavingsAccount savAcct = new SavingsAccount("", "", 1);

            decimal newBalance = savAcct.Withdraw(-2);

            Assert.AreEqual(1, newBalance);
            Assert.AreEqual(1, savAcct.Balance);
        }

        [TestMethod]
        public void TryToWithdrawFromPositiveBalance()
        {
            SavingsAccount savAcct = new SavingsAccount("", "", 200);

            decimal newBalance = savAcct.Withdraw(10);

            Assert.AreEqual(190, newBalance);
            Assert.AreEqual(190, savAcct.Balance);
        }

        [TestMethod]
        public void TryToWithdrawFromBalanceBelow150()
        {
            SavingsAccount savAcct = new SavingsAccount("", "", 151);

            decimal newBalance = savAcct.Withdraw(10);

            Assert.AreEqual(139, newBalance);
            Assert.AreEqual(139, savAcct.Balance);
        }

        [TestMethod]
        public void CanWithdrawToZero()
        {
            SavingsAccount savAcct = new SavingsAccount("", "", 10);
            savAcct.Withdraw(8);

            Assert.AreEqual(0, savAcct.Balance);
        }

        [TestMethod]
        public void CantWithdrawPastZeroIncludingFees()
        {
            SavingsAccount savAcct = new SavingsAccount("", "", 10);
            savAcct.Withdraw(10);

            Assert.AreEqual(10, savAcct.Balance);
        }

        [TestMethod]
        public void TransferTest()
        {
            SavingsAccount source = new SavingsAccount("", "", 50M);
            SavingsAccount destination = new SavingsAccount("", "");

            MethodInfo method = type.GetMethod("TransferTo");

            object[] methodParameters = new object[] { destination, 24M };

            method.Invoke(source, methodParameters);

            object newSourceBalance = GetPropertyValue(source, "Balance");

            // We lose $2 on fees
            Assert.AreEqual(24M, newSourceBalance);
            Assert.AreEqual(24M, destination.Balance);
            Assert.AreEqual(24M, source.Balance);
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
