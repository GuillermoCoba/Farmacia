/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.utils;

import administrador.Dproducto;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author diego
 */
public class ConsultaTest {
    
    public ConsultaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of cargarlistaproductos method, of class Consulta.
     */
    @Test
    public void testCargarlistaproductos() {
        System.out.println("cargarlistaproductos");
        String dato = "Para";
        Consulta instance = new Consulta();
        Dproducto expResult = new Dproducto();
        expResult.setPr_Id(7L);
            expResult.setPr_Nombre("Paracetamol");
            expResult.setPr_Presentacion("Jarabe");
            expResult.setPr_Precio(20F);
            expResult.setPr_Cantidad(0);
        ArrayList<Dproducto> result = instance.cargarlistaproductos(dato);
        System.out.println("Objeto = "+result.get(0));
        System.out.println("Objeto2 = "+expResult);
        System.out.println("comparacion = "+expResult.equals(result.get(0)));
        assertEquals(expResult, result.get(0));
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
