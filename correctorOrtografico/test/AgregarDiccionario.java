/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import correctorortografico.CorrectorOrtografico;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Justicar_Padraig
 */
public class AgregarDiccionario {
    
    public AgregarDiccionario() {
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

    @Test
    public void testTextAreaSeVacia() {
        CorrectorOrtografico correctorOrtografico = new CorrectorOrtografico();
        correctorOrtografico.getjTextArea().setText("guella");
        String textoAntes = correctorOrtografico.getjTextArea().getText();
        int longitudAntes = textoAntes.length();
        correctorOrtografico.limpiarTextArea();
        String textoDespues = correctorOrtografico.getjTextArea().getText();
        int longitudDespues = textoDespues.length();
        
        boolean resultado;
        
        if(longitudAntes>longitudDespues && longitudDespues ==0){
            resultado = true;
        } else {
            resultado = false;
        }
        
        assertEquals(true,resultado);
        
    }
    
    @Test
    public void testTextVacio() {
        CorrectorOrtografico correctorOrtografico = new CorrectorOrtografico();
        correctorOrtografico.getjTextArea().setText("");
        String textoAntes = correctorOrtografico.getjTextArea().getText();
        int longitudAntes = textoAntes.length();
        correctorOrtografico.limpiarTextArea();
        String textoDespues = correctorOrtografico.getjTextArea().getText();
        int longitudDespues = textoDespues.length();
        
        boolean resultado;
        
        if(longitudAntes>longitudDespues && longitudDespues ==0){
            resultado = true;
        } else {
            resultado = false;
        }
        
        assertEquals(false,resultado);
        
    }
}
