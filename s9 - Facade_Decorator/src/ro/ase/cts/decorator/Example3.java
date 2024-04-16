package ro.ase.cts.decorator;

interface Subscription {
    String getDescription();
    double getPrice();
}

class BasicSubscription implements Subscription {
    @Override
    public String getDescription() {
        return "Basic subscription";
    }

    @Override
    public double getPrice() {
        return 10;
    }
}

abstract class SubscriptionDecorator implements Subscription {
    private Subscription subscription;

    SubscriptionDecorator(Subscription subscription) {
        this.subscription = subscription;
    }

    @Override
    public String getDescription() {
        return subscription.getDescription();
    }

    @Override
    public double getPrice() {
        return subscription.getPrice();
    }
}

class OfflineViewingDecorator extends SubscriptionDecorator {
    OfflineViewingDecorator(Subscription subscription) {
        super(subscription);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with offline viewing";
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 5;
    }
}

class HDStreamingDecorator extends SubscriptionDecorator {
    HDStreamingDecorator(Subscription subscription) {
        super(subscription);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with HD streaming";
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 3;
    }
}

public class Example3 {
    public static void main(String[] args) {
        Subscription subscription = new BasicSubscription();

        subscription = new OfflineViewingDecorator(subscription);

        subscription = new HDStreamingDecorator(subscription);

        System.out.println("Description: " + subscription.getDescription());
        System.out.println("Price: " + subscription.getPrice());
    }
}
