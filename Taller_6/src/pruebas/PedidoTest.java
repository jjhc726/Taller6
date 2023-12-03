package pruebas;
import modelo.Producto;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import excepciones.PedidoException;
import modelo.Bebida;
import modelo.Pedido;
import modelo.ProductoMenu;

public class PedidoTest {

	@Test
	public void testAgregarProducto() throws PedidoException {
        Pedido pedido = new Pedido("Cliente", "Dirección");

        ProductoMenu producto1 = new ProductoMenu("Hamburguesa", 10000, 500);
        Bebida bebida1 = new Bebida("Coca-Cola", 3000, 150);

        pedido.agregarProducto(producto1);
        pedido.agregarProducto(bebida1);

        List<Producto> itemsPedido = pedido.getItemsPedido();
        assertEquals(2, itemsPedido.size());
        assertTrue(itemsPedido.contains(producto1));
        assertTrue(itemsPedido.contains(bebida1));
    }

    @Test
    public void testAgregarProductoConLimiteSuperado() {
        Pedido pedido = new Pedido("Cliente", "Dirección");

        ProductoMenu producto1 = new ProductoMenu("Hamburguesa", 80000, 500);
        Bebida bebida1 = new Bebida("Coca-Cola", 70000, 150);

        assertThrows(PedidoException.class, () -> {
            pedido.agregarProducto(producto1);
            pedido.agregarProducto(bebida1);
        });
    }

    @SuppressWarnings("deprecation")
	@Test
    public void testSetDescuento() {
        Pedido pedido = new Pedido("Cliente", "Dirección");
        pedido.setDescuento(0.1);

        assertEquals(0.9, pedido.getDescuento());
    }

    @Test
    public void testGenerarTextoFactura() throws PedidoException {
        Pedido pedido = new Pedido("Cliente", "Dirección");

        ProductoMenu producto1 = new ProductoMenu("Hamburguesa", 10000, 500);
        Bebida bebida1 = new Bebida("Coca-Cola", 3000, 150);

        pedido.agregarProducto(producto1);
        pedido.agregarProducto(bebida1);

        String factura = pedido.generarTextoFactura();

        assertTrue(factura.contains("Hamburguesa"));
        assertTrue(factura.contains("Coca-Cola"));
        assertTrue(factura.contains("Total:"));
    }

    @Test
    public void testGuardarFactura() {
        Pedido pedido = new Pedido("Cliente", "Dirección");

        try {
            pedido.guardarFactura();
            // Comprueba que no se lance ninguna excepción al intentar guardar la factura.
        } catch (Exception e) {
            fail("No debería lanzar ninguna excepción al intentar guardar la factura.");
        }
    }

}
