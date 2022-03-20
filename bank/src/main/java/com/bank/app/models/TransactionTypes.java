package com.bank.app.models;

public enum TransactionTypes {

	Deposit("Deposit"),
	Withdraw("WithDraw");
	
	   private final String type;

	   TransactionTypes(String type) {
			this.type=type;
	   }
			
	   public String getType(){
			return this.type;
	   }
}
