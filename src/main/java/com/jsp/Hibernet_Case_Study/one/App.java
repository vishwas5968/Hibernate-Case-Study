
package com.jsp.Hibernet_Case_Study.one;

import java.util.Scanner;

import com.jsp.Hibernet_Case_Study.one.products.services.CartService;
import com.jsp.Hibernet_Case_Study.one.products.services.ProductServices;

public class App 
{
    public static void main( String[] args )
    {
       Scanner input=new Scanner(System.in);
       System.out.println("1.Product added\n"
       		+ "2.get Product by ID\n"
       		+ "3.All product details\n"
       		+ "4.Update by Id\n"
       		+ "5.Delete by Id\n"
       		+ "6.Delete all Products\n"
       		+ "7.Create cart\n"
       		+ "8.Add ProducttoCart\n"
       		+ "9.Remove Product to Cart\n"
       		+ "Enter the choices");
       
       int choice=input.nextInt();
       switch (choice) {
		case 1:
			 ProductServices.addProduct();
			break;
		case 2:
			 ProductServices.getProduct();
			break;
		case 3:
			 ProductServices.allProduct();
			break;
		case 4:
			 ProductServices.updateProduct();;
			break;
		case 5:
			 ProductServices.deleteProduct();
			break;
		case 6:
			 ProductServices.deleteAllProduct();
			break;
		case 7:
			 CartService.createCart();;
			break;
		case 8:
			 CartService.addProductToCart();;
			break;
			case 9:
				CartService.removeProductToCart();
				break;
		default:
			System.err.println("Invalid choice");
			break;
	}
       input.close();
    }
}
