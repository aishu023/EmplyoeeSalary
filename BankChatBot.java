//java-bank chat bot

	
	class BankOperations implements IBankAccountOperation {
	    private double balance;

	    public void deposit(double d) {
	        balance += d;
	    }

	    public double processOperation(String message) {
	        String[] words = message.split(" ");
	        double value = 0;
	        for (String word : words) {
	            try {
	                value = Double.parseDouble(word);
	                break;
	            } catch (NumberFormatException e) {
	                //do nothing
	            }
	        }
	        if (message.toLowerCase().contains("deposit") || message.toLowerCase().contains("invest") || message.toLowerCase().contains("transfer")) {
	            deposit(value);
	        } else if (message.toLowerCase().contains("withdraw") || message.toLowerCase().contains("pull")) {
	            withdraw(value);
	        }
	        return balance;
	    }

	    public void withdraw(double d) {
	        if (balance >= d) {
	            balance -= d;
	        }
	    }
	}

