import { Component } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'demoCap';
  customerId="1234"
  initialCredit;
  enable=true;
  accountNo;
  reqHeaders = new HttpHeaders({
    "Content-Type": "application/json; charset=utf-8",
    'Access-Control-Allow-Origin': '*'
  });
  transaction;
  constructor(private http: HttpClient){
    this.getAllTransactions();
  }
  setModel(value){
    this.initialCredit=value;
  }
  openAccount(){
    var account;
    if(this.accountNo!=undefined){
      account={
        "customer":{
          "customerId":"1234"
       },
       "initialCredit":this.initialCredit,
       "accountId":this.accountNo.trim()
      }
    }else{
      account={
        "customer":{
          "customerId":"1234"
       },
       "initialCredit":this.initialCredit
      }
    }

    this.http.post<Transactions>('http://localhost:2008/account/',account , {headers: this.reqHeaders }).subscribe(resp=>{
      if(resp){
        console.info("account open successfully..")
        this.initialCredit=0;
        this.accountNo=undefined;
        this.getAllTransactions();
      }
    });
  }
  getAllTransactions(){
    this.http.get<Transactions>('http://localhost:2008/account/summery/1234' , {headers: this.reqHeaders }).subscribe(resp=>{
      if(resp){
        this.transaction=resp;
        this.enable=false;
      }
    });
  }

}
export class Customer{
  customerId:string;
  name:string;
  phone:string;
}
export class Account{
  accountId:string;
  Customer:Customer;
}
export class Transactions{
account:Account;  
transactionId:number;
transactionDate:number;
transactionType:string;
balance:number;
amount:number;
}