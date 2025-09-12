import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Product } from '../model/product';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  // spring url backend
  private spring_back_end_url ='http://localhost:8080';
  
  constructor(private httpClient:HttpClient){}

  // consume backend apis ie createProduct,deleteProductById,getAllProducts
  public createProduct(product:Product):Observable<Product>{
    return this.httpClient.post<Product>(`${this.spring_back_end_url}/create-product`,product);
  }

  public getAllProducts():Observable<Product[]>{
    return this.httpClient.get<Product[]>(`${this.spring_back_end_url}/get-all-products`);
  }

  public deleteProductById(productId:number):Observable<void>{
    return this.httpClient.delete<void>(`${this.spring_back_end_url}/delete-product-by-id/${productId}`)
  }
  
}
