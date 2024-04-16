package ro.ase.cts.facade.Example2;

public class Example2 {
    public static void main(String[] args) {
        FinancialSystemFacade financialSystem = new FinancialSystemFacade(new AccountingSystem(), new PayrollSystem(), new InvestmentSystem());
        financialSystem.processSalaryPayments();
        financialSystem.manageInvestments();
    }
}
