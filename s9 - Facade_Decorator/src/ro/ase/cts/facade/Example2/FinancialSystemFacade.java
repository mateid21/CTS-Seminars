package ro.ase.cts.facade.Example2;

public class FinancialSystemFacade {
    private AccountingSystem accounting;
    private PayrollSystem payroll;
    private InvestmentSystem investment;

    public FinancialSystemFacade(AccountingSystem accounting, PayrollSystem payroll, InvestmentSystem investment) {
        this.accounting = accounting;
        this.payroll = payroll;
        this.investment = investment;
    }

    void processSalaryPayments(){
        payroll.calculatePay();
        accounting.updateLedger(payroll);
    }

    void manageInvestments(){
        double funds = accounting.availableFunds();
        investment.investFunds(funds);
    }
}
