package ro.ase.cts.adapter;

interface PaymentProcessor{
    void processPayment(double amount);
}

class PayPal{
    PayPal(){}
    void sendPayment(double amount){
        System.out.println("Paying with PayPal: " + amount);
    }
}

class Stripe{
    Stripe(){}
    void makePayment(double amount){
        System.out.println("Paying with Stripe: " + amount);
    }
}

class PayPalAdapter implements PaymentProcessor{
    private PayPal payPal;

    public PayPalAdapter(PayPal payPal){
        this.payPal = payPal;
    }

    @Override
    public void processPayment(double amount) {
        payPal.sendPayment(amount);
    }
}

class StripeAdapter implements PaymentProcessor{
    private Stripe stripe;

    public StripeAdapter(Stripe stripe){
        this.stripe = stripe;
    }

    @Override
    public void processPayment(double amount) {
        stripe.makePayment(amount);
    }
}

public class Ex2 {
    public static void main(String[] args) {
        PaymentProcessor payPalAdapter = new PayPalAdapter(new PayPal());
        PaymentProcessor stripeAdapter = new StripeAdapter(new Stripe());
        payPalAdapter.processPayment(100);
        stripeAdapter.processPayment(200);
    }
}
