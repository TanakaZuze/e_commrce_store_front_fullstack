import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Product } from '../../model/product';
import { ProductService } from '../../service/product-service';
import { HttpErrorResponse } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-product-component',
  imports: [FormsModule],
  templateUrl: './product-component.html',
  styleUrl: './product-component.css'
})
export class ProductComponent implements OnInit {
  // constructor for injection of product service
  constructor(private productService: ProductService, private cd: ChangeDetectorRef) { }
  ngOnInit(): void {
    this.getAllProducts();

    // throw new Error('Method not implemented.');
  }

  // variable to hold all products
  public products: Product[] = [];
  // variable to hold new product entry
  // public newProduct:Product[
  //   product_name:string="";
  //   product_description:string | undefined;
  //   product_price:number;
  //   product_image_url:string;
  // ]

  public newProduct: Product = {
    product_name: '',
    product_description: '',
    product_price: 0,
    product_image_url: ''
  }


  public getAllProducts(): void {
    this.productService.getAllProducts().subscribe({
      next: (response: Product[]) => {
        this.products = response;
        this.cd.detectChanges();
      },
      error: (error: HttpErrorResponse) => {
        console.log(error.message);
      }
    })
  }

  public createProduct(): void {
    this.productService.createProduct(this.newProduct).subscribe({
      next: (createdProduct) => {
        this.products.push(createdProduct)
        this.formReset();
        this.cd.detectChanges();
      }
    })
  }

  public formReset(): void {
    this.newProduct = {
      product_name: '',
      product_description: '',
      product_price: 0,
      product_image_url: ''
    }
    this.cd.detectChanges();
  }

 public deleteProduct(productId: number): void {
  this.productService.deleteProductById(productId).subscribe({
    next: () => {
      // Remove the product from the list in memory
      this.products = this.products.filter(p => p.id !== productId);
      this.cd.detectChanges();
    },
    error: (error: HttpErrorResponse) => {
      console.error('Delete failed:', error.message);
    }
  });
}


}
