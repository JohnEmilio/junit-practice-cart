package tech.strategio;


import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ProductTest {
    /*
When created, the cart has 0 items
When empty, the cart has 0 items
When a new product is added, the number of items must be incremented
When a new product is added, the new balance must be the sum of the previous balance plus the cost of the new product
When an item is removed, the number of items must be decreased
When a product not in the cart is removed, a ProductNotFoundException must be thrown
Hint: insert the call in a try block and put a fail() after the call to removeItem()
     */

    static ShoppingCart cart;
    Product toothpaste = new Product("Crest", 2.99);
    Product milk = new Product("Milk", 4.00);
    @BeforeAll
    public static void createNewShoppingCart() {
        cart = new ShoppingCart();
    }


    @Test
    public void testInitialShoppingCartCount(){
        ShoppingCart newCart = new ShoppingCart();
        assertEquals(0, newCart.getItemCount(), .001);
    }


    @Test
    public void testAddOneItemToShoppingCart () {
        cart.addItem(toothpaste);
        assertEquals(1,cart.getItemCount(), .001);
    }

    @Test
    public void testBalanceForShoppingCartIsUpdated() {
        cart.addItem(toothpaste);
        // expected is the price of the item, actual is the price of the cart, delta is whatever
        assertEquals(2.99, cart.getBalance(), .5);
    }
    @Test
    public void testItemIsRemovedFromCart () throws ProductNotFoundException {
        cart.removeItem(toothpaste);
        assertEquals(0, cart.getItemCount(), .001);
    }

    @Test
    public void testThrowExceptionForItemNotInCart () throws ProductNotFoundException{
        try{
            cart.removeItem(milk);
            fail("Item not found in shopping cart");
        }
        catch(ProductNotFoundException e) {
            assertNotNull(e);
        }
    }
}
