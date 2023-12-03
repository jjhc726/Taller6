package pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Combo;
import modelo.ProductoMenu;

public class ComboTest {

	@SuppressWarnings("deprecation")
	@Test
	public void testAgregarItemACombo() {
        ProductoMenu producto1 = new ProductoMenu("Hamburguesa", 10000, 300);
        ProductoMenu producto2 = new ProductoMenu("Papas", 5000, 200);
        Combo combo = new Combo("Combo1", 0.1);

        combo.agregarItemACombo(producto1);
        combo.agregarItemACombo(producto2);

        assertEquals(2, combo.getItemsCombo().size());
        assertEquals(10000 + 5000, combo.getPrecio()); // Suma de precios de los productos
        assertEquals(300 + 200, combo.getCalorias()); // Suma de calorías de los productos
    }

    @Test
    public void testGenerarTextoFactura() {
        ProductoMenu producto1 = new ProductoMenu("Pizza", 12000, 800);
        ProductoMenu producto2 = new ProductoMenu("Refresco", 3000, 150);
        Combo combo = new Combo("Combo2", 0.15);

        combo.agregarItemACombo(producto1);
        combo.agregarItemACombo(producto2);

        String expected = "Combo2 -> 12750.0 -> 950 cal";
        assertEquals(expected, combo.generarTextoFactura());
    }

    @Test
    public void testGetCalorias() {
        ProductoMenu producto1 = new ProductoMenu("Ensalada", 9000, 400);
        ProductoMenu producto2 = new ProductoMenu("Agua", 1000, 0);
        Combo combo = new Combo("Combo3", 0.05);

        combo.agregarItemACombo(producto1);
        combo.agregarItemACombo(producto2);

        assertEquals(400 + 0, combo.getCalorias()); // Suma de calorías de los productos
    }

}
