package pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.ProductoMenu;

public class ProductoMenuTest {

	@Test
	public void testGetCalorias() {
        ProductoMenu producto = new ProductoMenu("Hamburguesa", 15000, 500);
        assertEquals(500, producto.getCalorias());
    }

    @Test
    public void testGenerarTextoFactura() {
        ProductoMenu producto = new ProductoMenu("Pizza", 18000, 700);
        String expected = "Pizza -> 18000.0 -> 700 cal";
        assertEquals(expected, producto.generarTextoFactura());
    }

}
