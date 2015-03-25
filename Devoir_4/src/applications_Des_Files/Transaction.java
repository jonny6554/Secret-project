public class Transaction {

    private int shares;
    private int sharePrice;

    public Transaction( int shares, int sharePrice ) {
	this.shares = shares;
	this.sharePrice = sharePrice;
    }

    public int getShares() {
	return shares;
    }

    public void sell( int num ) {
	if ( num > shares ) {
	    throw new IllegalArgumentException( "can't sell more than you have" );
	}
	shares = shares - num;
    }

    public int getSharePrice() {
	return sharePrice;
    }

}
