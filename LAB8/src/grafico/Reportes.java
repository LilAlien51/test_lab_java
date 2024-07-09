package grafico;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import logica.Becas;

import java.awt.*;
import java.util.ArrayList;


public class Reportes extends JFrame {
	
	  private static final long serialVersionUID = 1L;
	    private JPanel contentPane;
	    private JTextArea textAreaBecados;

	    public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                    Reportes frame = new Reportes();
	                    frame.setVisible(true);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	    }

	    public Reportes() {
	    	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	         setBounds(100, 100, 800, 600); // Ajusta el tamaño según tus necesidades
	         contentPane = new JPanel();
	         contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	         setContentPane(contentPane);
	         contentPane.setLayout(new BorderLayout(0, 0));

	         JLabel lblNewLabel = new JLabel("Reportes");
	         lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	         lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
	         contentPane.add(lblNewLabel, BorderLayout.NORTH);

	         JScrollPane scrollPane = new JScrollPane();
	         contentPane.add(scrollPane, BorderLayout.CENTER);

	         textAreaBecados = new JTextArea();
	         textAreaBecados.setEditable(false);
	         scrollPane.setViewportView(textAreaBecados);

	         JButton btnCerrar = new JButton("Cerrar Reportes");
	         btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
	         btnCerrar.addActionListener(e -> dispose()); // Cierra la ventana actual de reportes
	         contentPane.add(btnCerrar, BorderLayout.SOUTH);
	     }

	     void mostrarBecados(ArrayList<String> estudiantesBecados) {
	         StringBuilder sb = new StringBuilder();
	         sb.append("Estudiantes Becados:\n");

	         for (String nombre : estudiantesBecados) {
	             sb.append(nombre).append("\n");
	         }

	         textAreaBecados.setText(sb.toString());
	     }
	 }