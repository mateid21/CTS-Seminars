package ro.ase.cts.facade.Example2;

public class AccountingSystem {
    public void updateLedger(PayrollSystem payroll) {
        System.out.println("Updating ledger with payroll data");
    }

    public double availableFunds() {
        System.out.println("Calculating available funds");
        return 1000;
    }
}
