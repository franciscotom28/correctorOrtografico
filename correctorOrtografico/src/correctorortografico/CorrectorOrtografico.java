/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package correctorortografico;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Justicar_Padraig
 */
public class CorrectorOrtografico extends JFrame implements ActionListener{

    static public JTextArea textAreaPalabra;
    static private String language, palabra;
    
    public static void main(String[] args) {

        CorrectorOrtografico frame = new CorrectorOrtografico();
        frame.setSize(536, 355);
        frame.setTitle("Ortografía y Gramática: ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        //frame.setResizable(false);
        Container container = frame.getContentPane();
        
        //Font letra = new Font(Font.SANS_SERIF"SansSerif",Font.PLAIN,12);
        Font letra = new Font(Font.SANS_SERIF,Font.PLAIN,9);
        
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
       // constraints.weightx=1;
        constraints.weightx=1;
        constraints.weighty=1;
        container.setLayout(gridBagLayout);
        JLabel noSeEncontro = new JLabel("  No se encontró: ");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        container.add(noSeEncontro,constraints);
        
        textAreaPalabra = new JTextArea(6, 30);
        textAreaPalabra.setText("Añade una palabra");
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridheight=3;
        constraints.gridwidth=2;
        constraints.fill = GridBagConstraints.NONE;
        constraints.insets = new Insets(0, 5, 0, 5);
        JScrollPane panelTextAreaPalabra = new JScrollPane(textAreaPalabra,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        panelTextAreaPalabra.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        container.add(panelTextAreaPalabra, constraints);
        constraints.gridheight=1;
        constraints.gridwidth=1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        
        
        JButton botonReanudar = new JButton("Reanudar");
        botonReanudar.setFont(letra);
        //botonReanudar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
         
        constraints.gridx = 2;
        constraints.gridy = 1;
        container.add(botonReanudar, constraints);
        
        JButton botonOmitir = new JButton("Omitir todas");
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.insets = new Insets(5, 5, 5, 5);
        container.add(botonOmitir, constraints);
        
        constraints.insets = new Insets(0, 5, 0, 5);
        JButton botonAgregar = new JButton("Agregar al diccionario");
        botonAgregar.setFont(letra);
        botonAgregar.addActionListener(frame);
        constraints.gridx = 2;
        constraints.gridy = 3;
        container.add(botonAgregar, constraints);
        
        //////////////////////////////////
        
        JLabel sugerencias = new JLabel("Sugerencias: ");
        constraints.gridx = 0;
        constraints.gridy = 4;
        
        //constraints.anchor = GridBagConstraints.NORTHWEST;
        //constraints.fill = GridBagConstraints.BOTH;
        container.add(sugerencias,constraints);
        
        //JTextArea textAreaSugerencia = new JTextArea(6, 30);
        //JList..
        JList textAreaSugerencia = new JList();
        textAreaSugerencia.setFixedCellHeight(10);
        
        constraints.weightx=1;
        constraints.weighty=1;
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridheight=3;
        constraints.gridwidth=2;
        //constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(0, 5, 0, 5);
        JScrollPane panelTextAreaSugerencia = new JScrollPane(textAreaSugerencia,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        panelTextAreaSugerencia.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        container.add(panelTextAreaSugerencia, constraints);
        constraints.gridheight=1;
        constraints.gridwidth=1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        
        
        JButton botonCambiar = new JButton("Cambiar");
        constraints.gridx = 2;
        constraints.gridy = 5;
        container.add(botonCambiar, constraints);
        
        JButton botonCambiarTodas = new JButton("Cambiar todas");
        constraints.gridx = 2;
        constraints.gridy = 6;
        constraints.insets = new Insets(5, 5, 5, 5);
        container.add(botonCambiarTodas, constraints);
        
        constraints.insets = new Insets(0, 5, 0, 5);
        JButton botonAutocorreccion = new JButton("Autocorreccion");
        constraints.gridx = 2;
        constraints.gridy = 7;
        container.add(botonAutocorreccion, constraints);
        
       // JPanel panelIdioma = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel idioma = new JLabel("Idioma del diccionario: ");
        constraints.gridx = 0;
        constraints.gridy = 8;
        constraints.anchor = GridBagConstraints.NORTHWEST;
        //constraints.fill = GridBagConstraints.HORIZONTAL;
        container.add(idioma,constraints);
        //container.add(panelIdioma,constraints);
        
        String[] listaIdiomas = {"Elija un idioma","Español (alfab. internacional", "Inglés", "Alemán"};
        JComboBox comboBoxIdioma = new JComboBox(listaIdiomas);
        comboBoxIdioma.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        JComboBox combo = (JComboBox)e.getSource();
                        language = (String)combo.getSelectedItem();
                        palabra = textAreaPalabra.getText();
                    }
                }            
        );
        constraints.gridx = 1;
        constraints.gridy = 8;
        //constraints.weightx=0.9;
        constraints.insets = new Insets(0, 5, 0, 5);
        container.add(comboBoxIdioma,constraints);
        //container.add(panelIdioma,constraints);
        
        JCheckBox revisarGramatica = new JCheckBox("Revisar Gramática");
        
        constraints.gridx = 0;
        constraints.gridy = 9;
        container.add(revisarGramatica, constraints);
        
        constraints.fill = GridBagConstraints.NONE;
        JButton botonOpciones = new JButton("Opciones...");
        constraints.gridx = 0;
        constraints.gridy = 10;
        container.add(botonOpciones, constraints);
        
        JButton botonDeshacer = new JButton("Deshacer");
        constraints.gridx = 1;
        constraints.gridy = 10;
        botonDeshacer.setEnabled(false);
        
        constraints.anchor= GridBagConstraints.WEST;
        container.add(botonDeshacer, constraints);
        
        constraints.fill = GridBagConstraints.HORIZONTAL;
        JButton botonCancelar = new JButton("Cancelar");
        constraints.gridx = 2;
        constraints.gridy = 10;
        constraints.anchor= GridBagConstraints.EAST;
        container.add(botonCancelar, constraints);
        
         frame.setVisible(true);
    }
    
    public CorrectorOrtografico(){
        textAreaPalabra = new JTextArea();
    }

    public JTextArea getjTextArea() {
        return textAreaPalabra;
    }

    public void setjTextArea(JTextArea jTextArea) {
        this.textAreaPalabra = jTextArea;
    }
    
    public void limpiarTextArea(){
        textAreaPalabra.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        palabra = textAreaPalabra.getText();
        textAreaPalabra.setText(null);
        if (language.equals("Español (alfab. internacional"))
            Diccionarios.agregaDiccionarioESP(palabra);
        if (language.equals("Inglés"))
            Diccionarios.agregaDiccionarioENG(palabra);
        if (language.equals("Alemán"))
            Diccionarios.agregaDiccionarioGER(palabra);
    }
}
