import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-bill-details',
  templateUrl: './bill-details.component.html',
  styleUrl: './bill-details.component.css'
})
export class BillDetailsComponent {
  billDetails: any;
  billId!: number;
  // ActivatedRoute: pour recuperer ID du client
  constructor(private http: HttpClient, private router: Router, private route: ActivatedRoute) {
    this.billId = this.route.snapshot.params['billId'];
  }
  ngOnInit(): void {
    this.http.get("http://localhost:8888/BILLING-SERVICE/fullBill/"+this.billId ).subscribe({
      next: (data) => {
        this.billDetails = data;
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
