public class Invoice implements Payable {
    String partNumber;
    String partDescription;
    int quantity;
    double pricePerItem;

    @Override
    public double getPayAmount() {
        return 0;
    }


}
