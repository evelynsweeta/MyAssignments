package week4.day1;

public class Amazon extends CanaraBank {
    /*
     * Create a Concrete Class Amazon that inherits CanaraBank, implementing methods.
     */
	@Override
	public void cashOnDelivery() {
		System.out.println("COD from interface payments");
		
	}

	@Override
	public void upiPayments() {
		System.out.println("UPI Payments from interface payments");
		
	}

	@Override
	public void cardPayments() {
		System.out.println("Card Payments from interface payments");
		
	}

	@Override
	public void internetBanking() {
		System.out.println("Internet Banking from interface payments");
		
	}
	public static void main(String[] args) {
		Amazon Am=new Amazon();
		Am.cashOnDelivery();
		Am.upiPayments();
		Am.cardPayments();
		Am.internetBanking();
		Am.recordPaymentDetails();

	}

}
