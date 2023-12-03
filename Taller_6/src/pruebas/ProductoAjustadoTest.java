package pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Ingrediente;
import modelo.ProductoAjustado;
import modelo.ProductoMenu;

public class ProductoAjustadoTest {

	@SuppressWarnings("deprecation")
	@Test
	public void testGetPrecio() {
        ProductoMenu productoBase = new ProductoMenu("Hamburguesa", 10000, 300);
        ProductoAjustado productoAjustado = new ProductoAjustado(productoBase);
        
        Ingrediente ingrediente = new Ingrediente("Queso", 2000, 50);
        productoAjustado.agregarIngrediente(ingrediente);
        
        double expectedPrecio = 10000 + 2000; // Precio base + Precio ingrediente
        assertEquals(expectedPrecio, productoAjustado.getPrecio());
    }

    @Test
    public void testGenerarTextoFactura() {
        ProductoMenu productoBase = new ProductoMenu("Ensalada", 8000, 200);
        ProductoAjustado productoAjustado = new ProductoAjustado(productoBase);
        
        Ingrediente ingrediente1 = new Ingrediente("Tomate", 1000, 20);
        Ingrediente ingrediente2 = new Ingrediente("Queso", 1500, 30);
        
        productoAjustado.agregarIngrediente(ingrediente1);
        productoAjustado.agregarIngrediente(ingrediente2);
        
        String expected = "Ensalada(EXTRA Tomate EXTRA Queso) -> 10500.0 -> 250 cal";
        assertEquals(expected, productoAjustado.generarTextoFactura());
    }

    @Test
    public void testGetCalorias() {
        ProductoMenu productoBase = new ProductoMenu("Sopa", 6000, 150);
        ProductoAjustado productoAjustado = new ProductoAjustado(productoBase);
        
        Ingrediente ingrediente = new Ingrediente("Pollo", 3000, 100);
        productoAjustado.agregarIngrediente(ingrediente);
        
        int expectedCalorias = 150 + 100; // Calorias base + Calorias ingrediente
        assertEquals(expectedCalorias, productoAjustado.getCalorias());
    }

}
