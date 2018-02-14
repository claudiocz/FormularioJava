package com.formulary;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Formulario extends JFrame{

    private JPanel panelReg;

    private JLabel nombres;
    private JTextField campoNom;

    private JLabel apellidos;
    private JTextField campoApe;

    private JLabel email;
    private JTextField campoMail;

    private JLabel pais;
    private JComboBox campoPais;

    private JLabel celular;
    private JTextField campoCelu;

    private JLabel direccion;
    private JTextField campoDirec;

    private JLabel genero;
    private JComboBox listagenero;

    private JButton botonGuardar;
    private FileWriter fw;
    private PrintWriter pw;

    //CONSTRUCCTOR
    public Formulario() {
        super("Formulario de Registro...");
        setSize(700, 700);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //inicialización y adición de componentes
        //Nombres y su campo
        nombres = new JLabel("Nombre:");
        nombres.setBounds(50, 50, 100, 20);
        add(nombres);
        campoNom = new JTextField("");
        campoNom.setBounds(120, 50, 200, 20);
        add(campoNom);

        //Apellidos y su campo
        apellidos = new JLabel("Apellidos:");
        apellidos.setBounds(50, 100, 100, 20);
        add(apellidos);
        campoApe = new JTextField("");
        campoApe.setBounds(120, 100,200, 20);
        add(campoApe);

        //Email
        email = new JLabel("Email:");
        email.setBounds(50, 150, 100, 20);
        add(email);
        campoMail = new JTextField("");
        campoMail.setBounds(120, 150,200, 20);
        add(campoMail);


        pais = new JLabel("Pais:");
        pais.setBounds(50, 200, 100, 20);
        add(pais);
        String[] listaPaises = {"Argentina", "Australia", "Belgica", "Bolivia", "Brasil", "Chile",
                                    "Colombia", "Ecuador", "Guyana", "Paraguay", "Perú", "Venezuela"};
        campoPais = new JComboBox(listaPaises);
        campoPais.setBounds(120, 200, 200, 20);
        add(campoPais);

        celular = new JLabel("Celular:");
        celular.setBounds(50, 250, 100, 20);
        add(celular);
        campoCelu = new JTextField("");
        campoCelu.setBounds(120, 250,200, 20);
        add(campoCelu);

        direccion = new JLabel("Dirección:");
        direccion.setBounds(50, 300, 100, 20);
        add(direccion);
        campoDirec = new JTextField("");
        campoDirec.setBounds(120, 300,300, 20);
        add(campoDirec);

        genero = new JLabel("Genero:");
        genero.setBounds(50, 350, 100, 20);
        add(genero);
        String[] combobox = {"Masculino", "Femenino"};
        listagenero = new JComboBox(combobox);
        listagenero.setBounds(120, 350, 200, 20);
        add(listagenero);


        botonGuardar = new JButton("Registrar");
        botonGuardar.setBounds(300, 500, 120, 50);
        add(botonGuardar);

        botonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Registrar();
            }
        });
    }

    //Metodo para guardar los datos del formulario
    public void Registrar(){
        try {
            fw = new FileWriter("registro.txt");
            pw = new PrintWriter(fw);

            //guardamos el campo en un string
            String name = campoNom.getText();
            String lastname = campoApe.getText();
            String mail = campoMail.getText();
            String country = campoPais.getSelectedItem().toString();
            String numCel = campoCelu.getText();
            String address = campoDirec.getText();
            String gender = listagenero.getSelectedItem().toString();

            //Imprimimos los campos para guardarlos en .txt
            pw.write("nombre: " +name + "\n"+ "apellido: " + lastname + "\n" +"email: " + mail + "\n"+
                        "Pais: "+ country +"\n" + "Celular: "+numCel + "\n" + "Dirección: " + address +
                        "\n"+ "Genero: "+ gender);

            //luego ponemos en blanco los campos para un nuevo registro
            campoNom.setText("");
            campoApe.setText("");
            campoMail.setText("");
            campoPais.setSelectedItem(null);
            campoCelu.setText("");
            campoDirec.setText("");
            listagenero.setSelectedItem(null);
            pw.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
