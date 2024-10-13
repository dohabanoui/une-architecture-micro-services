import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-bills',
  templateUrl: './bills.component.html',
  styleUrl: './bills.component.css'
})
export class BillsComponent implements OnInit{
  bills: any;
  customerID!: number;
  // ActivatedRoute: pour recuperer ID du client
  constructor(private http: HttpClient, private router: Router, private route: ActivatedRoute) {
    this.customerID = this.route.snapshot.params['customerID'];
  }
  ngOnInit(): void {
    this.http.get("http://localhost:8888/BILLING-SERVICE/bills/search/byCustomerId?&projection=fullBill&customerID="+this.customerID ).subscribe({
      next: (data) => {
        this.bills = data;
      },
      error: (error) => {
        console.error(error);
      }
    });

  }

  getBillDetails(o: any) {
    this.router.navigateByUrl('/bill-details/' + o.id)

  }
}
